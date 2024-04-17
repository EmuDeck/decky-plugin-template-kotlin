import asyncio
import os
import pathlib
import subprocess

# The decky plugin module is located at decky-loader/plugin
# For easy intellisense checkout the decky-loader code one directory up
# or add the `decky-loader/plugin` path to `python.analysis.extraPaths` in `.vscode/settings.json`
import decky_plugin

HOME_DIR = str(pathlib.Path(os.getcwd()).parent.parent.resolve())
PARENT_DIR = str(pathlib.Path(__file__).parent.resolve())


class Plugin:
    backend_proc = None

    # A normal method. It can be called from JavaScript using call_plugin_function("method_1", argument1, argument2)
    async def add(self, left, right):
        return left + right

    # Asyncio-compatible long-running code, executed in a task when the plugin is loaded
    async def _main(self):
        decky_plugin.logger.info("Hello World!")
        env_proc = dict(os.environ)
        if "LD_LIBRARY_PATH" in env_proc:
            env_proc["LD_LIBRARY_PATH"] += ":" + PARENT_DIR + "/bin"
        else:
            env_proc["LD_LIBRARY_PATH"] = ":" + PARENT_DIR + "/bin"

        if os.path.exists(f"{PARENT_DIR}/bin/backend.jar") and os.path.exists(f"{PARENT_DIR}/bin/jvm"):
            self.backend_proc = subprocess.Popen(
                [f"{PARENT_DIR}/bin/jvm/bin/java", f"-agentlib:native-image-agent=config-output-dir={PARENT_DIR}/dump",
                 "-jar", f"{PARENT_DIR}/bin/backend.jar"],
                env=env_proc)
        else:
            self.backend_proc = subprocess.Popen(
                [PARENT_DIR + "/bin/backend"],
                env=env_proc)
        while self.backend_proc.poll() is None:
            await asyncio.sleep(1)

    # Function called first during the unload process, utilize this to handle your plugin being removed
    async def _unload(self):
        decky_plugin.logger.info("Goodbye World!")
        self.backend_proc.kill()
        pass

    # Migrations that should be performed before entering `_main()`.
    async def _migration(self):
        decky_plugin.logger.info("Migrating")
        # Here's a migration example for logs:
        # - `~/.config/decky-template/template.log` will be migrated to `decky_plugin.DECKY_PLUGIN_LOG_DIR/template.log`
        decky_plugin.migrate_logs(os.path.join(decky_plugin.DECKY_USER_HOME,
                                               ".config", "decky-template", "template.log"))
        # Here's a migration example for settings:
        # - `~/homebrew/settings/template.json` is migrated to `decky_plugin.DECKY_PLUGIN_SETTINGS_DIR/template.json`
        # - `~/.config/decky-template/` all files and directories under this root are migrated to `decky_plugin.DECKY_PLUGIN_SETTINGS_DIR/`
        decky_plugin.migrate_settings(
            os.path.join(decky_plugin.DECKY_HOME, "settings", "template.json"),
            os.path.join(decky_plugin.DECKY_USER_HOME, ".config", "decky-template"))
        # Here's a migration example for runtime data:
        # - `~/homebrew/template/` all files and directories under this root are migrated to `decky_plugin.DECKY_PLUGIN_RUNTIME_DIR/`
        # - `~/.local/share/decky-template/` all files and directories under this root are migrated to `decky_plugin.DECKY_PLUGIN_RUNTIME_DIR/`
        decky_plugin.migrate_runtime(
            os.path.join(decky_plugin.DECKY_HOME, "template"),
            os.path.join(decky_plugin.DECKY_USER_HOME, ".local", "share", "decky-template"))
