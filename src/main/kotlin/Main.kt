import domain.model.baggage.type.BaggageType
import domain.model.baggage.type.Checked
import domain.model.baggage.type.Hand

fun main() {
    val hand = Hand()
    println(hand.title)
    println(hand.quantity)
    println(hand.warning)

    val checked: BaggageType = Checked()
    println(checked.emoji)
}