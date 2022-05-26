import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.pack.regular.Regular
import domain.model.baggage.pack.regular.Basic as RegularBasic
import domain.model.baggage.pack.regular.Classic as RegularClassic
import domain.model.baggage.pack.vclub.Basic
import domain.model.baggage.pack.vclub.Classic
import domain.model.baggage.pack.vclub.Plus
import domain.model.baggage.pack.vclub.VClub
import java.math.BigDecimal

fun main() {
    val basicPrice = BigDecimal(200)
    val classicPrice = BigDecimal(400)

    val basicClub: VClub = Basic(basicPrice)
    val classicClub: VClub = Classic(classicPrice)

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

    val plus: BaggagePackage = Plus(BigDecimal(500))
    println(plus.price)
}