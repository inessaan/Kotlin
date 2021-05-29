tailrec fun down(n: Int, acum : Int, f : (Int, Int) -> Int) : Int =
    if ( n == 0) acum else
        down(n / 10, f(n % 10, acum), f)

fun sum(n: Int) : Int = down(n, 0, {a,b -> a + b})
fun mult(n: Int) : Int = down(n, 1, {a,b -> a * b})
fun max(n: Int) : Int = down(n, 0, {a,b -> if (a > b) a else b})
fun min(n: Int) : Int = down(n, 9, {a,b -> if (a < b) a else b})

fun op (op : Int,x : Int ) = when (op){
    1 -> sum(x)
    2 -> mult(x)
    3 -> max(x)
    4 -> min(x)

    else -> throw IllegalArgumentException("Ошибка")
}

fun main() {
    println("Введите операцию и затем введите число: ")
    println("1 - Сумма цифр")
    println("2 - Произведение цифр")
    println("3 - Максимальная цифра")
    println("4 - Минимальная цифра")
    println(op(readLine()!!.toInt(), readLine()!!.toInt()))
}