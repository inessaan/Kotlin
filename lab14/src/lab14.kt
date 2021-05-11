fun sumUp(n: Int): Int = if (n == 0) n else sumUp(n/10)+n%10

fun sumDown(n : Int) : Int = sumDown(n, 0)
tailrec fun sumDown(n : Int, sum : Int): Int = if(n == 0) sum else sumDown(n/10,sum+n%10)

fun main() {
    println("Введите число: ")
    val x = readLine()!!.toInt()
    print("Сумма цифр вверх: ${sumUp(x)}\n")
    print("Сумма цифр вниз: ${sumDown(x)}\n")
}