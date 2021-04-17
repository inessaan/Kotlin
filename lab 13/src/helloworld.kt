fun whichLanguage (a:String, b:String) =
    when{
        a=="Prolog" -> println("$b,ну Вы и подлиза")
        a=="Kotlin" -> println("$b, ну Вы и подлиза")
        else -> println("$b, мне он не нравится >:| ")
    }
fun main() {
    println("Как Вас зовут?")
    val name = readLine()
    println("Здравствуйте, $name! Какой Ваш любимый язык программирования?")
    val lang = readLine()
    whichLanguage(lang.toString(), name.toString())
}
