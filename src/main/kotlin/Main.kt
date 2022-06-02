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
    getFlights.forEach { (index, flight) ->
        print("$index. ")
        println(FlightConsoleFormat().format(flight))
    }

    println("*** Flight Selected ***")
    val flight = getFlights[1]
    AssignFlightToTicket(ticketData).invoke(flight)

    val flightSelected = GetFlightSaved(ticketData).invoke()
    println(
        FlightConsoleFormat().format(flightSelected)
    )


}