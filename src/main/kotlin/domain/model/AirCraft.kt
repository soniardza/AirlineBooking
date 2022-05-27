package domain.model

import domain.model.seat.SeatSection

data class AirCraft(
    val name: String,
    val model: String,
    val airline: Airline = Airline("VL", "Volarios"),
    //val seatSections: Map<Int, SeatSection>
)
