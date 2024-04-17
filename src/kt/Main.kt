@file:OptIn(ExperimentalJsExport::class)

import decky_frontend_lib.ServerAPI
import decky_frontend_lib.custom_components.Emotion
import decky_frontend_lib.deck_components.*
import decky_frontend_lib.definePlugin
import emotion.react.css
import js.objects.jso
import react.FC
import react.Props
import react.create
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.img
import react_icons.fa.FaShip
import web.cssom.*
import web.window.window
import yasdpl.Logger
import yasdpl.ServiceRegistry
import yasdpl.WebsocketClient

@JsModule("../../assets/logo.png")
external val logo: dynamic

object TemplateClient : WebsocketClient(6969)
{
	val logger = Logger(this, "TemplateClient")
	override fun ServiceRegistry.initServices() = Unit

}

external interface ContentProps : Props
{
	var serverAPI: ServerAPI
}

val Content = FC<ContentProps> {
	Emotion {
		PanelSection {
			title = "Panel Section"
			PanelSectionRow {
				ButtonItem {
					layout = ItemLayout.below
					onClick = { e ->
						showContextMenu(
							Menu.create {
								label = "Menu"
								cancelText = "CAAAANCEL"
								onCancel = {

								}
								MenuItem {
									onSelected = {

									}
									+"Item #1"
								}
								MenuItem {
									onSelected = {

									}
									+"Item #2"
								}
								MenuItem {
									onSelected = {

									}
									+"Item #3"
								}
							},
							e.currentTarget ?: window
						)
					}
					+"Server says yolo"
				}
			}
			PanelSectionRow {
				div {
					css {
						display = Display.flex
						justifyContent = JustifyContent.center
					}
					img {
						src = logo
					}
				}
			}
			PanelSectionRow {
				ButtonItem {
					layout = ItemLayout.below
					onClick = {
						Navigation.CloseSideMenus()
						Navigation.Navigate("/decky-plugin-kotlin-test")
					}
					+"Router"
				}
			}
		}
	}
}

val DeckyPluginKotlinRouterTest = FC<Props> {
	Emotion {
		div {
			css {
				marginTop = 50.px
				color = Color("white")
			}
			+"Hello World!"
			DialogButton {
				onClick = {
					Navigation.NavigateToLibraryTab()
				}
				+"Go to Library"
			}
		}
	}
}

@JsExport
val plugin = definePlugin { serverAPI ->
	serverAPI.routerHook.addRoute("/decky-plugin-kotlin-test", DeckyPluginKotlinRouterTest)
	TemplateClient.init()
	jso {
		title = div.create {
			className = ClassName(staticClasses.Title)
			+"Example Kotlin Plugin"
		}
		icon = FaShip.create()
		content = Content.create {
			this.serverAPI = serverAPI
		}
		onDismount = {
			serverAPI.routerHook.removeRoute("/decky-plugin-kotlin-test")
			TemplateClient.close()
		}
	}
}
