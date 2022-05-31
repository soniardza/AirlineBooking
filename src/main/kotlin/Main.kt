import domain.model.*
import domain.usecases.flight.GetFlights
import domain.utils.Formatter
import presentation.PresentationFormat
import presentation.flight.FlightPresentationFactory

fun main() {
    val format = PresentationFormat.CONSOLE
    val flightFormat: Formatter<Flight> = FlightPresentationFactory().getPresentationFormat(format)
    val flights = GetFlights(flightFormat).invoke()
    println(flights)


}