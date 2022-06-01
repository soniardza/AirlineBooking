package domain.model.baggage.pack.vclub

import domain.model.baggage.pack.BoardingTurn
import java.math.BigDecimal

class ClubClassic(
    price: BigDecimal
) : VClub(price) {

    override val name: String = "Classic VClub"
    override val boardingTurn: BoardingTurn = BoardingTurn.SECOND
    override val price: BigDecimal
        get() = super.price + BigDecimal(10)
}