package presentation.passenger

import domain.model.Passenger
import presentation.utils.Formatter
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.passenger.format.PassengerConsoleFormat

class PassengerPresentationFactory : PresentationFactory<Passenger> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Passenger> {
        return PassengerConsoleFormat()
    }

}