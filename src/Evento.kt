class Evento(val id: Int, val nombre: String, val ciudad: CiudadesValidas, val capacidad: Int, val precio: Double){

    init {
        require(ciudad in CiudadesValidas){"El campo ciudad no puede estar vacio."} //como hacer esto
        require(nombre.isNotBlank()){"El campo nombre no puede estar vacio."}
        /*require(id){"El campo id no puede estar vacio."}
        require(entradasVendidas){"El campo entradasVendidas no puede estar vacio."}
        require(capacidad){"El campo capacidad no puede estar vacio."}*/
    }

    var entradasVendidas: Int = 0
        private set

    fun venderEntradas(cantidadEntradas: Int) :List<Entrada>?{

        if (entradasVendidas + cantidadEntradas > capacidad){
            println("No se puede comprar $cantidadEntradas, ya que no hay suficientes entradas disponibles.\nEntradas disponibles: ${capacidad-entradasVendidas}")
            return null
        }

        val entradas = mutableListOf<Entrada>()

        for (entrada in 1..cantidadEntradas){
            print("Introduce el nombre para la entrada $entrada: ")
            val nombreEntrada = readln().trim()
            require(nombreEntrada.isNotBlank()){"El nombre no puede estar vacio."}
            entradasVendidas ++
            val numEntrada = entradasVendidas

            entradas.add(Entrada(nombreEntrada,numEntrada))
        }

        return entradas
    }


    override fun toString(): String {
        return ("Evento(id = $id, nombre = $nombre, ciudad = $ciudad, capacidad = $capacidad, precio = $precio, entradasVendidas = $entradasVendidas)")
    }
}
