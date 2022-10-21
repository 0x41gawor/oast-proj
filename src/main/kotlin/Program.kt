class Program {
    val FILE_NAME = "input.txt"

    lateinit var e: Graph
    lateinit var x: FlowMatrix

    fun run() {
        val parser: Parser = Parser()
        parser.init(FILE_NAME)
        val links = parser.links
        val demands = parser.demands
        e = Graph(links,demands)
        x = FlowMatrix(demands)
        x.init()
        println(x)
    }
}