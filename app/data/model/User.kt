package bf.amido.sawadogo.boutique.data.model


data class User(
    val id: String = "",
    val email: String = "",
    val name: String? = null,
    val phone: String? = null,
    val address: String? = null,
    val createdAt: String = ""
)