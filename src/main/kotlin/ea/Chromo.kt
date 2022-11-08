package ea

import core.model.FlowMatrix

const val PROBABILITY_OF_GENE_MUTATION = 30

class Chromo(
    val wrapee: FlowMatrix,
    private val fintessValue: Int = Int.MAX_VALUE
    ) {

    fun getFlowMatrix(): FlowMatrix {
        return wrapee
    }

    fun getGene(d: Int): IntArray {
        return wrapee.body[d]
    }

    fun mutate() {
        for (d in 0 until wrapee.demandsCount) {
            println("Demand: $d")
            val x = (0..99).random()
            println("value of x: $x")
            if (x < PROBABILITY_OF_GENE_MUTATION) {
                val numberOfPaths = wrapee.demands.body[d].paths.size
                var idOfRobbedPath: Int
                println("FIRST DO")

                do {
                    idOfRobbedPath = (0 until numberOfPaths).random()
                    println("idOfRobbedPath = $idOfRobbedPath")
                    println("wrapee.body[d][idOfRobbedPath] = ${wrapee.body[d][idOfRobbedPath]}")
                } while (wrapee.body[d][idOfRobbedPath] == 0)

                var idOfAwardedPath:Int
                println("SECOND DO")

                do{
                    idOfAwardedPath = (0 until numberOfPaths).random()
                    println("idOfAwardedPath = $idOfAwardedPath")
                } while(idOfAwardedPath == idOfRobbedPath)

                wrapee.body[d][idOfRobbedPath] -= 1
                wrapee.body[d][idOfAwardedPath] += 1
            }
        }
    }
}