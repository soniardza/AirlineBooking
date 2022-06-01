package data.baggage

import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.pack.regular.RegularBasic
import domain.model.baggage.pack.regular.RegularClassic
import domain.model.baggage.pack.regular.RegularPlus

class BaggageRegularLocalSource : BaggagePackageLocalSource() {
    override fun getBaggagePacks(): Map<Int, BaggagePackage> =
        mapOf(
            1 to RegularBasic(price),
            2 to RegularClassic(price),
            3 to RegularPlus(price)
        )
}