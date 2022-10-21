class Demands {
    val body: ArrayList<Demand> = arrayListOf()

    fun add(demand: Demand){
        body.add(demand)
    }

    override fun toString(): String {
        return body.toString()
    }

    fun getMaxPathsCount(){
        //TODO
    }
}