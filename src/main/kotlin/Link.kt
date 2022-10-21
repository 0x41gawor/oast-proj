data class Link(
    val id: Int,
    val srcNode: Int,
    val dstNode: Int,
    val capacity: Int
) {

    constructor(data: Link) : this(
        data.id,
        data.srcNode,
        data.dstNode,
        data.capacity
    )
}

