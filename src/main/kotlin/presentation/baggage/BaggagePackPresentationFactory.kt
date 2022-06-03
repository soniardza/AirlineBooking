package presentation.baggage

import domain.model.baggage.pack.BaggagePackage
import presentation.utils.Formatter
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.baggage.format.BaggagePackageConsoleFormat
import presentation.baggage.type.format.BaggageTypeConsoleFormat

class BaggagePackPresentationFactory : PresentationFactory<BaggagePackage> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<BaggagePackage> {
        return BaggagePackageConsoleFormat(
            BaggageTypeConsoleFormat()
        )
    }
}