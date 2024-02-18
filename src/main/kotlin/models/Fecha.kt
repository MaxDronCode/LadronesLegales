package models

import java.util.Calendar

data class Fecha(val dia:Int, val mes:Int, val anyo:Int) {
    companion object {
        fun fechaActual(): Fecha {
            val calendario = Calendar.getInstance()
            val dia = calendario.get(Calendar.DAY_OF_MONTH)
            val mes = calendario.get(Calendar.MONTH) + 1 // Sumar 1 porque en Calendar enero es 0
            val anyo = calendario.get(Calendar.YEAR)
            return Fecha(dia, mes, anyo)
        }
    }
}
