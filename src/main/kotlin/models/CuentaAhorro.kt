package models

import interfaces.Liquidable

class CuentaAhorro: CuentaBancaria, Liquidable {
    // Atributos
    private var interes: Float = 0.04f
    override var liquidada: Boolean = false

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
        //TODO comprobar que haya pasado justo 1 año, entonces incrementar el saldo actual con el interes actual
    }


}