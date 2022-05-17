class Lanches(
    override var nome: String = "",
    override var qntd: Int = 0,
    override var valor: Double = 0.0
) : Produtos() {

    override fun redirecionar(subMenu: Int) {
        when (subMenu) {
            1 -> selecionarXBurger()
            2 -> selecionarXSalada()
        }
    }

    private fun pedirQuantidade(item: String): Int {
        var quantidade = 0
        println("Qual quantidade de $item que deseja comprar?")
        quantidade = validarOpcao()
        return quantidade
    }

    private fun selecionarXBurger() {
        val qnt = pedirQuantidade(X_BURGER)
        val xBurger = Lanches(X_BURGER, qnt, VALOR_X_BURGER)
        receberProdutos(xBurger)
    }

    private fun selecionarXSalada(): Produtos {
        val qnt = pedirQuantidade(X_SALADA)
        val xSalada = Lanches(X_SALADA, qnt, VALOR_X_SALADA)
        receberProdutos(xSalada)
        return xSalada
    }
}