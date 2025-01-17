enum class CiudadesValidas {
    SEVILLA, MADRID, BARCELONA, VALENCIA, MALAGA, BILBAO;

    override fun toString(): String {
        return name.lowercase()
            .replaceFirstChar { it.uppercase() } // Convierte la primera letra a mayúscula
    }
}