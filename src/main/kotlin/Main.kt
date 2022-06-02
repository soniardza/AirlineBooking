import data.aircraft.AirCraftLocalSource
import data.airport.AirportLocalSource
import data.airportbook.AirportBookingLocalSource
import data.flight.FlightLocalSource
import domain.usecases.flight.GetFlights
import presentation.flight.formats.FlightConsoleFormat
import java.time.Month

fun main() {
    val airportDataSource = AirportLocalSource()
    val airportBookingLocalSource = AirportBookingLocalSource(airportDataSource)
    val airCraftLocalSource = AirCraftLocalSource()

    // Empezar aquí y luego ir para atrás
    val flightLocal = FlightLocalSource(airCraftLocalSource, airportBookingLocalSource)
    val getFlights = GetFlights(flightLocal).invoke(Month.JANUARY)
    getFlights.forEach { (index, flight) ->
        print("$index. ")
        println(FlightConsoleFormat().format(flight))
    }


}