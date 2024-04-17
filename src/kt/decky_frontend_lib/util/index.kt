@file:Suppress("unused", "PropertyName", "ClassName")
@file:JsModule("decky-frontend-lib")
@file:JsNonModule
package decky_frontend_lib.util

import web.window.Window
import kotlin.js.Promise

external fun joinClassNames(vararg classes: String): String
external fun sleep(ms: Number): Promise<dynamic>
/**
 * Finds the SP window, since it is a render target as of 10-19-2022's beta
 */
external fun findSP(): Window
/**
 * Gets the correct FocusNavController, as the Feb 22 2023 beta has two for some reason.
 */
external fun getFocusNavController(): dynamic
/**
 * Gets the gamepad navigation trees as Valve seems to be moving them.
 */
external fun getGamepadNavigationTrees(): dynamic