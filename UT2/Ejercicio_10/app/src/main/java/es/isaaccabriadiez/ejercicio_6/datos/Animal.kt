package es.isaaccabriadiez.ejercicio_6.datos

import java.io.Serializable

data class Animal(val nombre: String, val imagenId: Int, val descripcion: String, var votos: Int): Serializable
