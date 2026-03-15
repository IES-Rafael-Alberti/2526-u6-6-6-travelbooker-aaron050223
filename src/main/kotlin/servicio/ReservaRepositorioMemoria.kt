package org.practicatrim2.servicio

import org.practicatrim2.servicio.IReservaRepositorio
import org.practicatrim2.dominio.Reserva

class ReservaRepositorioMemoria: IReservaRepositorio {
    private val listaReservas: MutableList<Reserva> = mutableListOf()

    override fun agregar(reserva: Reserva) {
        listaReservas.add(reserva)
    }

    override fun obtenerTodas() = listaReservas
}