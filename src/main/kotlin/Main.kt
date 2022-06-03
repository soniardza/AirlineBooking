import data.aircraft.AirCraftLocalSource
import data.airport.AirportLocalSource
import data.airportbook.AirportBookingLocalSource
import data.flight.FlightLocalSource
import data.ticket.TicketListSingleton
import domain.usecases.flight.GetFlightSaved
import domain.usecases.flight.GetFlights
import domain.usecases.flight.di.FlightDataDI
import domain.usecases.ticket.AssignFlightToTicket
import domain.usecases.ticket.di.TicketDataDI
import presentation.flight.formats.FlightConsoleFormat
import java.time.Month

fun main() {
    val ticketData = TicketDataDI().providesTicketsData()

    // Empezar aquí y luego ir para atrás
    val getFlights = GetFlights(
        FlightDataDI().providesFlightsData()
    ).invoke(Month.JANUARY)

    var flightOption = ""
    do {
        // mostrar la lista de flights
        getFlights.forEach { (index, flight) ->
            print("$index. ")
            println(FlightConsoleFormat().format(flight))
        }
        println("*** Select Number Option ***")
        flightOption = readLine().orEmpty()

        val isNumber = flightOption.all { it.isDigit() }
        val isValidOption = isNumber && getFlights.containsKey(flightOption.toInt())

    } while (flightOption.isBlank() || flightOption.isEmpty() || !isValidOption)
    println("Option selected: $flightOption")

    println("*** Flight Selected ***")
    val flight = getFlights[flightOption.toInt()]
    AssignFlightToTicket(ticketData).invoke(flight)

    val flightSelected = GetFlightSaved(ticketData).invoke()
    println(
        FlightConsoleFormat().format(flightSelected)
    )


}