package produtos

class Bebidas(
    override var nome: String = "",
    override var qntd: Int = 0,
    override var valor: Double = 0.0
) : Produtos() {

}