package presentation.seat.section

import domain.model.seat.SeatSection
import presentation.utils.Formatter
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.seat.section.format.SeatSectionConsoleFormat

class SeatSectionPresentationFactory : PresentationFactory<SeatSection> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<SeatSection> {
        return SeatSectionConsoleFormat()
    }
}