@file:Suppress("unused", "SpellCheckingInspection")
package decky_frontend_lib

import org.w3c.dom.Window

typealias FilterFn = (module: dynamic) -> Boolean
typealias FindFn = (module: dynamic) -> dynamic

val Window.webpackJsonp: dynamic
	get() = asDynamic()["webpackJsonp"]
val Window.webpackChunksteamui: dynamic
	get() = asDynamic()["webpackChunksteamui"]
