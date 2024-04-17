package decky_frontend_lib.custom_components

import decky_frontend_lib.util.findSP
import emotion.cache.createCache
import emotion.react.CacheProvider
import js.objects.jso
import react.FC
import react.PropsWithChildren
import react.useRef
import web.dom.Node

val Emotion = FC<PropsWithChildren> { props ->
	val cache = useRef(createCache(jso {
		container = findSP().asDynamic().document.head as? Node
		key = "css"
	}))
	CacheProvider {
		value = cache.current!!
		+props.children
	}
}