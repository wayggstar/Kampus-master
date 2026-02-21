package org.wayggstar.kampus.exceptions

open class KampusException(
    override val message: String,
    val errorCode: String = "COMMON_ERROR"
): RuntimeException(message) {
}