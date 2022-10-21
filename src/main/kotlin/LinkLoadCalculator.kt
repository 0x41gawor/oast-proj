class LinkLoadCalculator {
    fun run(e: Graph, x: FlowMatrix): IntArray {

        val l = IntArray(e.links.body.size) { 0 }
        for (demand in e.demands.body) {
            for (path in demand.paths) {
                for (link in e.links.body) {
                    if (path.contain(link.id)) {
                        l[link.id-1] += x.body[demand.id-1][path.id-1]
                    }
                }
            }
        }

        for (element in l) {
            print("$element ")
        }

        return l
    }
}