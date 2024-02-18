package models

abstract class CuentaBancaria {
    // Atributos
    protected var dataApertura: Fecha = Fecha.fechaActual()
    protected var saldo: Float = 0f;
    protected var codigoBanco: String = "00 81"
    protected var codigoSucursal: String = "00 49"
    protected var digitosDeControl: String = "55"
    protected var nombreCuenta: String = setNombreCuenta()

    // Constructores
    constructor(){}
    // Métodos
    protected fun setNombreCuenta(): String{
        var numsCuenta: Array<Int> = Array(10){(0..9).random()}
        return "ES13" + this.codigoBanco + this.codigoSucursal + this.digitosDeControl + numsCuenta.toString()
    }

    fun ingresar(dinero:Float) {
        this.saldo += dinero
    }

    fun consultarSaldo():Float {
        return this.saldo
    }

}