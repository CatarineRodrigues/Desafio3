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

    private fun selecionarRefigerante() {
        val qnt = pedirQuantidade(REFRIGERANTES)
        val refigerante = Lanches(REFRIGERANTES, qnt, VALOR_REFRIGERANTE)
        receberProdutos(refigerante)
    }

    private fun selecionarSuco() {
        val qnt = pedirQuantidade(SUCOS)
        val suco = Lanches(SUCOS, qnt, VALOR_SUCO)
        receberProdutos(suco)
    }
}