package domain.model.baggage.pack.regular

import domain.model.baggage.pack.BoardingTurn
import domain.model.baggage.type.BaggageType
import java.math.BigDecimal

class Plus(
    price: BigDecimal,
    name: String = "Plus"
) : Regular(name, price) {

    override val boardingTurn: BoardingTurn = BoardingTurn.FIRST
}