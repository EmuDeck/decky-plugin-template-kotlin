@file:Suppress("unused", "PropertyName")
@file:JsModule("decky-frontend-lib")
@file:JsNonModule
package decky_frontend_lib

external var webpackCache: dynamic
external val allModules: List<dynamic>
external fun findModule(filter: FilterFn): dynamic
external fun findModuleChild(filter: FilterFn): dynamic
external fun findAllModules(filter: FilterFn): List<dynamic>
external val CommonUIModule: dynamic
external val IconsModule: dynamic
external val ReactRouter: dynamic
