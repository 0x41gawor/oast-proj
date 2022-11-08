package core

import core.model.FlowMatrix
import core.model.Graph
import core.service.Parser
import ea.Chromo
import ea.SetOfChromos

class Program {
    private val fileName = "input.txt"

    lateinit var e: Graph
    lateinit var x: FlowMatrix

    fun run() {
        val parser = Parser()
        parser.init(fileName)
        val links = parser.links
        val demands = parser.demands
        e = Graph(links, demands)
        val setOfChromos = SetOfChromos(e)
        for(i in 1..10){
            x = FlowMatrix(demands)
            x.init()
            val chromo = Chromo(x)
            setOfChromos.add(chromo)
        }
    }
}