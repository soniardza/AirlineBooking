package presentation.extfunction

import domain.model.Flight

fun String.isNotBlankOrEmpty(): Boolean {
    return this.isNotBlank() || this.isNotEmpty()
}
fun String.isNumber(): Boolean {
    return this.all { it.isDigit() }
}

fun String.isMenuOptionValid(flightNap: Map<Int, Flight>): Boolean {
    return if (isNotBlankOrEmpty()) {
        val isValidOption = isNumber() && flightNap.containsKey(this.toInt())
        return isValidOption
    } else false

}