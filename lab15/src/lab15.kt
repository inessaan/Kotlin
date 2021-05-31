import java.io.File
import java.lang.System.`in`
import java.util.*

fun arrayInput (array: Array<Int>, size: Int) : Array <Int> = arrayInput (array, 0, size) //задание 1

tailrec fun arrayInput (array: Array<Int>, count: Int, size: Int) : Array<Int> = if (count == size) array else
{
    array[count] = readLine()!!.toInt()
    arrayInput(array, count + 1, size)
}

tailrec fun arrayOp(array: Iterator <Int>, f : (Int, Int)-> Int, accum: Int): Int = if (array.hasNext() == false)
    accum else {arrayOp(array, f, f(array.next(),accum))}

tailrec fun digDown(array: Array<Int>, count: Int, accum: Int, f : (Int, Int) -> Int): Int =
    if(count <= 0) accum else
    {
        digDown(array,count - 1,f(accum,array[count - 1]),f)
    }

fun sum(array: Array<Int>): Int = digDown(array, array.size, 0) { a, b -> (a + b) }
fun mult(array: Array<Int>): Int = digDown(array, array.size, 1) { a, b -> (a * b) }


tailrec fun minMax (array: Array<Int>, count: Int, accum: Int, size: Int, f : (Int, Int)-> Boolean) : Int = //Макс мин
    if (size - 1 == count) array[accum]
    else { if (f(array[accum],array[count+1])) minMax(array, count+1, accum, size, f)
    else  minMax(array, count+1, count + 1 , size, f)
    }

fun max(array: Array<Int>): Int = minMax(array,0,0, array.size) { a, b -> a > b }
fun min(array: Array<Int>): Int = minMax(array,0,0, array.size) { a, b -> a < b }

fun inputArray () : Array <Int>  { println("Введите размер: ") //задание 2
    val size = readLine()!!.toInt()
    println("Введите элементы: ")
    val array: Array<Int> = Array<Int>(size, {0})
    arrayInput(array,size)
    return array
}


fun fileArray(input : Map<Int, Int>) : Array<Int> { //задание 3 ввод из файла
    val array:Array<Int> = Array(input.size){0}
    return fileArray(array, 0, input.size, input)
}

fun fileArray(array : Array<Int>, counter : Int, size : Int, input : Map<Int, Int>) : Array<Int> =
    if (counter == size) array else {
        array[counter] = input[counter]!!
        fileArray(array, counter + 1, size, input)
    }


fun fileInput(fileName:String) : Array<Int> { //чтение из файла, возвращает мэп индексированный
    val input = File(fileName).readLines()
        .withIndex() //Возвращает ленивую итерацию, которая обертывает каждый элемент исходного массива в IndexedValue, содержащий индекс этого элемента и сам элемент
        .map { indexedValue -> indexedValue.index to indexedValue.value.toInt() }  // Возвращает список, содержащий результаты применения данной функции преобразования к каждому элементу исходной коллекции
        .toMap() //Возвращает новую карту, содержащую все пары ключ-значение из заданной коллекции пар
    return fileArray(input)
}

fun choice() : Array<Int> {
    println(
        "Выберите способ ввода: \n" +
                "1. Клавиатура\n" +
                "2. Файл"
    )

    val type = readLine()!!.toInt()
    if (type == 2) {
        println("Введите имя файла: ")
        val name = readLine().toString()
        return fileInput("${name}.txt")
    }
    else
        return inputArray()
}


fun countAfterMax (array : Array<Int>) : Int = countAfterMax(array, 1,0, array[0], array.size)//задание 4.1

tailrec  fun countAfterMax(array: Array<Int>, count: Int, accum: Int, max: Int, size: Int) : Int =
    if (size == count) accum
        else { if (array[count] > max) countAfterMax(array, count+1, 0, array[count], size)
        else  countAfterMax(array, count+1, accum + 1, max, size)
}

fun iMin (array : Array<Int>) : Int = index(array, 0, 0, array.size, {a, b -> a < b}) //задание 4.2

tailrec fun index (array: Array<Int>, count: Int, accum: Int, size: Int, f : (Int, Int)-> Boolean) : Int = //индекс элемента макс или мин
    if (size - 1 == count) accum
    else { if (f(array[accum],array[count+1])) index(array, count+1, accum, size, f)
    else  index(array, count+1, count + 1 , size, f)
    }


fun intervalMax (array: Array<Int>, a: Int, b: Int) : Int = intervalMax(array, a, b, array[a]) //задание 4.25

tailrec fun intervalMax (array: Array<Int>, a: Int, b: Int, max : Int) : Int = if (a==b) max
else {if (array[a+1]> max) intervalMax(array, a+1, b, array[a+1]) else intervalMax(array, a+1, b, max)}

fun indMaxFirst (array : Array<Int>) : Int = index(array, 0, 0, array.size, {a, b -> a > b})  //задание 4.28
fun indMaxSecond (array : Array<Int>) : Int = index(array, 0, 0, array.size, {a, b -> a >= b})
fun betweenMax (array: Array<Int>) = betweenMax (array,indMaxSecond(array), indMaxFirst(array),0, array.size)
tailrec fun betweenMax (array: Array<Int>, a: Int, b: Int, count: Int, size: Int)  { if (count == array.size - 1) println("")
else {
    if(count > a && count < b) {
        print("${array[count]} ")
        betweenMax(array, a, b, count + 1, size)
    }
    else{
        betweenMax(array, a, b, count + 1, size)
    }
}
}

fun lMin (array: Array<Int>) : Int =  lMin (array, 0, 1) //задание 4.37
tailrec fun lMin (array: Array<Int>,  count: Int, countSize: Int) : Int =
    if (countSize == array.size) count
    else {
        if (array[countSize - 1] > array[countSize]) {
            println("Ind: ${countSize}")
            lMin(array, count + 1, countSize + 1) }
        else lMin(array, count, countSize + 1)
    }

fun main()
{

    /*
    var array = arrayInput()    //ввод 1
    array.forEach{ it -> println("$it ")} //вывод элементов

    println(sum(array)) // задание 1
    println(mult(array))
    println(min(array))
    println(max(array))

    println("Минимальный элемент = ${array.min()}") //задание 2
    println("Максимальный элемент = ${array.max()}")
    println("Сумма элементов = ${array.sum()}")
    println("Произведение элементов = ${array.fold(1, { total, next -> total * next })}")
    println("Функция мин ${arrayOp(array.iterator(), {a,b -> if (a<b) a else b}, array[0])}")
    println("Функция макс ${arrayOp(array.iterator(), {a,b -> if (a>b) a else b}, array[0])}")
    println("Функция суммы ${arrayOp(array.iterator(), {a,b -> a+b}, 0)}")
    println("Функция произведения ${arrayOp(array.iterator(), {a,b -> a*b}, 1)}")

    println(countAfterMax(array)) //задание 4.1

    println(iMin(array)) //задание 4.2

    println(intervalMax(array, 0, 5)) //задание 4.25

    betweenMax(array) //задание 4.28

    println("Индексы и количество чисел, меньших своего левого соседа: ${lMin(array)}") //задание 4.37
    */

    var array = choice() //задание 3 выбор ввода

    println("Индексы и количество чисел, меньших своего левого соседа: ${lMin(array)}") //задание 4.37
}