@file:Suppress("unused")
package decky_frontend_lib.util

import org.w3c.dom.Window

val Window.FocusNavController: dynamic
	get() = asDynamic()["FocusNavController"]
val Window.GamepadNavTree: dynamic
	get() = asDynamic()["GamepadNavTree"]