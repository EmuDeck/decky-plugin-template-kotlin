@file:Suppress("unused", "PropertyName")
@file:JsModule("decky-frontend-lib")
@file:JsNonModule
package decky_frontend_lib.deck_components

import react.FC

external interface ButtonProps : DialogButtonProps

external val Button: FC<ButtonProps>