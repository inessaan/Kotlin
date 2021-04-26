import java.util.Scanner;

fun multDiv(x:Int):Int{
    var mult = 1
    var sumX = sumDig(x)
    for(i in 2..x) {
        if (x % i == 0) {
            val sumI = sumDig(i)
            if(sumI<sumX)
                mult *= i
        }
    }
    return mult
}
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
fun sumSimpleDiv(x:Int):Int{
    var sum=0
    for(i in 2..x/2){
        if(x%i==0 && simple(i)){
            sum+=i}
    }
    return sum
}
fun simple(x:Int):Boolean{
    for(i in 2..x/2){
        if(x%i==0){
            return false}
    }
    return true
}
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
fun sumDig(x: Int): Int {
    var s = 0
    var temp: Int = x
    while (temp != 0) {
        s += temp % 10
        temp /= 10
    }
    return (s)
}

fun main() {
var n: Boolean = false
while (!n) {
    println(
        "Выберите команду: \n" +
                "1.Найти сумму цифр числа \n" +
                "2.Найти минимальную цифру \n" +
                "3.Найти максимальную цифру \n" +
                "4.Найти произведение цифр числа \n" +
                "5.Найти сумму простых делителей числа. \n" +
                "6.Найти количество нечетных цифр числа, больших 3 \n" +
                "7.Найти прозведение таких делителей числа, сумма цифр которых меньше, чем сумма цифр исходного числа\n" +
                "8.Выйти. \n"
    )
    val input = Scanner(System.`in`)
    var command = input.nextInt()
    if (command in 1..7) {
        println("Введите число:")
        val x = input.nextInt()
        when (command) {
            1 -> println("Сумма цифр: ${sumDig(x)}")
            2 -> println("Минимальная цифра: ${min(x)}")
            3 -> println("Максимальная цифра: ${max(x)}")
            4 -> println("Произведение цифр: ${multiply(x)}")
            5 -> println("Сумма простых делителей числа: ${sumSimpleDiv(x)}")
            6 -> println("Количество нечетных цифр числа, больших 3: ${odd(x)}")
            7 ->  println("Произведение делителей числа, сумма цифр которых меньше, чем сумма цифр исходного числа: ${multDiv(x)}")
        }
        println("Нажмите, чтобы продолжить..")
        var m = readLine()
    }
    else {
        print("Вы вышли из программы.")
        return
    }
}
}