package domain.usecases.flight.di

import data.aircraft.AirCraftLocalSource
import data.airport.AirportLocalSource
import data.airportbook.AirportBookingLocalSource
import data.flight.FlightLocalSource
import domain.datasource.flight.FlightDataSource

class FlightDataDI {

    fun providesFlightsData(): FlightDataSource {
        val airportDataSource = AirportLocalSource()
        val airportBookingLocalSource = AirportBookingLocalSource(airportDataSource)
        val airCraftLocalSource = AirCraftLocalSource()

        return FlightLocalSource(
            airCraftLocalSource,
            airportBookingLocalSource
        )
    }
}