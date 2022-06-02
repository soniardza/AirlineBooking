package domain.usecases.ticket

import domain.datasource.ticket.TicketDataSource
import domain.model.Passenger
import domain.model.Ticket

/**
 * 7. Introducir Información del Pasajero
 */
class AssignPassengerToTicket(
    private val ticketDataSource: TicketDataSource
) {

    operator fun invoke(passenger: Passenger): Ticket {
        return ticketDataSource.tickets.first().apply {
            this.passenger = passenger
        }
    }
}