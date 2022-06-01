package presentation.baggage.type

import domain.model.baggage.type.BaggageType
import domain.utils.Formatter


class BaggageTypeConsole : Formatter<BaggageType> {
    override fun format(baggageType: BaggageType): String =
        """
            ${baggageType.emoji} ${baggageType.quantity} ${baggageType.title}
        """.trimIndent()
}