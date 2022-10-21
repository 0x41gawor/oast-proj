class Links {
    val body: ArrayList<Link> = arrayListOf()

    fun add(link: Link){
        body.add(link)
    }

    override fun toString(): String {
        return body.toString()
    }
}