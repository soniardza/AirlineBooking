package presentation.ticket

import domain.model.Ticket
import domain.utils.Formatter

class TicketConsoleFormat : Formatter<Ticket> {
    override fun format(ticket: Ticket): String {
        return """
            Passenger: ${ticket.passenger.name}
            Flight Number: ${ticket.flight.number}
            Departure: ${ticket.flight.departureArrivalBooking.first.airport.name}
            Arrival: ${ticket.flight.departureArrivalBooking.second.airport.name}
            Flight Price: $${ticket.flight.price}
            Baggage Plan: $//{baggagePackage.format()}
            Seat: ${ticket.seat.number}
            Total: $${ticket.totalPrice}
            
        """.trimIndent()
    }
}