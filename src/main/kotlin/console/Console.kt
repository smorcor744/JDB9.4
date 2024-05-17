package console

class Console: IConsole {
    override fun leer(msg: String) {
        readln()
    }

    override fun escribir(msg: String, lineBreak: Boolean) {
        if (lineBreak){ println(msg) } else { print(msg) }
    }
}
