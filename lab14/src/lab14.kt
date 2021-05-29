fun sumDown(n : Int) : Int = sumDown(n, 0)
tailrec fun sumDown(n : Int, sum : Int): Int = if(n == 0) sum else sumDown(n/10,sum+n%10)

fun simple (x: Int) : Boolean = if (x == 1) false
        else { if (x == 2) true
        else simple (x, x/2)}

tailrec fun simple(x:Int, i:Int): Boolean = if (i == 1) true
    else { if(x % i == 0)
        false
    else  simple(x, i - 1)
}

fun sumSimpleDiv(x: Int) : Int = sumSimpleDiv(x, x/2, 0)
tailrec fun sumSimpleDiv(x:Int, i: Int, accum: Int) :
        Int = if (i == 1) accum + 1
else {
    if (x%i == 0 && simple(i))
        sumSimpleDiv(x, i - 1, accum + i)
    else sumSimpleDiv(x, i - 1, accum)
}

fun odd(x:Int): Int = odd (x, 0)
tailrec fun odd(x: Int, count: Int) :
        Int = if (x == 0) count else
{
    if ((x % 10) % 2 != 0 && (x % 10) > 3)
        odd (x/10, count + 1)
    else odd(x/10, count)
}

fun multDiv(x:Int): Int = multDiv(x,1,1)

fun f(x:Int, div:Int): Boolean = x % div == 0

tailrec fun multDiv(x:Int, div:Int, pr:Int): Int = if (x == div) pr else{
    when {
        sumDown(div) < sumDown(x) && f(x, div) ->
        {
            println("Делитель числа: $div" )
            multDiv(x,div + 1,pr * div)
        }
        else -> multDiv(x,div + 1, pr)
    }
}

fun main() {
    println("Введите число: ")
    val x = readLine()!!.toInt()
    println("Сума простых делителей числа = ${sumSimpleDiv(x)}")
    println("Количество нечетных цифр числа, больших 3 = ${odd(x)}")
    println("Произведение делителей числа, сумма цифр которых меньше, чем сумма цифр исходного числа = ${multDiv(x)}")
}