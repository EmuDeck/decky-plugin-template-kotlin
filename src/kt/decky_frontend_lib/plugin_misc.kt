@file:Suppress("unused")
package decky_frontend_lib

typealias RoutePatch = (dynamic) -> dynamic
typealias DefinePluginFn = (serverAPI: ServerAPI) -> Plugin

val <TRes> ServerResponse<TRes>.asResult: Result<TRes>
	get()
	{
		return if (this.success)
			Result.success(this.result)
		else
			Result.failure(Error(this.result.asDynamic() as String))
	}