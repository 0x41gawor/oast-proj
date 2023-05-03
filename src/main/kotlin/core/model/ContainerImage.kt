package core.model

data class ContainerImage(
    val Id:  Int,
    val ServiceId: Int,
    val CPU: Int,
    val RAM: Int,
    val SAU: Int,
) {
}