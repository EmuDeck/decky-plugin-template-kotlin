import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val yasdplVersion: String by project

plugins {
	kotlin("multiplatform") version "1.9.23"
	kotlin("plugin.serialization") version "1.9.23"
	id("com.github.johnrengelman.shadow") version "8.1.1"
	id("io.github.turansky.seskar") version "2.44.0" apply false
	id("org.graalvm.buildtools.native") version "0.9.8"
	application
}


group = "com.emudeck"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
//	maven {
//		url = uri("./lib")
//	}
	maven {
		url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
	}
}



kotlin {
	js("frontend") {
		binaries.library()
		generateTypeScriptDefinitions()
		useCommonJs()
		browser {
			commonWebpackConfig {
				export = true
				sourceMaps = true
				outputFileName = "frontend.js"
				cssSupport {
					enabled.set(true)
				}
			}
		}
	}



	jvm("backend") {
		withJava()
	}
	sourceSets {
		val backendMain by getting {
			dependencies {

				implementation("io.github.emudeck.yasdpl:yasdpl-backend:$yasdplVersion")
			}
		}
		val backendTest by getting

		val commonMain by getting {
			dependencies {
				implementation("io.github.emudeck.yasdpl:yasdpl:$yasdplVersion")
			}
		}

		val commonTest by getting

		val frontendMain by getting {
			dependencies {
				implementation("io.github.emudeck.yasdpl:yasdpl-frontend:$yasdplVersion")
				compileOnly(devNpm("decky-frontend-lib", "^3.24.5"))
				compileOnly(devNpm("react", "18.2.0"))
				compileOnly(devNpm("react-dom", "18.2.0"))
				implementation("org.jetbrains.kotlin-wrappers:kotlin-react:18.2.0-pre.729") {
					isTransitive = false
				}
				implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:18.2.0-pre.729") {
					isTransitive = false
				}
				implementation("org.jetbrains.kotlin-wrappers:kotlin-react-core:18.2.0-pre.729") {
					isTransitive = false
				}
				implementation("org.jetbrains.kotlin-wrappers:kotlin-csstype:3.1.3-pre.729")
				implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion:11.11.4-pre.730") {
					isTransitive = false
				}
				implementation("io.github.turansky.seskar:seskar-core:2.44.0")

			}
			kotlin {
				setSrcDirs(listOf("../src/kt"))
			}
		}

		val frontendTest by getting

	}
}

configurations {
	val jsMainImplementation by creating
	val frontendMainImplementation by getting {
		extendsFrom(jsMainImplementation)
	}
}

apply(plugin = "io.github.turansky.seskar")

application {
	mainClass.set("MainKt")
}

tasks.withType<ShadowJar> {
	archiveFileName.set("backend.jar")
}

graalvmNative {
	binaries {
		named("main") {
			fallback.set(false)
			verbose.set(true)

			buildArgs.add("--initialize-at-build-time=ch.qos.logback")
			buildArgs.add("--initialize-at-build-time=io.ktor,kotlin")
			buildArgs.add("--initialize-at-build-time=org.slf4j.LoggerFactory")
			buildArgs.add("--initialize-at-run-time=io.ktor.serialization.kotlinx.json.JsonSupportKt")

			buildArgs.add("-H:+InstallExitHandlers")
			buildArgs.add("-H:+ReportUnsupportedElementsAtRuntime")
			buildArgs.add("-H:+ReportExceptionStackTraces")

			imageName.set("backend")
		}
	}
}