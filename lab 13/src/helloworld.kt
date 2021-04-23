fun simple(x:Int):Boolean{
    for(i in 2..x/2){
        if(x%i==0){
            return false}
    }
    return true
}
fun sumSimpleDiv(x:Int):Int{
    var sum=0
    for(i in 2..x/2){
        if(x%i==0 && simple(i)){
            sum+=i}
    }
    return sum
}

fun main() {
    println("Введите число: ")
    val x = readLine()!!.toInt()
    print("Сума простых делителей числа = ${sumSimpleDiv(x)}")
}
