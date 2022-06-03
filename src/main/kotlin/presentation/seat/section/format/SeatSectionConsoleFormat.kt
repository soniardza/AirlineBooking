package presentation.seat.section.format

import domain.model.seat.SeatSection
import presentation.utils.Formatter

class SeatSectionConsoleFormat : Formatter<SeatSection> {
    override fun format(seatSection: SeatSection): String {
        return """
            Seat Class: ${seatSection.seatClass.name}
            Price $${seatSection.price}
            
        """.trimIndent()
    }


}