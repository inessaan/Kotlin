
tailrec fun down(n: Int, acum : Int, f : (Int, Int) -> Int) : Int =
    if ( n == 0) acum else
        down(n / 10, f(n % 10, acum), f)

fun sum(n: Int) : Int = down(n, 0, {a,b -> a + b})
fun mult(n: Int) : Int = down(n, 1, {a,b -> a * b})
fun max(n: Int) : Int = down(n, 0, {a,b -> if (a > b) a else b})
fun min(n: Int) : Int = down(n, 9, {a,b -> if (a < b) a else b})


fun main() {
    println("Введите число: ")
    val x = readLine()!!.toInt()
    println("Сумма цифр: ${sum(x)}")
    println("Произведение цифр: ${mult(x)}")
    println("Максимальная цифра: ${max(x)}")
    println("Минимальная  цифра: ${min(x)}")
}