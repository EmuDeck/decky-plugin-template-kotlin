@file:Suppress("unused", "PropertyName", "ClassName")
@file:JsModule("decky-frontend-lib")
@file:JsNonModule
package decky_frontend_lib.util

import js.symbol.Symbol

external object callOriginal : Symbol

external interface PatchOptions
{
	val singleShot: Boolean?
}

external interface Patch
{
	val original: Function<*>
	val property: String
	val `object`: dynamic
	val patchedFunction: dynamic
	val hasUnpatched: Boolean
	val handler: GenericPatchHandler
	val unpatch: () -> Unit
}

external fun beforePatch(`object`: dynamic, property: String, handler: (args: List<dynamic>) -> dynamic, options: PatchOptions? = definedExternally): Patch
external fun afterPatch(`object`: dynamic, property: String, handler: (args: List<dynamic>, ret: dynamic) -> dynamic, options: PatchOptions? = definedExternally): Patch
external fun replacePatch(`object`: dynamic, property: String, handler: (args: List<dynamic>) -> dynamic, options: PatchOptions? = definedExternally): Patch