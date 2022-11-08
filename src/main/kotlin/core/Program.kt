package core

import core.model.FlowMatrix
import core.model.Graph
import core.service.MaxLoadFunction
import core.service.Parser
import ea.Chromo

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
        x = FlowMatrix(demands)
        x.init()
        println(x)
        println("MUTATION")
        val chromo = Chromo(x)
        chromo.mutate()
        println(chromo.wrapee)

//        val f = MaxLoadFunction()
//        println(f.run(e,x).toString())
    }
}