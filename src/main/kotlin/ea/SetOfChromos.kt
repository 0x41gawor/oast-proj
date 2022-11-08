package ea

import core.model.Graph
import core.service.MaxLoadFunction

class SetOfChromos(
    private val graph: Graph
) {
    private var body: ArrayList<Chromo> = arrayListOf()

    fun add(chromo: Chromo) {
        body.add(chromo)
    }

    fun selectBest(n: Int): SetOfChromos {
        calculateFitnessValues()
        val returnedList = ArrayList<Chromo>()
         body.sortByDescending { it.fintessValue }

        for (i in 0 until n) {
            returnedList.add(body[i])
        }

        val result = SetOfChromos(graph)
        result.setBody(returnedList)

        return result
    }

    fun show() {
        var i = 1
        for (chromo in body) {
            println("Chromo index: ${i++}\n$chromo")
        }
    }

    private fun calculateFitnessValues() {
        for (chromo in body) {
            val f = MaxLoadFunction()
            chromo.fintessValue = f.run(graph, chromo.getFlowMatrix())
        }
    }

    private fun setBody(list: ArrayList<Chromo>) {
        this.body = list
    }
}