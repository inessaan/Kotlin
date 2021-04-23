fun sumDig(x: Int): Int {
    var sum = 0
    var temp: Int = x
    while (temp != 0) {
        sum += temp % 10
        temp /= 10
    }
    return sum
}
fun multDiv(x:Int):Int{
    var mult = 1
    var sumX = sumDig(x)
    for(i in 2..x) {
        if (x % i == 0) {
            val sumI = sumDig(i)
            if(sumI<sumX)
                mult *= sumI
        }
    }
    return mult
}
fun main() {
    println("Введите число: ")
    val x = readLine()!!.toInt()
    print("Произведение делителей числа, сумма цифр которых меньше, чем сумма цифр исходного числа = ${multDiv(x)}")
}