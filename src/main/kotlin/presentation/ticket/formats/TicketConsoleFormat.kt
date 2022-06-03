package presentation.ticket.formats

import domain.model.Ticket
import domain.model.baggage.pack.BaggagePackage
import presentation.utils.Formatter

class TicketConsoleFormat(
    private val baggagePackage: Formatter<BaggagePackage>
) : Formatter<Ticket> {
    override fun format(ticket: Ticket): String {
        return """
Passenger: ${ticket.passenger.name}
Flight Number: ${ticket.flight.number}
Departure: ${ticket.flight.departureArrivalBooking.first.airport.name}
Arrival: ${ticket.flight.departureArrivalBooking.second.airport.name}
Flight Price: $${ticket.flight.price}
Seat: ${ticket.seat.number}
Baggage Plan: ${baggagePackage.format(ticket.baggagePackage)}
Total: $${ticket.totalPrice}
            
        """.trimIndent()
    }
}