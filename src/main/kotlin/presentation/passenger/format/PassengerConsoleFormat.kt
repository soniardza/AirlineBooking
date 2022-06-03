package presentation.passenger.format

import domain.model.Passenger
import domain.utils.Formatter

class PassengerConsoleFormat : Formatter<Passenger> {

    override fun format(t: Passenger): String {
        return """
            Name: ${t.name}
            Email: ${t.email}
            Phone: ${t.phone}
        """.trimIndent()
    }
}