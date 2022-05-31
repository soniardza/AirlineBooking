import domain.model.*
import domain.model.baggage.pack.regular.RegularBasic
import domain.model.seat.Seat
import domain.model.seat.SeatClass
import domain.model.seat.SeatStatus
import domain.usecases.GetFlights
import domain.utils.Formatter
import presentation.PresentationFormat
import presentation.flight.FlightConsoleFormat
import presentation.flight.FlightPresentationFactory
import presentation.ticket.TicketConsoleFormat
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month

fun main() {
    val format = PresentationFormat.CONSOLE
    val flightFormat: Formatter<Flight> = FlightPresentationFactory().getPresentationFormat(format)
    val flights = GetFlights(flightFormat).invoke()
    println(flights)


}