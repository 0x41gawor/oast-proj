data class Path(
    val id: Int,
    val linkIdList: List<Int>
) {

    constructor(data: Path) : this(
        data.id,
        data.linkIdList
    )
}
