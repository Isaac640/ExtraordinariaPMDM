package es.isaaccabriadiez.ejercicio_6.datos

import es.isaaccabriadiez.ejercicio_6.R

object datos {
    fun getDatosAnimales(): ArrayList<Animal>{
        return arrayListOf<Animal>(
            Animal("Ballena", R.drawable.ballena, "Ballena", 0),
            Animal("Bisonte", R.drawable.bisonte, "Bisonte", 0),
            Animal("Camaleón", R.drawable.camaleon, "Camaleon", 0),
            Animal("Cebra", R.drawable.cebra, "Cebra", 0),
            Animal("Cocodrilo", R.drawable.cocodrilo, "Cocodrilo", 0),
            Animal("Elefante", R.drawable.elefante, "Elefante", 0),
            Animal("Hipopótamo", R.drawable.hipopotamo, "Hipopotamo", 0),
            Animal("Jirafa", R.drawable.jirafa, "Jirafa", 0),
            Animal("Mono", R.drawable.mono, "Mono", 0),
            Animal("Venado", R.drawable.venado, "Venado", 0),
            Animal("Zorro", R.drawable.zorro, "Zorro", 0)
        )
    }
}