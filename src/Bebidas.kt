class Bebidas(
    override var nome: String = "",
    override var qntd: Int = 0,
    override var valor: Double = 0.0
) : Produtos() {

    override fun redirecionar(subMenu: Int) {
        when (subMenu) {
            1 -> selecionarRefigerante()
            2 -> selecionarSuco()
        }
    }

    private fun pedirQuantidade(item: String): Int {
        println("Qual quantidade de $item que deseja comprar?")
        qntd = validarOpcao()
        return qntd
    }

    private fun valorProdutos(qntd: Int, valorProduto: Double) {
        val resultado = qntd * valorProduto
        println(resultado)
    }

    fun guardarProduto(produtos: Produtos): Int {
        contador++
        dicionario[contador] = (produtos)
        return contador
    }

    private fun selecionarRefigerante() {
        val qnt = pedirQuantidade(REFRIGERANTES)
        valorProdutos(qnt,VALOR_REFRIGERANTE)
        val refigerante = Lanches(REFRIGERANTES, qnt, VALOR_REFRIGERANTE)
        println(guardarProduto(refigerante))
    }

    private fun selecionarSuco() {
        val qnt = pedirQuantidade(SUCOS)
        valorProdutos(qnt,VALOR_SUCO)
        val suco = Lanches(SUCOS, qnt, VALOR_SUCO)
        println(guardarProduto(suco))
    }
}