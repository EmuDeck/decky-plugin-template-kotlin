@file:Suppress("unused", "PropertyName", "ENUM_CLASS_IN_EXTERNAL_DECLARATION_WARNING", "FunctionName")
@file:JsModule("decky-frontend-lib")
@file:JsNonModule
package decky_frontend_lib.deck_components

import react.ReactNode

external enum class GamepadButton {
	INVALID,
	OK,
	CANCEL,
	SECONDARY,
	OPTIONS,
	BUMPER_LEFT,
	BUMPER_RIGHT,
	TRIGGER_LEFT,
	TRIGGER_RIGHT,
	DIR_UP,
	DIR_DOWN,
	DIR_LEFT,
	DIR_RIGHT,
	SELECT,
	START,
	LSTICK_CLICK,
	RSTICK_CLICK,
	LSTICK_TOUCH,
	RSTICK_TOUCH,
	LPAD_TOUCH,
	LPAD_CLICK,
	RPAD_TOUCH,
	RPAD_CLICK,
	REAR_LEFT_UPPER,
	REAR_LEFT_LOWER,
	REAR_RIGHT_UPPER,
	REAR_RIGHT_LOWER,
	STEAM_GUIDE,
	STEAM_QUICK_MENU
}
external enum class NavEntryPositionPreferences {
	FIRST,
	LAST,
	MAINTAIN_X,
	MAINTAIN_Y,
	PREFERRED_CHILD
}
external interface GamepadEventDetail {
	var button: Number
	var is_repeat: Boolean?
	var source: Number
}

external interface FooterLegendProps {
	var actionDescriptionMap: ActionDescriptionMap?
	var onOKActionDescription: ReactNode?
	var onCancelActionDescription: ReactNode?
	var onSecondaryActionDescription: ReactNode?
	var onOptionsActionDescription: ReactNode?
	var onMenuActionDescription: ReactNode?
	var onButtonDown: ((evt: GamepadEvent) -> Unit)?
	var onButtonUp: ((evt: GamepadEvent) -> Unit)?
	var onOKButton: ((evt: GamepadEvent) -> Unit)?
	var onCancelButton: ((evt: GamepadEvent) -> Unit)?
	var onSecondaryButton: ((evt: GamepadEvent) -> Unit)?
	var onOptionsButton: ((evt: GamepadEvent) -> Unit)?
	var onGamepadDirection: ((evt: GamepadEvent) -> Unit)?
	var onGamepadFocus: ((evt: GamepadEvent) -> Unit)?
	var onGamepadBlur: ((evt: GamepadEvent) -> Unit)?
	var onMenuButton: ((evt: GamepadEvent) -> Unit)?
}