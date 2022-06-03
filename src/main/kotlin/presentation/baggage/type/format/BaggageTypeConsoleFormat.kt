package presentation.baggage.type.format

import domain.model.baggage.type.BaggageType
import domain.utils.Formatter


class BaggageTypeConsoleFormat : Formatter<BaggageType> {
    override fun format(baggageType: BaggageType): String =
        """
            ${baggageType.emoji} ${baggageType.quantity} ${baggageType.title}
        """.trimIndent()
}