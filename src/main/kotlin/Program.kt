class Program {
    private val fileName = "input.txt"

    lateinit var e: Graph
    lateinit var x: FlowMatrix

    fun run() {
        val parser = Parser()
        parser.init(fileName)
        val links = parser.links
        val demands = parser.demands
        e = Graph(links,demands)
        x = FlowMatrix(demands)
        x.init()
        println(x)
        val linkOverloadCalculator = LinkOverloadCalculator()
        linkOverloadCalculator.run(e,x).toString()
    }
}