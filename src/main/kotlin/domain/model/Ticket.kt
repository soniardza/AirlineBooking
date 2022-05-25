package domain.model

import domain.model.seat.Seat

data class Ticket(
    val flight: Flight,
    val passenger: Passenger,
    val baggagePackage: Baggage,
    val seat: Seat
)
