package presentation.ticket.formats

import domain.model.Ticket
import presentation.utils.Formatter

class TicketHTMLFormat : Formatter<Ticket> {
    override fun format(ticket: Ticket): String {
        return """
<p><strong>Passenger: ${ticket.passenger.name}</strong><br />
Flight Number: ${ticket.flight.number}<br />
Departure: ${ticket.flight.departureArrivalBooking.first.airport.name}<br />
Arrival: ${ticket.flight.departureArrivalBooking.second.airport.name}<br />
Flight Price: $${ticket.flight.price}<br />
Baggage Plan: $//{baggagePackage.format()}<br />
Seat: ${ticket.seat.number}<br />
Total: $${ticket.totalPrice}<br />
</p>
        """.trimIndent()
    }
}