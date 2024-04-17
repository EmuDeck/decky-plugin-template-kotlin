@file:Suppress("unused", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
package decky_frontend_lib.deck_components

import seskar.js.JsValue
import seskar.js.JsVirtual

@JsVirtual
sealed external interface MenuItemTone
{
	companion object
	{
		@JsValue("positive")
		val positive: MenuItemTone

		@JsValue("emphasis")
		val emphasis: MenuItemTone

		@JsValue("destructive")
		val destructive: MenuItemTone
	}
}