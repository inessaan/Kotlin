fun odd(x:Int):Int{
    var sum=0
    var temp: Int = x
    while (temp != 0) {
        if (temp % 10 > 3 && (temp % 10) % 2 !=0)
            sum += 1
        temp /= 10
    }
    return sum
}

fun main() {
    println("Введите число: ")
    val x = readLine()!!.toInt()
    print("Количество нечетных цифр числа, больших 3 = ${odd(x)}")
}
