@file:Suppress("unused", "PropertyName", "ClassName")
@file:JsModule("decky-frontend-lib")
@file:JsNonModule
package decky_frontend_lib.util

external fun fakeRenderComponent(`fun`: () -> dynamic, customHooks: dynamic = definedExternally): dynamic
external fun wrapReactType(node: dynamic, prop: dynamic = definedExternally): dynamic
external fun wrapReactClass(node: dynamic, prop: dynamic = definedExternally): dynamic
external fun getReactRoot(o: /* HTMLElement | Element | Node */ dynamic): dynamic
external fun getReactInstance(o: /* HTMLElement | Element | Node */ dynamic): dynamic

external interface findInTreeOpts
{
	val walkable: List<String>?
	val ignore: List<String>?
}

external fun findInTree(parent: dynamic, filter: findInTreeFilter, opts: findInTreeOpts): dynamic
external fun findInReactTree(node: dynamic, filter: findInTreeFilter): dynamic