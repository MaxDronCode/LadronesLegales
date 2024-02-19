package org.example.controllers

import models.Cliente
import utilities.*
import java.util.*

fun main() {
    // Almacenamiento de datos en forma de List
    val clientes: MutableList<Cliente> = mutableListOf()
    var salir:Boolean = false
    while (!salir) {
        menuBienvenida() // Se le da la bienvenida al usuario
        // Se le pregunta si es cliente
        val esCliente: Boolean = readYesNo("Introduzca s/n.", "s", "n", "Tipo de dato erróneo")
        // Diferentes procedimientos en funcion de si es cliente o no.
        when (esCliente) {
            true -> {
                bienvenidaEsCLiente()
                iniciarSesion()
                val autDNI:String = readWord("Introduzca aquí su DNI:","Tipo de dato erroneo.").uppercase()
                val autApe:String = readWord("Y aquí su segundo Apellido:","Tipo de dato erroneo.").lowercase()
                TODO("Acabar de implementar una funcion de autenticacion de DNI y segundo apellido")
            }

            else -> {
                // Se le da la bienvenida y se le pregunta si quiere darse de alta
                bienvenidaNoCLiente()
                val quiereAlta: Boolean = readYesNo("Introduzca s/n.", "s", "n", "Tipo de dato erróneo")
                when (quiereAlta) {
                    true ->{ // Se le piden los datos para el alta.
                        val dni = readWord("Introduzca su DNI porfavor, sin espacios","Tipo de dato erroneo").uppercase()
                        val nombre:String = readWord("Introduzca su nombre porfavor.","Tipo de dato erroneo").lowercase()
                        val apellido1:String = readWord("Introduzca su primer apellido porfavor.","Tipo de dato erroneo").lowercase()
                        val apellido2:String = readWord("Introduzca su segundo apellido porfavor.","Tipo de dato erroneo").lowercase()
                        // Se crea el cliente
                        val cliente:Cliente = Cliente(dni, nombre, apellido1, apellido2)
                        clientes.add(cliente)
                        yaEsCliente()
                        }
                    // El cliente no quiere nada.
                    else -> despedida()
                    }

                }


            }
        }
    }
}