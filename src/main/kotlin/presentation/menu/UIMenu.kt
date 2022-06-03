package presentation.menu

import presentation.utils.Formatter
import presentation.extfunction.isMenuOptionValid
interface UIMenu<T> {

    fun showMenu(
        mapObjects: Map<Int, T>,
        formatter: Formatter<T>
    ): T? {
        var option = ""
        do {
            // mostrar la lista de objetos
            mapObjects.forEach { (index, flight) ->
                print("$index. ")
                println(formatter.format(flight))
            }
            println("*** Select Number Option ***")
            option = readLine().orEmpty()

        } while (!option.isMenuOptionValid(mapObjects))

        return mapObjects[option.toInt()]
    }
}