package domain.model.baggage.pack.vclub

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class Plus(
    price: BigDecimal,
    name: String = "Plus VClub"
) : VClub(name, price) {
    override val boardingTurn: BoardingTurn = BoardingTurn.FIRST
}