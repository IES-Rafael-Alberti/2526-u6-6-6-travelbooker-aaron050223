package org.practicatrim2.dominio

class ReservaHotel private constructor(
    override val descripcion: String,
    val ubicacion: String,
    val numeroNoches: Int,
): Reserva() {
    companion object {
        fun crearInstancia(
            descripcion: String,
            ubicacion: String,
            numeroNoches: Int,
        ): ReservaHotel {
            return ReservaHotel(descripcion, ubicacion, numeroNoches)
        }
    }

    override val detalle: String
        get() = "$id - $descripcion - $ubicacion ($numeroNoches)"
}