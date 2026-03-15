package org.practicatrim2.servicio

import org.practicatrim2.dominio.ReservaHotel
import org.practicatrim2.dominio.ReservaVuelo

class ReservaService(val repositorioReservas: IReservaRepositorio) {
    fun addVuelo(
        descripcion: String,
        origen: String,
        destino: String,
        horaVuelo: String
    ) {
        repositorioReservas.agregar(ReservaVuelo.Companion.crearInstancia(descripcion, origen, destino, horaVuelo))
    }

    fun addHotel(
        descripcion: String,
        ubicacion: String,
        numeroNoches: Int,
    ) {
        repositorioReservas.agregar(ReservaHotel.Companion.crearInstancia(descripcion, ubicacion, numeroNoches))
    }
}