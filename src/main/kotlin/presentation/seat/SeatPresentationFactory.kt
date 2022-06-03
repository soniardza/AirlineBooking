package presentation.seat

import domain.model.seat.Seat
import presentation.utils.Formatter
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.seat.format.SeatConsoleFormat

class SeatPresentationFactory : PresentationFactory<Seat> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Seat> {
        return SeatConsoleFormat()
    }
}