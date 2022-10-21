class FlowMatrix(demands: Demands) {
    private var body: Array<IntArray> = arrayOf()
    private val volumes: ArrayList<Int> = arrayListOf()
    private var demandsCount = 0
    private var pathsCount = 0

    init {
        demandsCount = demands.size()
        println(demandsCount)
        pathsCount = demands.getMaxPathsCount()
        println(pathsCount)
        body = Array(demandsCount) { IntArray(pathsCount) { Int.MAX_VALUE } }
        for (i in 0 until demandsCount) {
            volumes.add(demands.body[i].volume)
        }
    }

    override fun toString(): String {
        print("    ")
        for (p in 0 until pathsCount) {
            print("p$p ")
        }
        println(" hd")
        for (d in 0 until demandsCount) {
            print("d$d: ")
            for (p in 0 until pathsCount) {
                val item = body[d][p]
                if (item == Int.MAX_VALUE) {
                    print(" - ")
                } else {
                    if (item < 10) {
                        print(" $item ")
                    } else {
                        print("$item ")
                    }
                }
            }
            if (volumes[d] < 10) {
                println("  ${volumes[d]}")
            } else {
                println(" ${volumes[d]}")
            }
        }
        return ""
    }
}