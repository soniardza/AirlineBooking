import domain.model.*
import domain.model.baggage.pack.regular.RegularBasic
import domain.model.seat.Seat
import domain.model.seat.SeatClass
import domain.model.seat.SeatStatus
import domain.usecases.GetFlights
import presentation.flight.FlightConsoleFormat
import presentation.ticket.TicketConsoleFormat
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month

fun main() {

    val getFlights = GetFlights(FlightConsoleFormat())
    val flightFormat = getFlights.invoke()
    println(flightFormat)

}