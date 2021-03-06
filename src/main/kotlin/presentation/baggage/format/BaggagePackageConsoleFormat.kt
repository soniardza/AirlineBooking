package presentation.baggage.format

import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.type.BaggageType
import presentation.utils.Formatter

class BaggagePackageConsoleFormat(
    private val baggageType: Formatter<BaggageType>
) : Formatter<BaggagePackage> {

    override fun format(baggagePackage: BaggagePackage): String =
        """
${baggagePackage.name}
${baggageType.format(baggagePackage.baggageTypes).trim()}
Boarding Turn: ${baggagePackage.boardingTurn.name}
Price: $${baggagePackage.price}
        """.trimIndent()
}