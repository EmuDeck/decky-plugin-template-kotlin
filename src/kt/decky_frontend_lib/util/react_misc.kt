@file:Suppress("unused")
package decky_frontend_lib.util

import org.w3c.dom.Window

typealias findInTreeFilter = (element: dynamic) -> Boolean

val Window.SP_REACT: dynamic
	get() = this.asDynamic()["SP_REACT"]