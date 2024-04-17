package decky_frontend_lib.deck_components

import js.objects.Record
import react.ReactNode
import web.events.CustomEvent

typealias ActionDescriptionMap = Record<GamepadButton, ReactNode?>

typealias GamepadEvent = CustomEvent<GamepadEventDetail>;