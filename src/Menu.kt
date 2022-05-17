import kotlin.system.exitProcess

class Menu {
    private var opcaoMenuPrincipal: Int = 0
    private var subMenuLanches: Int = 0
    private var subMenuBebidas: Int = 0
    private val carrinhoCompras = Produtos()

    private fun menuPrincipal() {
        println("-----------------------------------------")
        println("----------- MENU PRINCIPAL --------------")
        println("---- 1 Comprar Lanche -------------------")
        println("---- 2 Comprar Bebida -------------------")
        println("---- 3 Verificar Carrinho de Compras ----")
        println("---- 4 Remover produtos do Carrinho -----")
        println("---- 5 Sair -----------------------------")
        println("-----------------------------------------")
        opcaoMenuPrincipal = Produtos().validarOpcao()
    }

    private fun subMenuLanches() {
        println("----------------------------------------------")
        println("------ Qual produto deseja comprar? ----------")
        println("----------- 1 X-BURGER R$ 10,00 --------------")
        println("----------- 2 X-SALADA R$ 12,00 --------------")
        println("----------------------------------------------")
        subMenuLanches = validarOpcoesSubMenu()
    }

    private fun subMenuBebidas() {
        println("----------------------------------------------")
        println("------ Qual produto deseja comprar? ----------")
        println("--------- 1 REFRIGERANTE R$ 8,00 -------------")
        println("--------- 2 SUCO R$ 6,00 ---------------------")
        println("----------------------------------------------")
        subMenuBebidas = validarOpcoesSubMenu()
    }

    fun redirecionamentoDoMenu() {
        while (true) {
            menuPrincipal()
            when (opcaoMenuPrincipal) {
                1 -> {
                    subMenuLanches()
                    when (subMenuLanches) {
                        1 -> {
                            val xBurger: Produtos = Lanches()
                            xBurger.redirecionar(subMenuLanches)
                            xBurger.mostrarProdutos()
                        }
                        2 -> {
                            val xSalada: Produtos = Lanches()
                            xSalada.redirecionar(subMenuLanches)
                            xSalada.mostrarProdutos()
                        }
                        else -> {
                            println(MSG_OPCAO_INVALIDA)
                            subMenuLanches()
                        }
                    }
                }
                2 -> {
                    subMenuBebidas()
                    when (subMenuBebidas) {
                        1 -> {
                            val refrigerante: Produtos = Bebidas()
                            refrigerante.redirecionar(subMenuBebidas)
                            refrigerante.mostrarProdutos()
                        }
                        2 -> {
                            val suco: Produtos = Bebidas()
                            suco.redirecionar(subMenuBebidas)
                            suco.mostrarProdutos()
                        }
                        else -> {
                            println(MSG_OPCAO_INVALIDA)
                            subMenuLanches()
                        }
                    }
                }
                3 -> carrinhoCompras.mostrarProdutos()
                4 -> carrinhoCompras.removerProdutos()
                5 -> {
                    println("Obrigado por usar nosso sistema!")
                    exitProcess(0)
                }
                else -> println(MSG_OPCAO_INVALIDA)
            }
        }
    }

    private fun validarOpcoesSubMenu(): Int {
        return try {
            var opcaoSelecionada = readln().toInt()
            while (opcaoSelecionada !in 1..2) {
                println(MSG_OPCAO_INVALIDA)
                opcaoSelecionada = readln().toInt()
            }
            opcaoSelecionada
        } catch (exception: NumberFormatException) {
            println(MSG_ERRO)
            validarOpcoesSubMenu()
        }
    }
}