package presentation.menu

import presentation.extfunction.isBlankOrEmpty

interface UIInputData {

    fun requestField(fieldName: String): String {
        var field = ""
        do {
            println("Introduce your Name")
            field = readLine().orEmpty()
        } while (field.isBlankOrEmpty())

        return field
    }
}