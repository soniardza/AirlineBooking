package domain.model.baggage.pack.regular

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class Classic(
    price: BigDecimal,
    name: String = "Classic"
) : Regular(name, price) {

    override val boardingTurn: BoardingTurn = BoardingTurn.SECOND
}