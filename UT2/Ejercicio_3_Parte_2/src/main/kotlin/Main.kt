fun main() {
   mediaNota("DAW2",6.1f,9.8f,10f, tutor="Carmen")
   mediaNota("DAM2", 5.1f,4.6f,2.8f)
}

fun mediaNota(grupo: String, vararg notas: Float, tutor: String="Iván") {
   println("Media de notas del grupo $grupo: ${"%.2f".format(notas.average())} Tutor: $tutor")
}