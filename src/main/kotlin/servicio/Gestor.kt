package org.practicatrim2.servicio

import org.practicatrim2.servicio.ReservaService
import org.practicatrim2.datos.DatosHotel
import org.practicatrim2.datos.DatosVuelo
import org.practicatrim2.presentacion.Consola

@Suppress("SENSELESS_COMPARISON") // PARA QUE NO ME SALTE AVISOS EN EL IDE POR NO USAR WHILE TRUE EN LOS BUCLES
class Gestor(val io: Consola, val reservaService: ReservaService) {

    private fun mostrarOpciones() {
        io.log("--- OPCIONES ---")
        io.log("1) Reservar Vuelo")
        io.log("2) Reservar Hotel")
        io.log("3) Mostrar Reservas")
        io.log("4) Salir")
        io.log("Elección:")
    }

    private fun leerEleccion(): Int? {
        val eleccion = readln().toIntOrNull()
        return eleccion
    }

    private fun solicitarHoraVuelo(): String {
        do {
            val horaVuelo = readln()
            val formato = """^([01][0-9]|2[0-3]):[0-5][0-9]$""".toRegex()
            if (formato.matches(horaVuelo)) {
                return horaVuelo
            }
            io.log("Formato de hora incorrecto, vuelve a intentarlo:")
        } while (!formato.matches(horaVuelo))
        return ""
    }

    private fun solicitarDatosVuelo(): DatosVuelo {
        io.log("Descripción:")
        val descripcion = readln()
        io.log("Origen:")
        val origen = readln()
        io.log("Destino:")
        val destino = readln()
        io.log("Hora del vuelo:")
        val horaVuelo = solicitarHoraVuelo()
        return DatosVuelo(descripcion, origen, destino, horaVuelo)
    }

    private fun solicitarNumeroNoches(): Int {
        do {
            val numeroNoches = readln().toIntOrNull()
            if (numeroNoches != null) {
                return numeroNoches
            }
            io.log("Numero de noches incorrecto, vuelve a intentarlo:")
        } while (numeroNoches == null)
        return 0
    }

    private fun solicitarDatosHotel(): DatosHotel {
        io.log("Descripción:")
        val descripcion = readln()
        io.log("Ubicación:")
        val ubicacion = readln()
        io.log("Numero de noches:")
        val numeroNoches = solicitarNumeroNoches()
        return DatosHotel(descripcion, ubicacion, numeroNoches)
    }

    fun ejecutar() {
        do {
            mostrarOpciones()
            val eleccion = leerEleccion()
            if (eleccion == null) {
                io.log("Opción no disponible")
            } else {
                when (eleccion) {
                    1 -> {
                        val (descripcion, origen, destino, horaVuelo) = solicitarDatosVuelo()
                        reservaService.addVuelo(descripcion,origen,destino,horaVuelo)
                    }
                    2 -> {
                        val (descripcion, ubicacion, numeroNoches) = solicitarDatosHotel()
                        reservaService.addHotel(descripcion,ubicacion,numeroNoches)
                    }
                    3 -> {
                        io.log("--- RESERVAS REALIZADAS ---")
                        reservaService.repositorioReservas.obtenerTodas().forEach { io.log(it.toString()) }
                    }
                    4 -> io.log("Saliendo...")
                    else -> io.log("Opción no disponible")
                }
            }
        } while (eleccion != 4)
    }
}