package interfaces

import models.Fecha

interface Liquidable {
    // Atributos
    var liquidada:Boolean
    var dataLiquidacion:Fecha
    // Métodos
    abstract fun liquidar()
}