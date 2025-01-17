data class Entrada(val nombre: String, val numero :Int){
    init {
        require(nombre.isNotEmpty()){"El nomrbe no puede estar vacio."}
    }

    var idEntrada :Int = 0 /* contador para hacer un identificador? */

    companion object{

    }
}
