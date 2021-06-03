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
    println(sumCoins())
}
