
fun pedirString(msj :String) :String{
    try {
        print(msj)
        val entrada = readln()
        return entrada
    }catch (e:IllegalArgumentException){
        println("ERROR -> dato invalido intentelo de nuevo.")
        return pedirString(msj)
    }
}

fun pedirInt(msj :String) :Int{
    try {
        print(msj)
        val entrada = readln().toInt()
        return entrada
    }catch (e:IllegalArgumentException){
        println("ERROR -> dato invalido intentelo de nuevo.")
        return pedirInt(msj)
    }
}

fun pedirDouble(msj :String) :Double{
    try {
        print(msj)
        val entrada = readln().toDouble()
        return entrada
    }catch (e:IllegalArgumentException){
        println("ERROR -> dato invalido intentelo de nuevo.")
        return pedirDouble(msj)
    }
}


fun main(){

    val nombre = pedirString("Dame el nombre: ")
    val correoElectronico = pedirString("Dame el correo electronico: ")
    val dni = pedirString("Dame el DNI: ")

    try {
        val usuario1 = Usuario(nombre,correoElectronico,dni)
        usuario1.comprarEntradas(evento,pedirInt("Cuantas entradas quieres: "))
    }catch (e:IllegalArgumentException){"ERROR -> ${e.message}"}


}