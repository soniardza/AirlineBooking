package domain.model.baggage.pack

import domain.model.baggage.type.BaggageType
import domain.model.baggage.type.BigHand
import domain.model.baggage.type.Checked
import domain.model.baggage.type.Hand
import java.math.BigDecimal

open class BaggagePackage(
    open val name: String = "Baggage Plan",
    open val price: BigDecimal = BigDecimal(0.0)
) {
    open val boardingTurn: BoardingTurn = BoardingTurn.FIRST
    open val baggageTypes: List<BaggageType> = listOf(
        Hand(),
        BigHand(),
        Checked()
    )
}