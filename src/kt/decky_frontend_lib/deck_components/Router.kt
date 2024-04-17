@file:Suppress("unused", "PropertyName", "ENUM_CLASS_IN_EXTERNAL_DECLARATION_WARNING", "FunctionName")
@file:JsModule("decky-frontend-lib")
@file:JsNonModule
package decky_frontend_lib.deck_components

import org.w3c.dom.Window

external enum class SideMenu
{
	None,
	Main,
	QuickAccess
}

external enum class QuickAccessTab
{
	Notifications,
	RemotePlayTogetherControls,
	VoiceChat,
	Friends,
	Settings,
	Perf,
	Help,
	Music,
	Decky
}

external enum class DisplayStatus
{
	Invalid,
	Launching,
	Uninstalling,
	Installing,
	Running,
	Validating,
	Updating,
	Downloading,
	Synchronizing,
	ReadyToInstall,
	ReadyToPreload,
	ReadyToLaunch,
	RegionRestricted,
	PresaleOnly,
	InvalidPlatform,
	PreloadComplete,
	BorrowerLocked,
	UpdatePaused,
	UpdateQueued,
	UpdateRequired,
	UpdateDisabled,
	DownloadPaused,
	DownloadQueued,
	DownloadRequired,
	DownloadDisabled,
	LicensePending,
	LicenseExpired,
	AvailForFree,
	AvailToBorrow,
	AvailGuestPass,
	Purchase,
	Unavailable,
	NotLaunchable,
	CloudError,
	CloudOutOfDate,
	Terminating
}

external interface AppOverview {
	var appid: String
	var display_name: String
	var display_status: DisplayStatus
	var sort_as: String
}

external interface MenuStore {
	fun OpenSideMenu(sideMenu: SideMenu)
	fun OpenQuickAccessMenu(quickAccessTab: QuickAccessTab? = definedExternally)
	fun OpenMainMenu()
}
external interface WindowRouter {
	var BrowserWindow: Window
	var MenuStore: MenuStore
	fun Navigate(path: String)
	fun NavigateToChat()
	fun NavigateToSteamWeb(url: String)
	fun NavigateBack()
}
external interface WindowStore {
	var GamepadUIMainWindowInstance: WindowRouter?
	var SteamUIWindows: List<WindowRouter>
	var OverlayWindows: List<WindowRouter>
}
external interface RouterInterface {
	var WindowStore: WindowStore?
	fun CloseSideMenus()
	fun Navigate(path: String)
	fun NavigateToAppProperties()
	fun NavigateToExternalWeb(url: String)
	fun NavigateToInvites()
	fun NavigateToChat()
	fun NavigateToLibraryTab()
	fun NavigateToLayoutPreview(e: dynamic)
	fun OpenPowerMenu(unknown: dynamic = definedExternally)
	val RunningApps: List<AppOverview>
	val MainRunningApp: AppOverview?
}
external val Router: RouterInterface

external interface NavigationInterface
{
	fun Navigate(path: String)
	fun NavigateBack()
	fun NavigateToAppProperties()
	fun NavigateToExternalWeb(url: String)
	fun NavigateToInvites()
	fun NavigateToChat()
	fun NavigateToLibraryTab()
	fun NavigateToLayoutPreview(e: dynamic)
	fun NavigateToSteamWeb(url: String)
	fun OpenSideMenu(sideMenu: SideMenu)
	fun OpenQuickAccessMenu(quickAccessTab: QuickAccessTab? = definedExternally)
	fun OpenMainMenu()
	fun OpenPowerMenu(unknown: dynamic = definedExternally)
	fun CloseSideMenus()
}
external var Navigation: NavigationInterface