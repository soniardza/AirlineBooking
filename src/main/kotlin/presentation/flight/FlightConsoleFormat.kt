package presentation.flight

import domain.model.Flight
import domain.utils.Formatter
import java.time.format.DateTimeFormatter

class FlightConsoleFormat : Formatter<Flight> {

    override fun format(flight: Flight): String {
        val departure = flight.departureArrivalBooking.first
        val arrival = flight.departureArrivalBooking.second
        return """
            ${flight.number}
            Origin: ${departure.airport.name}
            Origin DateTime: ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
            Arrival: ${arrival.airport.name}
            Arrival DateTime: ${arrival.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
            Duration: ${flight.duration}
            Price: $${flight.price}
            
        """.trimIndent()
    }
}