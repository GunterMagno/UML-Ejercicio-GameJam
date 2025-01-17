class Usuario(val nombre :String,val email :String, val dni :String){

    init {
        require(nombre.isNotBlank()){"El nombre no puede estar vacio."}
        require(validarEmail(email)){"El correo electronico es invalido."}
        require(validarDNI(dni)){"El DNI es invalido."}
    }

    val entradas = mutableMapOf<Evento, MutableList<Entrada>>()

    companion object{
        private const val MAX_Permitido = 6
    }

    fun comprarEntradas(evento: Evento, cantidadEntradas :Int) :Boolean{

        val entradasCompradas = entradas[evento]?.size ?: 0

        if (cantidadEntradas > 0 || cantidadEntradas <= MAX_Permitido - entradasCompradas){
            println("ERROR, el usuario $nombre no puede comprar mas entradas para este evento. Actualmente $entradasCompradas entradas compradas, tiene disponible ${MAX_Permitido - entradasCompradas}")
            return false
        }

        try {
            val nuevasEntradas = venderEntradas(cantidadEntradas)
            if (nuevasEntradas == null){
                println("No hay suficientes entradas disponibles para el evento ${evento.nombre}")
                return false
            }
        }catch (e :IllegalArgumentException){e.message}


        if(!entradas.containsKey(evento)){entradas[evento] = mutableListOf()}

        for (entrada in nuevasEntradas){entradas[evento]?.add(entrada)}

        return true
    }

    fun validarEmail(email :String) :Boolean{
        return true
    }

    fun validarDNI(DNI :String) :Boolean{
        return true
    }

    override fun toString(): String {
        return "Usuario(nombre = $nombre, dni = $dni, email = $email, entradas = $entradas)"
    }
}
