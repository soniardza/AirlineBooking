import domain.model.Flight
import domain.usecases.flight.GetFlightSaved
import domain.usecases.flight.GetFlights
import domain.usecases.flight.di.FlightDataDI
import domain.usecases.ticket.AssignFlightToTicket
import domain.usecases.ticket.di.TicketDataDI
import presentation.PresentationFormat
import presentation.flight.FlightPresentationFactory
import presentation.flight.formats.FlightConsoleFormat
import presentation.menu.UIMenu
import java.time.Month

fun main() {
    val format = PresentationFormat.CONSOLE
    val flightPresentation = FlightPresentationFactory().getPresentationFormat(format)
    val ticketData = TicketDataDI().providesTicketsData()
    val flightData = FlightDataDI().providesFlightsData()

    val uiMenuFlight = object : UIMenu<Flight> { }
    val flightMap = GetFlights(flightData).invoke(Month.JANUARY)
    val flightSelected = uiMenuFlight.showMenu(flightMap, flightPresentation)


    AssignFlightToTicket(ticketData).invoke(flightSelected)

    val flightSaved = GetFlightSaved(ticketData).invoke()
    println(
        FlightConsoleFormat().format(flightSaved)
    )


}