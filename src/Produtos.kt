import kotlin.system.exitProcess

open class Produtos {
    protected open var nome: String = ""
    open var qntd: Int = 0
    open var valor: Double = 0.0
    val dicionario = mutableMapOf<Int, Produtos>()
    open var contador: Int = 0
//    protected val listaLanches = ArrayList<Produtos>()

    open fun redirecionar(subMenu: Int) {}

    fun validarOpcao(): Int {
        return try {
            var opcaoSelecionada = readln().toInt()
            while (opcaoSelecionada <= 0) {
                println(MSG_OPCAO_INVALIDA)
                opcaoSelecionada = readln().toInt()
            }
            opcaoSelecionada
        } catch (exception: NumberFormatException) {
            println(MSG_ERRO)
            validarOpcao()
        }
    }

    fun mostrarProdutos() {
        println("Verificar itens salvos no Carrinho")
        dicionario.forEach { (chave, valor) ->
            println("$chave - ${valor.qntd} ${valor.nome} - ${valor.qntd*valor.valor}")
        }
    }

    fun removerProdutos() {
        try {
            println("Digite o código do item que deseja remover")
            val numero = readln().toInt()
            println("----------------------")
            println("Foi removida o item de número $numero")
            dicionario.remove(numero)
            println("----------------------")

        } catch (exception: Exception) {
            println("Causa: ${exception.cause}")
            println("Mensagem: ${exception.message}")
            println("Para sair aperte '1', para voltar pressione qualquer tecla")
            when (readln()) {
                "1" -> {
                    println("Obrigado por usar nosso sistema!")
                    exitProcess(0)
                }
                else -> println("Retornando ao Menu Principal")
            }
        }
    }

}