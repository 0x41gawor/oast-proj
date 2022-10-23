class MaxLoadFunction {
    fun run(e: Graph, x: FlowMatrix): Int? {
        val y = LinkOverloadCalculator()
        return y.run(e, x).maxOrNull()
    }
}