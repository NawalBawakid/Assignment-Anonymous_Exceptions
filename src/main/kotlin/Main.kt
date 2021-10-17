import kotlin.random.Random
import kotlin.random.nextInt

fun main(args: Array<String>) {
    var numLetter = "mississippi".count()
    println(numLetter)

    println("//===========================================")

    var numLetter1 = "mississippi".count({letter -> letter == 's'})
    println(numLetter1)

    println("//===========================================")

    var numletter2 = "mississippi".count{letter -> letter == 'p'}
    println(numletter2)

    println("//===========================================")

    println({
        val currentYear = 2018
        "welcome to SimVillage, Mayor! (copyright $currentYear)"
    }()
    )

    println("//===========================================")

    val greetingFunction: () -> String = {
        val currentYear = 2018
        "welcome to SimVillage, Mayor! (copyright $currentYear)"
    }
    println(greetingFunction())

    println("//===========================================")

    val greetingFunction1: (String) -> String = { playerName ->
        val currentYear = 2018
        "welcom to SimVillage, $playerName (copyright $currentYear)"
    }
    println(greetingFunction1("Mohamed"))

    println("//===========================================")

    val greetingFunction2: (String) -> String = {
        val currentYear = 2018
        "welcom to SimVillage, $it (copyright $currentYear)"
    }
    println(greetingFunction2("Ahmed"))

    println("//===========================================")

    val greetingFunction3: (String, Int) -> String = { playerName , numBuildings ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "welcom to SimVillage, $playerName (copyright $currentYear)"
    }
    println(greetingFunction3("Guyal", 2))

    println("//===========================================")

    val greetingFunction4 = { playerName:String , numBuildings: Int ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "welcom to SimVillage, $playerName (copyright $currentYear)"
    }
    println(greetingFunction4("Guyal", 9))

    println("//===========================================")

    val greetingFunction5 = { playerName:String , numBuildings: Int ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "welcom to SimVillage, $playerName (copyright $currentYear)"
    }
    runSimulation("Jim", greetingFunction5)

    println("//===========================================")

    runSimulation("Nawal") { playerName, numBuildings ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "welcom to SimVillage, $playerName (copyright $currentYear)"
    }

    println("//===========================================")

    /* runSimulation1("Nawalkh", ::printConstructionCost) { playerName, numBuildings ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "welcom to SimVillage, $playerName (copyright $currentYear)"
    }*/
    runSimulation1()

}

inline fun runSimulation(playerName: String , greetingFunction5: (String, Int) -> String){
    val numBuildings = Random.nextInt(1..3)
    println(greetingFunction5(playerName,numBuildings))
}

/* inline fun runSimulation1 (playerName: String, costPrinter: (Int) -> Unit, greetingFunction5: (String, Int) -> String) {
    val numBuildings = Random.nextInt(1..3)
    costPrinter(numBuildings)
    println(greetingFunction5(playerName, numBuildings))
}*/


fun printConstructionCost(numBuildings: Int){
    val cost = 500
    println("construction cost: ${cost * numBuildings}")
}

fun runSimulation1() {
    val greetingFunction5 = configureGreetingFunction()
    println(greetingFunction5("Asmaa"))
}

fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2018
        numBuildings +=1
        println("adding $numBuildings $structureType")
        "welcom to SimVillage, $playerName! (copyright $currentYear)"
    }
}