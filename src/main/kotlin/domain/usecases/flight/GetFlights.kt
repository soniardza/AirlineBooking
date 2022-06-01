package domain.usecases.flight

import domain.datasource.flight.FlightDataSource
import domain.model.AirCraft
import domain.model.Airport
import domain.model.AirportBooking
import domain.model.Flight
import domain.utils.Formatter
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month

/**
 * 1. Mostrar los vuelos disponibles de un mes
 **/
class GetFlights(
    private val flightDataSource: FlightDataSource
) {

    fun invoke(month: Month): Map<Int, Flight> =
        flightDataSource
            .getFlights()
            .filter { flightEntry ->
                flightEntry.value.departureArrivalBooking.first.dateTime.month == month
            }
}