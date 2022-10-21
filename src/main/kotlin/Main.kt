
const val FILE_NAME = "input.txt"

fun main(args: Array<String>) {
    println("Hello World!")
    val parser: Parser = Parser()
    parser.init(FILE_NAME)
    val links = parser.links
    val demands = parser.demands
    val x = FlowMatrix(demands)
    println(x)
}