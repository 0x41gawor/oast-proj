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
            println("Obecne1 P: $P")
            val O = SetOfChromos(e)
            println("Obecne2 P: $P")
            println("Puste O: $O")
            println("Obecne3 P: $P")
            for (i in 0 until K) {
                println("Obecne4 P: $P")
                O.add(P.crossover())
                println("Obecne5 P: $P")
            }
            println("Obecne6 P: $P")
            println("O przed mutacja: $O")
            println("Obecne7 P: $P")
            O.mutate()
            println("Obecne8 P: $P")
            println("O po mutacji: $O")
            println("P przed dodaniem O: $P")
            P.add(O)
            println("P przed select best$P")
            P = P.selectBest(N)
            println("Obecne P (po select best): $P")
            n++
        }
    }
}