@file:Suppress("unused", "PropertyName", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
package decky_frontend_lib.deck_components

import seskar.js.JsValue
import seskar.js.JsVirtual

@JsVirtual
sealed external interface ItemLayout
{
	companion object
	{
		@JsValue("below")
		val below: ItemLayout

		@JsValue("inline")
		val inline: ItemLayout
	}
}

@JsVirtual
sealed external interface ItemBottomSeparator
{
	companion object
	{
		@JsValue("standard")
		val standard: ItemBottomSeparator

		@JsValue("thick")
		val thick: ItemBottomSeparator

		@JsValue("none")
		val none: ItemBottomSeparator
	}
}