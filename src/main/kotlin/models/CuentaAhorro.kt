package models

import interfaces.Liquidable
import utilities.condicionesRetirada

class CuentaAhorro: CuentaBancaria, Liquidable {
    // Atributos
    private var interes: Float = 0.04f
    override var liquidada: Boolean = false
    override var dataLiquidacion: Fecha = Fecha.fechaActual()

    // Constructores
    constructor(){}
    // Métodos
    fun getInteres(): Float {
        return this.interes
    }
    fun setInteres(interes:Float) {
        this.interes = interes
    }

    fun getLiquidada(): Boolean {
        return this.liquidada
    }
    fun setLiquidada(liquidada:Boolean) {
        this.liquidada = liquidada
    }

    fun generarInteres() {
        var fechaActual:Fecha = Fecha.fechaActual()
        if (fechaActual.dia == this.dataApertura.dia && fechaActual.mes == this.dataApertura.mes && fechaActual.anyo > this.dataApertura.anyo){
            this.saldo += this.saldo * this.interes
        }
        // Faltaria programar que esta función se dispare solo una vez al año, y que tenga en cuenta el 29 de febrero.
    }

    override fun ingresar(dinero: Float) {
        this.saldo += dinero
    }

    override fun retirar(dinero: Float) {
        var fechaActual:Fecha = Fecha.fechaActual()
        // Condiciones para sacar el dinero de la cuenta ahorro:
        // No se puede sacar el 1er año de haberla abierto.
        // Solo se puede retirar los dias 30 de junio y diciembre.
        if (this.dataApertura.tieneMasDeUnAnio()){
            if (fechaActual.mes == 6 || fechaActual.mes == 12){
                if (fechaActual.dia == 30){
                    this.saldo -= dinero
                }else{
                    condicionesRetirada()
                }
            }else{
                condicionesRetirada()
            }
        }else{
            condicionesRetirada()
        }
    }

    override fun cobrarComision(tipo: String) {
        when (tipo) {
            "liquidación" -> this.saldo -= this.saldo * 0.03f
        }
    }

    override fun liquidar() {
        if (!dataApertura.tieneMasDeUnAnio()) cobrarComision("liquidacion")
        retirar(this.saldo)
        this.dataLiquidacion = Fecha.fechaActual()
        setLiquidada(true)
    }

    override fun toString(): String {
        return super.toString() + """
            Interés:                ${this.interes}
            Liquidada:              ${this.liquidada}
        """.trimIndent()
    }


}