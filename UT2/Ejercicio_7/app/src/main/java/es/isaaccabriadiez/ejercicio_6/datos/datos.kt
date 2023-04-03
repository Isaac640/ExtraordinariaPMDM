package es.isaaccabriadiez.ejercicio_6.datos

import es.isaaccabriadiez.ejercicio_6.R

object datos {
    fun getDatosAnimales(): ArrayList<Animal>{
        return arrayListOf<Animal>(
            Animal("Ballena", R.drawable.ballena, "Ballena"),
            Animal("Bisonte", R.drawable.bisonte, "Bisonte"),
            Animal("Camaleón", R.drawable.camaleon, "Camaleon"),
            Animal("Cebra", R.drawable.cebra, "Cebra"),
            Animal("Cocodrilo", R.drawable.cocodrilo, "Cocodrilo"),
            Animal("Elefante", R.drawable.elefante, "Elefante"),
            Animal("Hipopótamo", R.drawable.hipopotamo, "Hipopotamo"),
            Animal("Jirafa", R.drawable.jirafa, "Jirafa"),
            Animal("Mono", R.drawable.mono, "Mono"),
            Animal("Venado", R.drawable.venado, "Venado"),
            Animal("Zorro", R.drawable.zorro, "Zorro")
        )
    }
}