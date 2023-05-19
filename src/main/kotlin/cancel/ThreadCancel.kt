package cancel

import utils.log

/**
 * 线程如何取消
 */
fun main() {
    val thread = Thread(MyRunnable())
    thread.start()
    try {
        Thread.sleep(1000)
    }catch (e:InterruptedException){
        e.printStackTrace()
    }

    thread.interrupt()
}
class MyRunnable:Runnable{
    override fun run() {
       while (!Thread.currentThread().isInterrupted){
           log(1)
           try {
               Thread.sleep(1000)
           }catch (e:InterruptedException){
               e.printStackTrace()
               Thread.currentThread().interrupt()
           }
       }
    }

}