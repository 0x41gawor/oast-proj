data class Demand(
    val id: Int,
    val srcNode: Int,
    val dstNode: Int,
    val volume: Int,
    val paths: List<Path>
) {
    constructor(data: Demand) : this(
        data.id,
        data.srcNode,
        data.dstNode,
        data.volume,
        data.paths
    )
}

