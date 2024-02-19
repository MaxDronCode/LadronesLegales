package models

import interfaces.Liquidable

class CuentaCorriente: CuentaBancaria, Liquidable {
    // Atributos
    private var comisionMantenimiento: Int = 20
    override var liquidada: Boolean = false

    // Constructores
    constructor(){}

    // Métodos
    fun getComisionMantenimiento(): Int {
        return this.comisionMantenimiento
    }
    fun setComisionMantenimiento(comision:Int) {
        this.comisionMantenimiento = comision
    }


    fun getLiquidada():Boolean {
        return this.liquidada
    }
    fun setLiquidada(liquidada:Boolean){
        this.liquidada = liquidada
    }

    override fun ingresar(dinero: Float) {
        this.saldo += dinero
    }

    override fun retirar(dinero: Float) {
        this.saldo -= dinero
    }
    override fun liquidar() {
        if (!dataApertura.tieneMasDeUnAnio()) cobrarComision("liquidacion")
        retirar(this.saldo)
        setLiquidada(true)
    }

    override fun cobrarComision(tipo:String){
        when (tipo) {
            "liquidación" -> this.saldo -= this.saldo * 0.03f
            "mantenimiento" -> this.saldo -= getComisionMantenimiento()
            "descubierto" -> {
                val importeNegativo:Float = 0 - this.saldo
                val penalizacion:Float = importeNegativo * 0.1f
                this.saldo -= penalizacion
            }
        }
    }

    override fun toString(): String {
        return super.toString() + """
            Comisión Mantenimiento: ${this.comisionMantenimiento}
            Liquidada:              ${this.liquidada}
        """.trimIndent()
    }


}