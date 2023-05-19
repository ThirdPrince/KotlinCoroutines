package utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * log
 * @author dhl
 */
val dateFormat = SimpleDateFormat("HH:mm:ss:SSS")

val now = {
    dateFormat.format(Date(System.currentTimeMillis()))
}

fun log(vararg msg:Any?)= println("${now()}[${Thread.currentThread().name}]${msg.joinToString(" ")}")