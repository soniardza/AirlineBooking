import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.pack.regular.Regular
import domain.model.baggage.pack.regular.RegularBasic
import domain.model.baggage.pack.regular.RegularClassic
import domain.model.baggage.pack.vclub.ClubBasic
import domain.model.baggage.pack.vclub.ClubClassic
import domain.model.baggage.pack.vclub.ClubPlus
import domain.model.baggage.pack.vclub.VClub
import java.math.BigDecimal

fun main() {
    val basicPrice = BigDecimal(200)
    val classicPrice = BigDecimal(400)

    val basicClub: VClub = ClubBasic(basicPrice)
    val classicClub: VClub = ClubClassic(classicPrice)

    println(basicClub.name)
    println(basicClub.price)

    println(classicClub.name)
    println(classicClub.price)

    val basic: Regular = RegularBasic(basicPrice)
    val classic: Regular = RegularClassic(classicPrice)

    println(basic.name)
    println(basic.price)

    println(classic.name)
    println(classic.price)

    val plus: BaggagePackage = ClubPlus(BigDecimal(500))
    println(plus.price)
}