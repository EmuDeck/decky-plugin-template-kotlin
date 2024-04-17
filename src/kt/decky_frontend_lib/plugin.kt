@file:Suppress("unused", "PropertyName")
@file:JsModule("decky-frontend-lib")
@file:JsNonModule

package decky_frontend_lib

import react.ComponentType
import react.Props
import react.ReactElement
import react.ReactNode
import web.file.File
import web.http.Request
import web.http.RequestInit
import kotlin.js.Promise
import kotlin.js.RegExp

external interface Plugin
{
	var title: ReactElement<out Props>
	var icon: ReactElement<out Props>
	var content: ReactElement<out Props>?
	var onDismount: (() -> Unit)?
}

external interface ServerResponse<TRes>
{
	val success: Boolean
	val result: TRes /* TRes | string */
}

external interface RouterHook
{
	fun <TProps : Props> addRoute(path: String, component: ComponentType<TProps>, props: TProps? = definedExternally)
	fun addPatch(path: String, patch: RoutePatch): RoutePatch
	fun addGlobalComponent(name: String, component: ComponentType<Props>)

	fun removeRoute(path: String)
	fun removePatch(path: String, patch: RoutePatch)
	fun removeGlobalComponent(path: String)
}

external interface ToastData
{
	var title: ReactNode
	var body: ReactNode
	var onClick: (() -> Unit)?
	var logo: ReactNode?
	var icon: ReactNode?
	var className: String?
	var contentClassName: String?
	var duration: Number?
	var critical: Boolean?
	var eType: Number?
	var sound: Number?
	var playSound: Boolean?
	var showToast: Boolean?
}

external interface Toaster
{
	fun toast(toast: ToastData)
}

external interface FilePickerRes
{
	val path: String
	val realpath: String
}

@Suppress("ENUM_CLASS_IN_EXTERNAL_DECLARATION_WARNING")
external enum class FileSelectionType
{
	FILE,
	FOLDER
}

external interface ServerAPI
{
	val routerHook: RouterHook
	val toaster: Toaster
	fun openFilePicker(startPath: String, includeFiles: Boolean? = definedExternally, regex: RegExp? = definedExternally): Promise<FilePickerRes>
	fun openFilePickerV2(
		select: FileSelectionType,
		startPath: String,
		includeFiles: Boolean? = definedExternally,
		includeFolders: Boolean? = definedExternally,
		filter: RegExp? = definedExternally,
		extensions: List<String>? = definedExternally,
		showHiddenFiles: Boolean? = definedExternally,
		allowAllFiles: Boolean? = definedExternally,
		max: Number?
	): Promise<FilePickerRes>
	fun openFilePickerV2(
		select: FileSelectionType,
		startPath: String,
		includeFiles: Boolean? = definedExternally,
		includeFolders: Boolean? = definedExternally,
		filter: ((file: File) -> Boolean)? = definedExternally,
		extensions: List<String>? = definedExternally,
		showHiddenFiles: Boolean? = definedExternally,
		allowAllFiles: Boolean? = definedExternally,
		max: Number?
	): Promise<FilePickerRes>
	fun <TArgs, TRes> callPluginMethod(methodName: String, args: TArgs): Promise<ServerResponse<TRes>>
	fun <TArgs, TRes> callServerMethod(methodName: String, args: TArgs): Promise<ServerResponse<TRes>>
	fun <TRes> fetchNoCors(url: Request, request: RequestInit? = definedExternally): Promise<ServerResponse<TRes>>
	fun <TRes> fetchNoCors(url: String, request: RequestInit? = definedExternally): Promise<ServerResponse<TRes>>
	fun executeInTab(tab: String, runAsync: Boolean, code: String): Promise<dynamic>
	fun <TRes /*= String*/> injectCssIntoTab(tab: String, style: String): Promise<ServerResponse<TRes>>
	fun removeCssFromTab(tab: String, cssId: String): Promise<dynamic>
}

external fun definePlugin(fn: DefinePluginFn): DefinePluginFn

