fun sumUp(n: Int): Int = if (n == 0) n else sumUp(n/10)+n%10

fun main() {
    println("Введите число: ")
    val x = readLine()!!.toInt()
    print("Сумма цифр вверх: ${sumUp(x)}\n")
}