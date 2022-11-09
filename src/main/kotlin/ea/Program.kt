package ea

import core.model.Graph
import core.service.Parser

const val N = 10  // liczba chromosomów w populacji
const val K = 4   // liczba robionych dzieci podczas crossover

class Program {
    private val fileName = "input.txt"

    lateinit var e: Graph

    fun run() {
        val parser = Parser()
        parser.init(fileName)
        val links = parser.links
        val demands = parser.demands
        e = Graph(links, demands)

        var n = 0 // licznik generacji
        var P = SetOfChromos(e).init(N)

        println("Populacja zerowa: $P")

        while (n < 10) {
            println("==============Generacja: $n ================")
            println(" Pocz a t k o we P: $P")
            val O = SetOfChromos(e)
            println("Puste O: $O")
            for (i in 0 until K) {
                val child = P.crossover()
                O.add(child)
            }
            println("O przed mutacja: $O")
            O.mutate()
            println("O   po  mutacji: $O")
            println("P przed dodaniem O: $P")
            P.add(O)
            println("P przed selec best: $P")
            P = P.selectBest(N)
            println("P (po select best): $P")
            n++
        }
    }
}