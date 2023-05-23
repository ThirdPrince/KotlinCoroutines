package channel

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import utils.log

suspend fun main() {
    val channel = Channel<Int>()
    val producer = GlobalScope.launch {
        var i = 0
        while (true){
            channel.send(i++)
            delay(1000)
        }
    }

    val consumer = GlobalScope.launch {
        while (true){
            val element = channel.receive()
            log(element)
        }
    }
    producer.join()
    consumer.join()
}