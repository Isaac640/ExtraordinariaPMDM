fun main() {
    var numero: Int
    do {
        println("Introduzca un número positivo")
        numero = readln().toInt()
    } while (numero <= 0)

    do {
        println("1. Contar cuántas cifras tiene\n" +
            "2. Escriba sus primeros 10 múltiplos\n" +
            "3. Decir si es perfecto\n" +
            "4. Salir")

        println("Introduce una opción")
        var opcion = readln().toInt()

        when (opcion) {
            1 -> contar(numero)

            2 -> diezMultiplos(numero)

            3 -> numeroPerfecto(numero)

            else -> {
                println("Opción incorrecta")
            }
        }
    } while (opcion != 4)

}

fun contar(numero: Int) {
    println("El número de dígitos es ${numero.toString().count()}");
}

fun diezMultiplos(numero: Int) {
    for (i in 1..10)
        println("${numero * i} es múltiplo de $numero")
}

fun numeroPerfecto(numero: Int) {
    var perfecto = 0
    for (i in 1..numero / 2) {
        if (numero % i == 0)
            perfecto += i
    }
    println(
        "El número " +
                if (perfecto != numero) "no es perfecto" else "es perfecto"
    )
}