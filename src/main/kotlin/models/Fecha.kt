package models

import java.text.SimpleDateFormat
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
    fun obtenerFechaComoTexto(): String {
        val calendar = Calendar.getInstance()
        calendar.set(anyo, mes - 1, dia)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        return dateFormat.format(calendar.time)
    }
    fun tieneMasDeUnAnio(): Boolean {
        val fechaActual = fechaActual()
        val diferenciaEnAnios = fechaActual.anyo - this.anyo
        if (diferenciaEnAnios > 1) {
            return true
        } else if (diferenciaEnAnios == 1) {
            // Verificar si la fecha actual está en un mes posterior al de la fecha almacenada
            if (fechaActual.mes > this.mes) {
                return true
            } else if (fechaActual.mes == this.mes) {
                // Verificar si la fecha actual está en el mismo mes pero en un día posterior
                if (fechaActual.dia >= this.dia) {
                    return true
                }
            }
        }
        return false
    }

}
