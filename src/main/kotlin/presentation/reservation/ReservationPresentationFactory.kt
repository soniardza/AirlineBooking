package presentation.reservation

import domain.model.Reservation
import presentation.utils.Formatter
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.baggage.format.BaggagePackageConsoleFormat
import presentation.baggage.type.format.BaggageTypeConsoleFormat
import presentation.reservation.format.ReservationConsoleFormat
import presentation.ticket.formats.TicketConsoleFormat


class ReservationPresentationFactory : PresentationFactory<Reservation> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Reservation> {
        return ReservationConsoleFormat(
            TicketConsoleFormat(
                BaggagePackageConsoleFormat(
                    BaggageTypeConsoleFormat()
                )
            )
        )
    }


}