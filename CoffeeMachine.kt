package machine

class Machine() {
    var water = 400
    var milk = 540
    var beans = 120
    var cups = 9
    var money = 550

    fun buy(x: String) {
        var _water = 0
        var _milk = 0
        var _beans = 0
        var _money = 0
        when (x) {
            "1" -> {
                _water = 250
                _beans = 16
                _money = 4
            }
            "2" -> {
                _water = 350
                _milk = 75
                _beans = 20
                _money = 7
            }
            "3" -> {
                _water = 200
                _milk = 100
                _beans = 12
                _money = 6
            }
            "back" -> {
                menu()
                return
            }
        }
        if (water - _water < 0) println("Sorry, not enough water!") else {
            water -= _water
            milk -= _milk
            beans -= _beans
            money += _money
            cups --
            println("I have enough resources, making you a coffee!")
        }
    }

    fun fill() {
        println("\nWrite how many ml of water you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        beans += readln().toInt()
        println("Write how many disposable cups you want to add:")
        cups += readln().toInt()
    }

    fun take() {
        println("\nI gave you $${money}")
        money = 0
    }

    fun output() {
        println("\nThe coffee machine has:\n" +
                "$water ml of water\n" +
                "$milk ml of milk\n" +
                "$beans g of coffee beans\n" +
                "$cups disposable cups\n" +
                "$$money of money")
    }

    fun menu(): Boolean {
        println("\nWrite action (buy, fill, take, remaining, exit):")
        when (readln()) {
            "buy" -> {
                println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                buy(readln())
            }
            "fill" -> fill()
            "take" -> take()
            "remaining" -> output()
            "exit" -> return false
        }
        return true
    }
}


fun main() {
    val machine = Machine()

    while (true) {
        if (!machine.menu()) break
    }

}