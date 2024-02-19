package models

class Cliente {
    // Atributos
    private var numCliente: Int = ++numClientes
    private var dni: String = ""
    private var nombre: String = ""
    private var apellido1: String = ""
    private var apellido2: String = ""
    private var cuentas: MutableList<CuentaBancaria> = mutableListOf()


    // Companion
    companion object {
        private var numClientes:Int = 1675439
    }

    // Constructores
    constructor(){}
    constructor(dni:String, nombre:String, apellido1:String, apellido2:String)

    // Métodos
    fun getNumCliente(): Int {
        return this.numCliente
    }
    fun getDni():String {
        return this.dni
    }
    fun setDni(dni:String){
        this.dni = dni
    }

    fun getNombre():String {
        return this.nombre
    }
    fun setNombre(nombre:String) {
        this.nombre = nombre
    }

    fun getApellido1():String {
        return this.apellido1
    }
    fun setApellido1(apellido:String) {
        this.apellido1 = apellido
    }

    fun getApellido2(): String {
        return this.apellido2
    }
    fun setApellido2(apellido:String) {
        this.apellido2 = apellido
    }

    fun getTodasCuentas(): MutableList<CuentaBancaria> {
        return this.cuentas
    }

    fun getCuentasCorrientes(): MutableList<CuentaBancaria> {
        var cuentasCorrientes:MutableList<CuentaBancaria> = mutableListOf()
        for (cuenta in this.cuentas) if (cuenta is CuentaCorriente) cuentasCorrientes.add(cuenta)
        return cuentasCorrientes
    }
    fun setCuentaCorriente(cuenta:CuentaCorriente){
        this.cuentas.add(cuenta)
    }

    fun getCuentasAhorro(): MutableList<CuentaBancaria> {
        var cuentasAhorro:MutableList<CuentaBancaria> = mutableListOf()
        for (cuenta in this.cuentas) if (cuenta is CuentaAhorro) cuentasAhorro.add(cuenta)
        return cuentasAhorro
    }
    fun setCuentaAhorro(cuenta:CuentaAhorro) {
        this.cuentas.add(cuenta)
    }

    override fun toString(): String {
        return """
            Número de Cliente: ${this.numCliente}
            DNI:               ${this.dni}
            Nombre:            ${this.nombre}
            Primer Apellido:   ${this.apellido1}
            Segundo Apellido:  ${this.apellido2}
            Cuentas Bancárias: ${this.cuentas.size}
        """.trimIndent()
    }
}