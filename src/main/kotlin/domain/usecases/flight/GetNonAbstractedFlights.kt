package domain.usecases.flight

import domain.model.AirCraft
import domain.model.Airport
import domain.model.AirportBooking
import domain.model.Flight
import presentation.PresentationFormat
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter

// No tenemos interfaz padre en común, tenemos que validar caso por caso
/*
class GetNonAbstractedFlights(
    private val format: PresentationFormat
) {
    fun invoke(): String {
        val flight = Flight(
            number = "Y4 708",
            airCraft = AirCraft("Airbus", "A320"),
            price = BigDecimal(100.0),
            departureArrivalBooking = getAirportPair()
        )

        val  flights = listOf(
            flight,
            flight,
            flight
        )

        return when (format) {
            PresentationFormat.CONSOLE -> {
                val departure = flight.departureArrivalBooking.first
                val arrival = flight.departureArrivalBooking.second
                """
                    ${flight.number}
                    Origin: ${departure.airport.name}
                    Origin DateTime: ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
                    Arrival: ${arrival.airport.name}
                    Arrival DateTime: ${arrival.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
                    Duration: ${flight.duration}
                    Price: $${flight.price}
                    
                """.trimIndent()
            }
            PresentationFormat.HTML -> {
                val departure = flight.departureArrivalBooking.first
                val arrival = flight.departureArrivalBooking.second
                """
                    <p><strong>${flight.number}</strong><br />
                    Origin: ${departure.airport.name}<br />
                    Destination: ${arrival.airport.name}<br />
                    Departure: ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}<br />
                    Arrival Date: ${arrival.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}<br />
                    Duration: ${flight.duration}<br />
                    <strong>Price: ${'$'}${flight.price}</strong>
                    </p>
            
                """.trimIndent()
            }
            PresentationFormat.JSON -> {
                """
                    Flight: { }
                """.trimIndent()
            }
        }

    }

    private fun getAirportPair(): Pair<AirportBooking, AirportBooking> {
        return Pair(
            AirportBooking(
                airport = Airport("BOG", "Bogotá"),
                dateTime = LocalDateTime.of(
                    2023, Month.JANUARY, 10, 13, 0, 0
                )
            ),
            AirportBooking(
                airport = Airport("CUN", "Cancún"),
                dateTime = LocalDateTime.of(
                    2023, Month.JANUARY, 10, 17, 30, 0
                )
            )
        )
    }
}*/
