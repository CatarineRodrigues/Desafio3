package menu

import carrinho.Carrinho
import MSG_ERRO
import MSG_OPCAO_INVALIDA
import kotlin.system.exitProcess

class Menu {
    private var opcaoMenuPrincipal: Int = 0
    private var subMenuLanches: Int = 0
    private var subMenuBebidas: Int = 0
    private val carrinhoCompras = Carrinho()

    private fun menuPrincipal() {
        println("-----------------------------------------")
        println("----------- MENU PRINCIPAL --------------")
        println("---- 1 Comprar Lanche -------------------")
        println("---- 2 Comprar Bebida -------------------")
        println("---- 3 Verificar carrinho.Carrinho de Compras ----")
        println("---- 4 Remover produtos do carrinho.Carrinho -----")
        println("---- 5 Finalizar Compra -----------------")
        println("---- 6 Sair -----------------------------")
        println("-----------------------------------------")
        opcaoMenuPrincipal = carrinhoCompras.validarNumeroDigitado()
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
                            carrinhoCompras.redirecionarLanche(subMenuLanches)
                            carrinhoCompras.mostrarProdutos()
                        }
                        2 -> {
                            carrinhoCompras.redirecionarLanche(subMenuLanches)
                            carrinhoCompras.mostrarProdutos()
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
                            carrinhoCompras.redirecionarBebida(subMenuBebidas)
                            carrinhoCompras.mostrarProdutos()
                        }
                        2 -> {
                            carrinhoCompras.redirecionarBebida(subMenuBebidas)
                            carrinhoCompras.mostrarProdutos()
                        }
                        else -> {
                            println(MSG_OPCAO_INVALIDA)
                            subMenuLanches()
                        }
                    }
                }
                3 -> carrinhoCompras.mostrarProdutos()
                4 -> carrinhoCompras.removerProdutos()
                5 -> carrinhoCompras.finalizarPedido()
                6 -> {
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