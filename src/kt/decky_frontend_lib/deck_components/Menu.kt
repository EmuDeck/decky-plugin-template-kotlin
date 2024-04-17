@file:Suppress("unused", "PropertyName")
@file:JsModule("decky-frontend-lib")
@file:JsNonModule
package decky_frontend_lib.deck_components

import react.FC
import react.PropsWithChildren
import react.ReactNode
import web.events.Event
import web.events.EventTarget
import web.uievents.MouseEvent

external fun showContextMenu(children: ReactNode, parent: EventTarget? = definedExternally)

external interface MenuProps : FooterLegendProps, PropsWithChildren
{
	var label: String
	var onCancel: (() -> Unit)?
	var cancelText: String?
}

external val Menu: FC<MenuProps>

external interface MenuGroupProps : PropsWithChildren
{
	var label: String
	var disabled: Boolean?
}

external val MenuGroup: FC<MenuGroupProps>

external interface MenuItemProps : FooterLegendProps, PropsWithChildren
{
	var bInteractableItem: Boolean?
	var onClick: ((evt: Event) -> Unit)?
	var onSelected: ((evt: Event) -> Unit)?
	var onMouseEnter: ((evt: MouseEvent) -> Unit)?
	var onMoveRight: (() -> Unit)?
	var selected: Boolean?
	var disabled: Boolean?
	var bPlayAudio: Boolean?
	var tone: MenuItemTone?
}

external val MenuItem: FC<MenuItemProps>

