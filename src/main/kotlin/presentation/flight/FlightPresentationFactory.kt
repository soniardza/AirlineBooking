package presentation.flight

import domain.model.Flight
import domain.utils.Formatter
import presentation.PresentationFormat

class FlightPresentationFactory {

    fun getPresentationFormat(format: PresentationFormat): Formatter<Flight> =
        when (format) {
            PresentationFormat.CONSOLE -> FlightConsoleFormat()
            PresentationFormat.HTML -> FlightHTMLFormat()
            else -> FlightConsoleFormat()
        }
}