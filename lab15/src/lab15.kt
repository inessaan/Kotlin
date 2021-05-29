fun arrayInput () : Array <Int>  { println("Введите размер: ")
    val size = readLine()!!.toInt()
    println("Введите элементы: ")
    val array: Array<Int> = Array<Int>(size, {0})
    arrayInput(array,size)
    return array
}

fun arrayInput (array: Array<Int>, size: Int) : Array <Int> = arrayInput (array, 0, size)

tailrec fun arrayInput (array: Array<Int>, count: Int, size: Int) : Array<Int> = if (count == size) array else
{
    array[count] = readLine()!!.toInt()
    arrayInput(array, count + 1, size)
}

tailrec fun arrayOp(array: Iterator <Int>, f : (Int, Int)-> Int, accum: Int): Int = if (array.hasNext() == false)
    accum else {arrayOp(array, f, f(array.next(),accum))}

fun main()
{
    var array = arrayInput()
    array.forEach{ it -> println("$it ")}
    println("Минимальный элемент = ${array.min()}")
    println("Максимальный элемент = ${array.max()}")
    println("Сумма элементов = ${array.sum()}")
    println("Произведение элементов = ${array.fold(1, { total, next -> total * next })}")
    println("Функция мин ${arrayOp(array.iterator(), {a,b -> if (a<b) a else b}, array[0])}")
    println("Функция макс ${arrayOp(array.iterator(), {a,b -> if (a>b) a else b}, array[0])}")
    println("Функция суммы ${arrayOp(array.iterator(), {a,b -> a+b}, 0)}")
    println("Функция произведения ${arrayOp(array.iterator(), {a,b -> a*b}, 1)}")
}