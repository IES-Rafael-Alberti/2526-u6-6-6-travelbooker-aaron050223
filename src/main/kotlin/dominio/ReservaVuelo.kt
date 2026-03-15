package org.practicatrim2.dominio

class ReservaVuelo private constructor(
    override val descripcion: String,
    val origen: String,
    val destino: String,
    val horaVuelo: String
): Reserva() {
    companion object{
        fun crearInstancia(
            descripcion: String,
            origen: String,
            destino: String,
            horaVuelo: String
        ): ReservaVuelo {
            return ReservaVuelo(descripcion, origen, destino, horaVuelo)
        }
    }

    override val detalle: String
        get() = "$id - $descripcion - $origen -> $destino [$horaVuelo]"
}