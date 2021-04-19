fun min(x: Int): Int{
    var min = 9
    var temp: Int = x
    while (temp != 0) {
        if (min > temp % 10)
            min = temp % 10
        temp /= 10
    }
    return (min)
}

fun max(x: Int): Int{
    var max = 0
    var temp: Int = x
    while (temp != 0) {
        if (max < temp % 10)
            max = temp % 10
        temp /= 10
    }
    return (max)
}

fun multiply(x: Int): Int{
    var p = 1
    var temp: Int = x
    while (temp != 0) {
        p*= temp % 10
        temp /= 10
    }
    return (p)
}
fun main() {
    println("Введите число: ")
    val x = readLine()!!.toInt()
    print("Максимальная цифра числа = ${max(x)} \nМинимальная цифра числа = ${min(x)} \n Произведение цифр числа = ${multiply(x)}")
}
