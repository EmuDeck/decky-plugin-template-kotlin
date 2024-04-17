import kotlinx.coroutines.runBlocking
import yasdpl.ServiceRegistry
import yasdpl.WebsocketServer

class TemplateServer : WebsocketServer(6969)
{
	override fun ServiceRegistry.initServices()
	{

	}
}

fun main(): Unit = runBlocking {
	val backend = TemplateServer()
	backend()
}