import kotlin.random.Random

fun main() {
    var swordsJuggling: Int? = null
    val isJugglingProficient = Random.nextInt(3) == 0
    if (isJugglingProficient) {
        swordsJuggling = 2
    }
    proficiencyCheck(swordsJuggling)
    swordsJuggling = swordsJuggling!!.plus(1)
    println("You juggle $swordsJuggling swords!")
}
fun proficiencyCheck(swordsJuggling: Int?) {
    swordsJuggling ?: throw IllegalStateException("Player cannot juggle swords")
}
