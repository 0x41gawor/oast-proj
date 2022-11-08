package ea

import core.model.FlowMatrix
import core.model.Graph
import core.service.MaxLoadFunction

const val PROBABILITY_OF_CHROMO_MUTATION = 5


class SetOfChromos(
    private val graph: Graph
) {
    private var body: ArrayList<Chromo> = arrayListOf()

    fun mutate() {
        var i = 1
        for (chromo in body) {
            val x = (0..99).random()
            if (x < PROBABILITY_OF_CHROMO_MUTATION) {
                println("mutacja w $i index")
                chromo.mutate()
            }
            i++
        }
        calculateFitnessValues()
    }

    fun crossover(): Chromo {
        // QUEEN OF THE BEES
        val parent = Array(2) { body[0] }
        parent[0] = selectBest(1).body[0]
        parent[1] = selectRandom()

        val childFlowMatrix = FlowMatrix(graph.demands)
        val child = Chromo(childFlowMatrix)

        // pętla po liczbie genów (kolumn - demandów)
        for (d in 0 until graph.demands.count()) {
            // z którego rodzica bierzemy gen?
            val x = (0..1).random()
            // insert genu z rodzica do dziecka
            child.insertGene(d, parent[x].getGene(d))
        }

        return child
    }

    fun selectBest(n: Int): SetOfChromos {
        calculateFitnessValues()

        val returnedList = ArrayList<Chromo>()

        body.sortBy { it.fintessValue }

        for (i in 0 until n) {
            returnedList.add(body[i])
        }

        val result = SetOfChromos(graph)
        result.setBody(returnedList)

        return result
    }

    fun init(n: Int) {
        val x = FlowMatrix(graph.demands)
        x.init()
        val chromo = Chromo(x)
        add(chromo)
    }

    fun add(chromo: Chromo) {
        body.add(chromo)
    }

    fun add(set: SetOfChromos) {
        body.addAll(set.body)
    }

    fun show() {
        var i = 1
        for (chromo in body) {
            println("Chromo index: ${i++}\n$chromo")
        }
    }

    private fun selectRandom(): Chromo {
        val x = (1 until body.size).random()
        println("SelectRandom: $x")
        return body[x]
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