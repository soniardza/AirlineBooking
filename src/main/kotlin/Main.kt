import data.baggage.BaggageRegularLocalSource
import data.baggage.BaggageVClubLocalSource
import data.reservation.ReservationSingleton
import domain.model.Flight
import domain.model.Passenger
import domain.model.baggage.pack.BaggagePackage
import domain.model.seat.Seat
import domain.model.seat.SeatSection
import domain.usecases.baggage.GetBaggagePackage
import domain.usecases.baggage.GetBaggageSaved
import domain.usecases.flight.GetFlightSaved
import domain.usecases.flight.GetFlights
import domain.usecases.flight.di.FlightDataDI
import domain.usecases.reservation.AssignTicketToReservation
import domain.usecases.reservation.GetReservation
import domain.usecases.seat.GetSeatSaved
import domain.usecases.seat.GetSeatsBy
import domain.usecases.seat.GetSeatsSection
import domain.usecases.ticket.*
import domain.usecases.ticket.di.TicketDataDI
import presentation.PresentationFormat
import presentation.baggage.BaggagePackPresentationFactory
import presentation.baggage.BaggagePackageEnum
import presentation.extfunction.isNumber
import presentation.flight.FlightPresentationFactory
import presentation.flight.formats.FlightConsoleFormat
import presentation.menu.UIInputData
import presentation.menu.UIMenu
import presentation.passenger.PassengerPresentationFactory
import presentation.reservation.ReservationPresentationFactory
import presentation.seat.SeatPresentationFactory
import presentation.seat.section.SeatSectionPresentationFactory
import presentation.utils.Formatter
import java.time.Month

fun main() {
    val format = PresentationFormat.CONSOLE
    val flightPresentation = FlightPresentationFactory().getPresentationFormat(format)
    val baggagePackPresentation = BaggagePackPresentationFactory().getPresentationFormat(format)
    val seatSectionPresentation = SeatSectionPresentationFactory().getPresentationFormat(format)
    val seatPresentation = SeatPresentationFactory().getPresentationFormat(format)
    val passengerPresentation = PassengerPresentationFactory().getPresentationFormat(format)
    val reservationPresentation = ReservationPresentationFactory().getPresentationFormat(format)

    val ticketData = TicketDataDI().providesTicketsData()
    val flightData = FlightDataDI().providesFlightsData()
    val reservationSingleton = ReservationSingleton()

    /** 1. Showing Flight List **/
    val uiMenuFlight = object : UIMenu<Flight> { }
    val flightMap = GetFlights(flightData).invoke(Month.JANUARY)
    val flightSelected = uiMenuFlight.showMenu(flightMap, flightPresentation)

    /** 2. Saving Flight in Ticket **/
    AssignFlightToTicket(ticketData).invoke(flightSelected)

    val getFlightSaved = GetFlightSaved(ticketData)
    val flightSaved = getFlightSaved()
    println(
        FlightConsoleFormat().format(flightSaved)
    )

    /** 3. Showing Baggage Packages **/
    // Regular
    // VClub
    val baggagePackOption = mapOf(
        1 to BaggagePackageEnum.Regular,
        2 to BaggagePackageEnum.VClub
    )

    val uiMenuBaggagePackOpt = object : UIMenu<BaggagePackageEnum> { }
    val baggagePackageOption = uiMenuBaggagePackOpt.showMenu(
        baggagePackOption,
        object : Formatter<BaggagePackageEnum> {
            override fun format(baggagePackOpt: BaggagePackageEnum): String = baggagePackOpt.name
        }
    )

    val baggagePackData = when (baggagePackageOption) {
        BaggagePackageEnum.Regular -> BaggageRegularLocalSource()
        BaggagePackageEnum.VClub -> BaggageVClubLocalSource()
        else -> BaggageRegularLocalSource()
    }

    val baggagePacksMap = GetBaggagePackage(baggagePackData).invoke()
    val uiMenuBaggagePack = object : UIMenu<BaggagePackage> { }
    val baggagePackageSelected = uiMenuBaggagePack.showMenu(
        baggagePacksMap,
        baggagePackPresentation
    )

    /** 4. Saving Baggage in Ticket **/
    AssignBaggageToTicket(ticketData).invoke(baggagePackageSelected)

    val baggagePackSaved = GetBaggageSaved(ticketData).invoke()
    println("Baggage Package Saved")
    println(
        baggagePackPresentation.format(baggagePackSaved)
    )

    /** 5. Showing available seats */
    val seatSectionMap = GetSeatsSection(getFlightSaved).invoke()

    val uiSeatsSectionMenu = object : UIMenu<SeatSection> { }
    val seatSectionSelected = uiSeatsSectionMenu.showMenu(
        seatSectionMap,
        seatSectionPresentation
    )

    val getSeatsBy = GetSeatsBy()
    val seatsMap = getSeatsBy(seatSectionSelected)
    val uiSeatMenu = object : UIMenu<Seat> { }
    val seatSelected = uiSeatMenu.showMenu(
        seatsMap,
        seatPresentation
    )

    /** 6. Save Seat Selected */
    AssignSeatToTicket(ticketData).invoke(seatSelected)
    val seatSaved = GetSeatSaved(ticketData).invoke()
    println("Seat Saved")
    println(
        seatPresentation.format(seatSaved)
    )

    /** 7. Introduce Information Passenger */
    var passengerQty = ""
    do {
        println("How many passengers are?")
        passengerQty = readLine().orEmpty()
    } while (!passengerQty.isNumber())

    val passengers = (1..passengerQty.toInt()).map {
        println("Passenger: $it")
        val uiInputData = object : UIInputData {}
        val name = uiInputData.requestField("Name")
        val email = uiInputData.requestField("Email")
        val phone = uiInputData.requestField("Phone")

        Passenger(name, email, phone)
    }

    AssignPassengersToTicket(ticketData).invoke(passengers)
    println(
        passengerPresentation.format(passengers)
    )

    /** 8. Get Reservation */
    AssignTicketToReservation(
        reservationSingleton,
        GetTickets(ticketData)
    ).invoke()

    val reservation = GetReservation(reservationSingleton).invoke()

    println()
    println("*** RESERVATION ***")
    println(
        reservationPresentation.format(reservation)
    )
}