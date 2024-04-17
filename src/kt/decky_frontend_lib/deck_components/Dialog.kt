@file:Suppress("unused", "PropertyName")
@file:JsModule("decky-frontend-lib")
@file:JsNonModule
package decky_frontend_lib.deck_components

import react.*
import web.form.SubmitEvent
import web.html.HTMLDivElement
import web.uievents.MouseEvent
import web.uievents.PointerEvent
import web.uievents.TouchEvent

external interface DialogCommonProps : PropsWithRef<HTMLDivElement>, PropsWithStyle, PropsWithClassName, PropsWithChildren

external interface DialogButtonProps : DialogCommonProps, FooterLegendProps
{
	/**
	 * Enables/disables the focus around the button.
	 *
	 * @note
	 * Default value depends on context, so setting it to `false` will enable it.
	 */
	var noFocusRing: Boolean?

	/**
	 * Disables the button - assigned `on*` methods will not be invoked if clicked.
	 *
	 * @note
	 * Depending on where it is, it might still get focus. In such case it can be
	 * partially disabled separately.
	 *
	 * @see focusable
	 */
	var disabled: Boolean?

	/**
	 * Enables/disables the navigation based focus on button - you won't be able to navigate to
	 * it via the gamepad or keyboard.
	 *
	 * @note
	 * If set to `false`, it still can be clicked and **WILL** become focused until navigated away.
	 * Depending on the context of where the button is, even a disabled button can be focused.
	 */
	var focusable: Boolean?
	var onClick: ((e: MouseEvent) -> Unit)?
	var onPointerDown: ((e: PointerEvent) -> Unit)?
	var onPointerUp: ((e: PointerEvent) -> Unit)?
	var onPointerCancel: ((e: PointerEvent) -> Unit)?
	var onMouseDown: ((e: MouseEvent) -> Unit)?
	var onMouseUp: ((e: MouseEvent) -> Unit)?
	var onTouchStart: ((e: TouchEvent) -> Unit)?
	var onTouchEnd: ((e: TouchEvent) -> Unit)?
	var onTouchCancel: ((e: TouchEvent) -> Unit)?
	var onSubmit: ((e: SubmitEvent) -> Unit)?
}

external val DialogHeader: FC<DialogCommonProps>
external val DialogSubHeader: FC<DialogCommonProps>
external val DialogFooter: FC<DialogCommonProps>
external val DialogLabel: FC<DialogCommonProps>
external val DialogBodyText: FC<DialogCommonProps>
external val DialogBody: FC<DialogCommonProps>
external val DialogControlsSection: FC<DialogCommonProps>
external val DialogControlsSectionHeader: FC<DialogCommonProps>
external val DialogButtonPrimary: FC<DialogButtonProps>
external val DialogButtonSecondary: FC<DialogButtonProps>
external val DialogButton: FC<DialogButtonProps>