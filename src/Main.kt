import java.util.*

fun main() {

    // Semana 02 ---------------------------------------------------------------

    //classificacao_de_idade()
    //conversor_de_notas_em_letras()
    //calculadora_de_desconto_progressivo()
    //classificacao_de_IMC()
    //determinacao_de_categoria_de_numeros()
    //classificacao_do_ano_bissexto()
    //validacao_de_login()
    //validacao_de_horario_de_funcionamento()

    // Semana 03 ---------------------------------------------------------------

    //somatorio_dos_N_primeiros_numeros()
    //validacao_de_senha()
    //validacao_de_senha_com_bloqueio_3_tentativas()
    //entrada_valida_de_numeros_positivos()
    //menu_de_opcoes()
    //contagem_de_digitos()
    //soma_dos_numeros_pares_em_um_intervalo()
}

// Semana 02 ---------------------------------------------------------------

fun classificacao_de_idade() {
    print("Idade:")
    var num = readLine()!!.toInt()

    if(num >= 65) {
        println("Categoria: Idoso")
    } else if (num < 65 && num >= 18) {
        println("Categoria: Adulto")
    } else if (num < 18 && num >= 13) {
        println("Categoria: Adolescente")
    } else {
        println("Categoria: Criança")
    }
}

fun conversor_de_notas_em_letras() {
    print("Nota: ")
    val nota = readLine()!!.toInt()

    if(nota >= 90) {
        println("Nota em letra: A")
        return
    }
    if(nota >= 80) {
        println("Nota em letra: B")
        return
    }
    if(nota >= 70) {
        println("Nota em letra: C")
        return
    }
    if(nota >= 60) {
        println("Nota em letra: D")
        return
    }
    println("Nota em letra: F")
    return
}

fun calculadora_de_desconto_progressivo() {
    print("Digite o preço do produto: ")
    var preco = readLine()!!.toDouble()

    fun calc_preco(desconto: Double) {
        println("Desconto: " + (preco * desconto))
        preco -= preco * desconto
        println("Preço final: $preco")
    }

    println("Preço original: R$ $preco")
    if(preco > 500) {
        calc_preco(.15)
        return
    }
    if(preco >= 101.01) {
        calc_preco(.1)
        return
    }
    if(preco <= 100) {
        calc_preco(.05)
    }
}

fun classificacao_de_IMC() {

    print("Digite o peso: ")
    val peso = readLine()!!.toDouble()

    print("Digite a altura: ")
    val altura = readLine()!!.toDouble()

    val imc = peso / (altura * altura)

    if(imc < 18.5) {
        println("Seu IMC é ${"%.2f".format(imc)} \nAbaixo do peso")
    } else if(imc >= 18.5 && imc < 24.9) {
        println("Seu IMC é ${"%.2f".format(imc)} \nPeso normal")
    } else if(imc >= 25 && imc < 29.9) {
        println("Seu IMC é ${"%.2f".format(imc)} \nSobrepeso")
    } else if(imc >= 30) {
        println("Seu IMC é ${"%.2f".format(imc)} \nObesidade")
    }
}

fun determinacao_de_categoria_de_numeros() {
    print("Digite um número: ")
    val num = readLine()!!.toInt()

    if(num > 0) {
        println("Número positivo")
    } else if(num < 0) {
        println("Número negativo")
    } else {
        println("Número neutro")
    }
}

fun classificacao_do_ano_bissexto() {
    print("Digite um ano: ")
    val ano = readLine()!!.toInt()

    if(ano % 4 == 0) {
        if(ano % 100 == 0) {
            if(ano % 400 == 0) {
                println("Ano bissexto")
            } else {
                println("Ano não bissexto")
            }
        } else {
            println("Ano bissexto")
        }
    } else {
        println("Ano não bissexto")
    }
}

fun validacao_de_login() {
    print("Digite o login: ")
    val login = readLine()!!
    print("Digite a senha: ")
    val senha = readLine()!!

    val acesso = login == "admin" && senha == "1234"
    if(acesso) {
        println("Acesso permitido: $acesso")
        return
    }
    println("Acesso permitido: $acesso")
}

fun validacao_de_horario_de_funcionamento() {
    val dias = arrayOf("domingo", "segunda", "terça", "quarta", "quinta", "sexta", "sábado")
    print("Digite o dia da semana: ")
    val dia = readln().lowercase(Locale.getDefault())
    print("Digite a hora (formato 24h): ")
    val hora = readLine()!!.toInt()

    if(dia == dias[0]) {
        println("Fechado")
        return
    }

    if(dia == dias[6]) {
        if(hora in 9..14) {
            println("Aberto")
            return
        }
        println("Fechado")
        return
    }

    if(dia == dias[1] || dia == dias[2] || dia == dias[3] || dia == dias[4] || dia == dias[5]) {
        if(hora in 9..18) {
            println("Aberto")
            return
        }
        println("Fechado")
    }
}

// Semana 03 ---------------------------------------------------------------

fun somatorio_dos_N_primeiros_numeros() {
    print("Digite um número: ")
    val num = readLine()!!.toInt()

    var soma = 0
    for(i in 1..num) {
        soma += i
    }
    println("Soma dos $num primeiros números: $soma")
}

fun validacao_de_senha() {
    val senha = "kotlin123"
    print("Senha: ")
    var inpSenha = readln()

    while (inpSenha != senha) {
        print("Senha: ")
        inpSenha = readln()
    }

    print("Acesso concedido!")

}

fun validacao_de_senha_com_bloqueio_3_tentativas() {
    val senha = "kotlin123"

    print("Digite sua senha: ")
    var inpSenha = readln()

    var tentativas = 3
    while (inpSenha != senha) {
        tentativas--

        println("Senha incorreta.")
        println("Tentativas restantes: $tentativas")

        if(tentativas <= 0) {
            println("Conta bloqueada.")
            return
        }

        print("Digite sua senha: ")
        inpSenha = readln()

    }

    println("Acesso concedido!")
}

fun entrada_valida_de_numeros_positivos() {
    var numero = 0

    do {
        print("Digite um número positivo: ")
        numero = readln().toInt()
        if (numero <= 0) {
            println("Número inválido. Tente novamente.")
        }
    } while (numero <= 0 )

    println("Você digitou um número válido: $numero")
}

fun menu_de_opcoes() {
    do {
        println("Menu:")
        println("1. Boas-vindas")
        println("2. Data e Hora")
        println("3. Sair\n")
        print("Escolha uma opção: ")
        val escolha = readln().toInt()

        if(escolha == 1) {
            println("Bem-vindo ao nosso programa!\n")
        }
        if (escolha == 2) {
            println(Date())
        }
    } while (escolha != 3)

    println("Encerrando o programa...\n")
}

fun contagem_de_digitos() {
    print("Digite um número: ")
    val numero = readln().toInt()
    var aux = numero
    var i = 0

    do {
        aux /= 10
        i++
    } while (aux != 0)

    println("O número $numero tem $i dígitos.")
}

fun soma_dos_numeros_pares_em_um_intervalo() {
    print("a: ")
    val a = readln().toInt()
    print("b: ")
    val b = readln().toInt()

    if (a > b) {
        println("'a' deve ser menor ou igual a 'b'")
        return
    }

    var soma = 0
    for(i in a..b) {
        if(i % 2 == 0) {
            soma += i
        }
    }

    println("A soma dos números pares entre $a e $b é: $soma")
}
