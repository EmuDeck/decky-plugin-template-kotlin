@file:Suppress("unused", "PropertyName")
@file:JsModule("decky-frontend-lib")
@file:JsNonModule
package decky_frontend_lib.deck_components

import react.FC
import web.uievents.MouseEvent

external interface ButtonItemProps : ItemProps
{
	var onClick: ((e: MouseEvent) -> Unit)?
	var disabled: Boolean?
}

external val ButtonItem: FC<ButtonItemProps>
