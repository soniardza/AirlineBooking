import data.baggage.BaggageRegularLocalSource
import data.baggage.BaggageVClubLocalSource
import domain.model.Flight
import domain.model.baggage.pack.BaggagePackage
import domain.usecases.baggage.GetBaggagePackage
import domain.usecases.baggage.GetBaggageSaved
import domain.usecases.flight.GetFlightSaved
import domain.usecases.flight.GetFlights
import domain.usecases.flight.di.FlightDataDI
import domain.usecases.ticket.AssignBaggageToTicket
import domain.usecases.ticket.AssignFlightToTicket
import domain.usecases.ticket.di.TicketDataDI
import presentation.PresentationFormat
import presentation.baggage.BaggagePackPresentationFactory
import presentation.baggage.BaggagePackageEnum
import presentation.baggage.format.BaggagePackageConsoleFormat
import presentation.baggage.type.format.BaggageTypeConsoleFormat
import presentation.flight.FlightPresentationFactory
import presentation.flight.formats.FlightConsoleFormat
import presentation.menu.UIMenu
import java.time.Month

fun main() {
    val format = PresentationFormat.CONSOLE
    val flightPresentation = FlightPresentationFactory().getPresentationFormat(format)
    val baggagePackPresentation = BaggagePackPresentationFactory().getPresentationFormat(format)

    val ticketData = TicketDataDI().providesTicketsData()
    val flightData = FlightDataDI().providesFlightsData()

    val uiMenuFlight = object : UIMenu<Flight> { }
    val flightMap = GetFlights(flightData).invoke(Month.JANUARY)
    val flightSelected = uiMenuFlight.showMenu(flightMap, flightPresentation)

    /** 2. Saving Flight in Ticket **/
    AssignFlightToTicket(ticketData).invoke(flightSelected)

    val flightSaved = GetFlightSaved(ticketData).invoke()
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
        object : domain.utils.Formatter<BaggagePackageEnum> {
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

    /** 2. Saving Baggage in Ticket **/
    AssignBaggageToTicket(ticketData).invoke(baggagePackageSelected)

    val baggagePackSaved = GetBaggageSaved(ticketData).invoke()
    println("Baggage Package Saved")
    println(
        baggagePackPresentation.format(baggagePackSaved)
    )
}