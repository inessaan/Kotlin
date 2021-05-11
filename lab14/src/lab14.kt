fun sumUp(n: Int): Int = if (n == 0) n else sumUp(n/10)+n%10

fun sumDown(n : Int) : Int = sumDown(n, 0)
tailrec fun sumDown(n : Int, sum : Int): Int = if(n == 0) sum else sumDown(n/10,sum+n%10)

fun multUp(n: Int): Int = if (n < 10) n else multUp(n / 10) * (n % 10)
fun multDown(n : Int): Int = multDown(n, 1)
tailrec fun multDown(num: Int, p: Int): Int = if (num < 10) p * num else multDown(num/10,p * (num % 10))

fun maxUp(n:Int):Int = if (n < 10) n else if (n % 10 > maxUp(n / 10)) n % 10 else maxUp(n / 10)
fun minUp(n:Int):Int = if (n < 10) n else if (n % 10 < minUp(n / 10)) n % 10 else minUp(n / 10)

tailrec fun down(n: Int, i : Int, f : (Int, Int) -> Int, pr : (Int) -> Boolean) : Int =
    if ( n == 0) i else
        down(n/10, if (pr(n % 10)) f (n % 10, i) else i, f, pr)

fun maxDown(n: Int) : Int = down(n, 0, {a,b -> if (a > b) a else b}, {x -> true})
fun minDown(n: Int) : Int = down(n, 9, {a,b -> if (a < b) a else b}, {x -> true})

fun main() {
    println("Введите число: ")
    val x = readLine()!!.toInt()
    println("Сумма цифр вверх: ${sumUp(x)}")
    println("Сумма цифр вниз: ${sumDown(x)}")
    println("Произведение цифр числа: ${multUp(x)}")
    println("Произведение цифр числа: ${multDown(x)}")
    println("Максимальная цифра числа: ${maxUp(x)}")
    println("Максимальная цифра числа: ${maxDown(x)}")
    println("Минимальная  цифра числа: ${minUp(x)}")
    println("Минимальная  цифра числа: ${minDown(x)}")
}