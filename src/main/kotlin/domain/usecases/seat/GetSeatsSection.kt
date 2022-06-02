package domain.usecases.seat

import domain.model.seat.SeatSection
import domain.usecases.flight.GetFlightSaved

/**
 * 5. Mostrar los asientos  disponibles
 */
class GetSeatsSection(
    private val getFlightSaved: GetFlightSaved
) {
    operator fun invoke(): Map<Int, SeatSection> {
        val flight = getFlightSaved()
        val seatSectionsMap = flight
            ?.airCraft
            ?.seatSections
            ?.mapIndexed { index, seatSection ->
                index + 1 to seatSection
            }?.toMap()

        return seatSectionsMap ?: mapOf()
    }
}