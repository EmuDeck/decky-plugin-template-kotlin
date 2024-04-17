@file:Suppress("unused", "PropertyName")
@file:JsModule("decky-frontend-lib")
@file:JsNonModule
package decky_frontend_lib.deck_components

import react.PropsWithChildren
import react.ReactNode

external interface ItemProps : PropsWithChildren
{
	var label: ReactNode?
	var description: ReactNode?
	var layout: ItemLayout?
	var icon: ReactNode?
	var bottomSeparator: ItemBottomSeparator?
	var indentLevel: Number?
	var tooltip: String?
	var highlightOnFocus: Boolean?
}