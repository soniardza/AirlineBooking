package domain.usecases.reservation

import domain.datasource.reservation.ReservationDataSource
import domain.model.Reservation

/**
 * 8. Obtener la reservación
 */
class GetReservation(
    private val reservationDataSource: ReservationDataSource
) {
    operator fun invoke(): Reservation {
        return reservationDataSource.reservation
    }
}