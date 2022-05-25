package domain.model.baggage.pack.regular

import domain.model.baggage.pack.BaggagePackage
import java.math.BigDecimal

open class Regular(
    override val name: String,
    override val price: BigDecimal
) : BaggagePackage() {
}