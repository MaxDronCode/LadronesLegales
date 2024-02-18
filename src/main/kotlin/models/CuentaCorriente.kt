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

    fun retirarDinero(dineroARetirar:Float){
        this.saldo -= dineroARetirar
    }

    fun getLiquidada():Boolean {
        return this.liquidada
    }
    fun setLiquidada(liquidada:Boolean){
        this.liquidada = liquidada
    }

    override fun liquidar() {
        if (!dataApertura.tieneMasDeUnAnio()) cobrarComision("liquidacion")
        retirarDinero(this.saldo)
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