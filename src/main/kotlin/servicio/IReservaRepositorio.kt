package org.practicatrim2.servicio

import org.practicatrim2.dominio.Reserva

interface IReservaRepositorio {
    fun agregar(reserva: Reserva)
    fun obtenerTodas(): MutableList<Reserva>
}