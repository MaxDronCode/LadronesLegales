package utilities

fun menuBienvenida(){
    val impresion:String = """
        Bienvenido/a!
        
        Es usted cliente de este banco?

    """.trimIndent()
    println(impresion)
}

fun bienvenidaNoCLiente(){
    val impresion:String = """
        Para hacer operaciones con nuestro banco debe darse de alta.
        ¿Desea darse de alta?
    """.trimIndent()
    println(impresion)
}

fun bienvenidaEsCLiente() {
    val impresion:String = """
        Nos alegra verle por aquí!
        Para acceder a su espacio de cliente deberá iniciar sesión:
    """.trimIndent()
    println(impresion)
}

fun yaEsCliente(){
    val impresion:String = """
        Enhorabuena! Y bienvenido a nuestro banco. Ahora volvera a la pantalla inicial, donde podra entrar con sus credenciales.
    """.trimIndent()
    println(impresion)
}

fun iniciarSesion() {
    val impresion:String = """
        Para iniciar sesión deberá introducir su número de DNI y su segundo apellido.
    """.trimIndent()
    println(impresion)
}

fun despedida() {
    val impresion:String = """
        Un placer tratar con usted y que pase un buen dia.
    """.trimIndent()
    println(impresion)
}

fun condicionesRetirada(){
    val impresion:String = """
        
        Solo se puede retirar dinero:
        1. Pasado 1 año de la apertura de la Cuenta Ahorro
        2. En Junio y Diciembre
        3. El dia 30
        
    """.trimIndent()
    println(impresion)
}

