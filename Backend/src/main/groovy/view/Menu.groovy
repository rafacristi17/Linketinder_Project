
package view

import model.Candidato
import model.Tecnologias
import regras.CandidatoRegras
import dao.CandidatoDAO
import java.util.Scanner

class Menu {

    CandidatoRegras candidatoRegras
    Scanner scanner = new Scanner(System.in)

    Menu(CandidatoDAO candidatoDAO) {
        this.candidatoRegras = new CandidatoRegras(candidatoDAO)
    }

    static void exibirMenu() {
        println("Menu:")
        println("1. Cadastrar candidato")
        println("2. Listar candidatos")
        println("3. Atualizar candidato")
        println("4. Excluir candidato")
        println("5. Sair")
        println("Escolha uma opção:")
    }

    void executar() {
        exibirMenu()
        while (true) {
            if (scanner.hasNextLine()) {
                def opcao = scanner.nextLine()
                if (opcao.isInteger()) {
                    switch (opcao.toInteger()) {
                        case 1:
                            cadastrarCandidato()
                            break
                        case 2:
                            listarCandidatos()
                            break
                        case 3:
                            atualizarCandidato()
                            break
                        case 4:
                            excluirCandidato()
                            break
                        case 5:
                            println("Saindo do programa...")
                            return
                        default:
                            println("Opção inválida.")
                    }
                } else {
                    println("Digite um número entre 1 e 5.")
                }
            } else {
                println("Nenhuma entrada detectada.")
                break
            }
        }
    }


    void cadastrarCandidato() {
        println("Digite os dados do candidato:")
        println("Nome:")
        def nome = scanner.nextLine()
        scanner.nextLine()
        println("Email:")
        def email = scanner.nextLine()
        scanner.nextLine()
        println("CPF:")
        def cpf = scanner.nextLine().toLong()
        scanner.nextLine()
        println("Idade:")
        def idade = scanner.nextLine().toInteger()
        scanner.nextLine()
        println("Estado:")
        def estado = scanner.next().trim()
        scanner.nextLine()
        println("CEP:")
        def cep = scanner.nextLong()
        scanner.nextLine()
        println("Descrição:")
        def descricao = scanner.nextLine().trim()
        scanner.nextLine()
        println("Senha:")
        def senha = scanner.nextLine()
        scanner.nextLine()

        def tecnologias = []
        println("Tecnologias (separadas por vírgula):")
        def tecInput = scanner.nextLine().split(',')
        tecInput.each { tec ->
            def tecnologia = Tecnologias.valueOf(tec.trim())
            if (tecnologia != null) {
                tecnologias << tecnologia
            } else {
                println("Tecnologia inválida: $tec")
            }
        }

        def novoCandidato = new Candidato(nome: nome, email: email, cpf: cpf, idade: idade, estado: estado, cep: cep, descricao: descricao, senha: senha, tecnologias: tecnologias)
        candidatoRegras.cadastrarCandidato(novoCandidato)
        println("Candidato cadastrado com sucesso!")
    }

    void listarCandidatos() {
        println("Listando candidatos:")
        def candidatos = candidatoRegras.listarCandidatos()
        candidatos.each {
            println(it)
        }
    }

    void atualizarCandidato() {
        println("Digite o CPF do candidato que deseja atualizar:")
        def cpf = scanner.nextLine().toLong()
        def candidato = candidatoRegras.buscarCandidato(cpf)
        if (candidato != null) {
            println("Digite os novos dados do candidato (deixe em branco para manter o mesmo):")
            println("Nome (atual: ${candidato.nome}):")
            def nome = scanner.nextLine().trim()
            if (!nome.isEmpty()) {
                candidato.nome = nome
            }
            candidatoRegras.atualizarCandidato(candidato)
            println("Candidato atualizado com sucesso!")
        } else {
            println("Candidato não encontrado.")
        }
    }

    void excluirCandidato() {
        println("Digite o CPF do candidato que deseja excluir:")
        def cpf = scanner.nextLine().toLong()
        if (candidatoRegras.excluirCandidato(cpf)) {
            println("Candidato excluído com sucesso!")
        } else {
            println("Candidato não encontrado.")
        }
    }
}
