@file:Suppress("unused", "PropertyName")
@file:JsModule("decky-frontend-lib")
@file:JsNonModule
package decky_frontend_lib.deck_components

import react.FC
import react.PropsWithChildren

external val Panel: FC<PropsWithChildren>

external interface PanelSectionProps : PropsWithChildren
{
	var title: String?
	var spinner: Boolean?
}

external val PanelSection: FC<PanelSectionProps>

external interface PanelSectionRowProps : PropsWithChildren

external val PanelSectionRow: FC<PanelSectionRowProps>