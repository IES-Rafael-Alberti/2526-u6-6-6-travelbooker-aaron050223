package org.practicatrim2.dominio

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Representa una reserva genérica.
 *
 * Esta clase es de tipo [abstract], por lo que no se puede instanciar directamente.
 * Crea la estructura base de la clase para subclases de reservas como vuelos u hoteles.
 *
 * @property id Identificador único que se crea automáticamente.
 * @property fechaCreacion Fecha en la que se registró la reserva en formato "dd-MM-yyyy".
 */
abstract class Reserva {
    companion object {
        private var contador = 0
        private val formato = DateTimeFormatter.ofPattern("dd-MM-yyyy")

        private fun getNuevoid(): Int {
            contador += 1
            return contador
        }

        private fun getFecha(): String {
            return LocalDateTime.now().format(formato)
        }
    }

    val id: Int = getNuevoid()
    val fechaCreacion = getFecha()
    abstract val descripcion: String
    abstract val detalle: String

    override fun toString(): String {
        return "$detalle Extra -> $fechaCreacion"
    }
}