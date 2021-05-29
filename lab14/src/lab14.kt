tailrec fun downCond(n: Int, acum : Int, f : (Int, Int) -> Int, pr : (Int) -> Boolean) : Int =
    if ( n == 0) acum else
        downCond(n/10, if (pr(n % 10)) f (n % 10, acum) else acum, f, pr)
//рекурсией после спуска вниз,возвращаясь наверх, проверяет каждую цифру числа, если она удовлетворяет условию pr, то f работает над n

fun sumCond(n: Int) : Int = downCond(n, 0, {a,b -> a + b}, {x -> x % 2 != 0 && x>3}) // сумма нечетных цифр, больших 3, нач счетчик равен 0
fun multCond(n: Int) : Int = downCond(n, 1, {a,b -> a * b}, {x -> x % 2 != 0 && x<6}) // произведение нечетных цифр, меньших 6, нач счетчик равен 1
fun maxCond(n: Int) : Int = downCond(n, 0, {a,b -> if (a > b) a else b}, {x -> x % 2 == 0 && x<8}) // максимальная четная цифра, меньше 8, нач знач равно 0
fun minCond(n: Int) : Int = downCond(n, 9, {a,b -> if (a < b) a else b}, {x -> x % 2 == 0 && x>3}) // минимальная четная цифра, больше 3, нач знач равно 9

fun main() {
    println("Введите число")
    val x = readLine()!!.toInt()
    println("Сумма нечетных цифр, больших 3: ${sumCond(x)}")
    println("Произведение нечетных цифр, меньших 6: ${multCond(x)}")
    println("Максимальная четная цифра, меньше 8: ${maxCond(x)}")
    println("Минимальная четная цифра, больше 3: ${minCond(x)}")
}