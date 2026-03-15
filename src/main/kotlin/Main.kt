package org.practicatrim2

import org.practicatrim2.servicio.ReservaRepositorioMemoria
import org.practicatrim2.servicio.ReservaService
import org.practicatrim2.presentacion.Consola
import org.practicatrim2.servicio.Gestor

fun main() {
    Gestor(Consola(), ReservaService(ReservaRepositorioMemoria())).ejecutar()
}