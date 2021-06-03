import java.util.Scanner;

fun whichLanguage (a:String, b:String) = //задание 3,5
    when{
        a=="Prolog" -> println("$b,ну Вы и подлиза")
        a=="Kotlin" -> println("$b, ну Вы и подлиза")
        else -> println("$b, мне он не нравится >:| ")
    }
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
}       //задание 8.3

fun odd(x:Int):Int{
    var sum=0
    var temp: Int = x
    while (temp != 0) {
        if (temp % 10 > 3 && (temp % 10) % 2 !=0)
            sum += 1
        temp /= 10
    }
    return sum
}      //задание 8.2
fun sumSimpleDiv(x:Int):Int{
    var sum=0
    for(i in 2..x/2){
        if(x%i==0 && simple(i)){
            sum+=i}
    }
    return sum
}    //задание 8.1
fun simple(x:Int):Boolean{
    for(i in 2..x/2){
        if(x%i==0){
            return false}
    }
    return true
}       //задание 8.1
fun min(x: Int): Int{
    var min = 9
    var temp: Int = x
    while (temp != 0) {
        if (min > temp % 10)
            min = temp % 10
        temp /= 10
    }
    return (min)
}       //задание 7
fun max(x: Int): Int{
    var max = 0
    var temp: Int = x
    while (temp != 0) {
        if (max < temp % 10)
            max = temp % 10
        temp /= 10
    }
    return (max)
}         //задание 7
fun multiply(x: Int): Int{
    var p = 1
    var temp: Int = x
    while (temp != 0) {
        p*= temp % 10
        temp /= 10
    }
    return (p)
}      //задание 7
fun sumDig(x: Int): Int {
    var s = 0
    var temp: Int = x
    while (temp != 0) {
        s += temp % 10
        temp /= 10
    }
    return (s)
}   //задание 6, 8.3


fun largestProduct(mtx:Array<Array<Int>>): Int //задание 10.11
{
    var max = 0
    var a = 0
    var b = 0
    var c = 0
    var d = 0
    for (i in 0..19)
        for (j in 0..16)
            if(mtx[i][j] * mtx[i][j+1] * mtx[i][j+2] * mtx [i][j+3] > max) {
                a = mtx[i][j]
                b = mtx[i][j + 1]
                c = mtx[i][j + 2]
                d = mtx[i][j + 3]
                max = mtx[i][j] * mtx[i][j + 1] * mtx[i][j + 2] * mtx[i][j + 3]
            }
    for (i in 0..16)
        for (j in 0..19)
            if(mtx[i][j] * mtx[i+1][j] * mtx[i+2][j] * mtx [i+3][j] > max) {
                a = mtx[i][j]
                b = mtx[i + 1][j]
                c = mtx[i + 2][j]
                d = mtx[i + 3][j]
                max = mtx[i][j] * mtx[i + 1][j] * mtx[i + 2][j] * mtx[i + 3][j]
            }
    for (i in 0..16)
        for (j in 0..16)
            if(mtx[i][j] * mtx[i+1][j+1] * mtx[i+2][j+2] * mtx[i+3][j+3] > max)
            {   a = mtx[i][j]
                b = mtx[i + 1][j + 1]
                c = mtx[i + 2][j + 2]
                d = mtx[i + 3][j + 3]
                max = mtx[i][j] * mtx[i+1][j+1] * mtx[i+2][j+2] * mtx[i+3][j+3]
            }
    for (i in 3..19)
        for (j in 0..16)
            if (mtx[i][j] * mtx[i-1][j+1] * mtx[i-2][j+2] * mtx[i-3][j+3] > max) {
                a = mtx[i][j]
                b = mtx[i - 1][j + 1]
                c = mtx[i - 2][j + 2]
                d = mtx[i - 3][j + 3]
                max = mtx[i][j] * mtx[i - 1][j + 1] * mtx[i - 2][j + 2] * mtx[i - 3][j + 3]
            }
    println("$a, $b, $c, $d")
    return max
}

fun sumCoins(): Int{                //задание 10.31
    val coins = arrayOf(1, 2, 5, 10, 20, 50, 100, 200)
    var variants: Array<Int> = Array(201) { 0 }
    variants[0] = 1       //0 можем получить 1 способом
    for (i in 0..7) {
        for (j in coins[i]..200)
            variants[j] += variants[j - coins[i]]//
    }
    return variants[200]
}

fun main() {
    //print("Hello world") //задание 1
    /*println("Как Вас зовут?")    //задание 3,5
    val name = readLine()
    println("Здравствуйте, $name! Какой Ваш любимый язык программирования?")
    val lang = readLine()
    whichLanguage(lang.toString(), name.toString())
    */

    /*
    println("Введите число: ") //задание 6
    val x = readLine()!!.toInt()
    print("Сумма цифр числа = ")
    println(sumDig(x))

    print("Максимальная цифра числа = ${max(x)} \nМинимальная цифра числа = ${min(x)} \n Произведение цифр числа = ${multiply(x)}") //задание 7
    print("Сума простых делителей числа = ${sumSimpleDiv(x)}") //задание 8.1
    print("Количество нечетных цифр числа, больших 3 = ${odd(x)}") //задание 8.2
    print("Произведение делителей числа, сумма цифр которых меньше, чем сумма цифр исходного числа = ${multDiv(x)}") //задание 8.3

    println(largestProduct(matrix)) //задание 10.11
    println(sumCoins())//задание 10.31

    */

    /*
    var n: Boolean = false                                     //задание 9
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
    */

    /*
    var string = readLine() //задание 4
    if (string != null) {
        println("Метод : ${string.length}")
        println("Метод : ${string.hashCode()}")
        println("Метод : ${string.capitalize()}")
        println("Метод : ${string.chunked(3)}")
        println("Метод : ${string.drop(3)}")
        println("Метод : ${string.isEmpty()}")
        println("Метод : ${string.plus("plus")}")
    }
    */

    /*
    val x = readLine()!!.toInt()   //задание 6
    println("Метод and: ${x.and(5)}")
    println("Метод compareTo: ${x.compareTo(7)}")
    println("Метод dec: ${x.dec()}")
    println("Метод div: ${x.div(3.5)}")
    println("Метод minus: ${x.minus(2)}")
    println("Метод rangeTo: ${x.rangeTo(10)}")
    println("Метод xor: ${x.xor(6)}")
    */

    /*
    var matrix = Array(20,{Array(20,{0})})  //задание 10.11
    var a: Int
    for (i in 0..19)
        for (j in 0..19)
        { a = (0..100).random()
            matrix[i][j] = a
        }
    */
}
