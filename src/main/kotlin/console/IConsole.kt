package console
interface IConsole {
    fun leer(msg: String)
    fun escribir(msg: String, lineBreak: Boolean = false)
}