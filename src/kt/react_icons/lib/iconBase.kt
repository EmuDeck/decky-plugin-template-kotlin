@file:JsModule("react-icons")
@file:JsNonModule
package react_icons.lib

import js.objects.Record
import react.dom.svg.SVGAttributes
import web.svg.SVGElement

external interface IconTree
{
	val tag: String
	val attr: Record<String, String>
	val child: List<IconTree>
}

external interface IconBaseProps : SVGAttributes<SVGElement>
{
	var size: dynamic
	var title: String?
}