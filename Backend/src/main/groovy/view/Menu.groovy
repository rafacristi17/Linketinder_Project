package view

import model.Candidato
import model.Tecnologias
import regras.CandidatoRegras
import dao.CandidatoDAO

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
            def opcao = scanner.nextLine()

            switch (opcao) {
                case '1':
                    cadastrarCandidato()
                    break
                case '2':
                    listarCandidatos()
                    break
                case '3':
                    atualizarCandidato()
                    break
                case '4':
                    excluirCandidato()
                    break
                case '5':
                    println("Saindo do programa...")
                    return
                default:
                    println("Opção inválida.")

            }
        }
    }

    void cadastrarCandidato() {
        println("Digite os dados do candidato:")
        println("Nome:")
        def nome = scanner.nextLine()
        println("Email:")
        def email = scanner.nextLine()
        println("CPF:")
        def cpf = scanner.nextLong()
        scanner.nextLine()
        println("Idade:")
        def idade = scanner.nextInt()
        scanner.nextLine()
        println("Estado:")
        def estado = scanner.nextLine()
        println("CEP:")
        def cep = scanner.nextLong()
        scanner.nextLine()
        println("Descrição:")
        def descricao = scanner.nextLine()
        println("Senha:")
        def senha = scanner.nextLine()

        println("Tecnologias (separadas por vírgula):")
        def tecInput = scanner.nextLine()
        def tecnologias = new Tecnologias(tecInput)

        def novoCandidato = new Candidato(nome: nome, email: email, cpf: cpf, idade: idade, estado: estado, cep: cep, descricao: descricao, senha: senha, tecnologias: tecnologias.nomes)

        try {
            candidatoRegras.cadastrarCandidato(novoCandidato)
            println("Candidato cadastrado com sucesso!")
        } catch (IllegalArgumentException e) {
            println("Erro ao cadastrar o candidato: ${e.message}")
        } finally {
            retornarAoMenu()
        }
    }

    void listarCandidatos() {
        println("Listando candidatos:")
        def candidatos = candidatoRegras.listarCandidatos()
        candidatos.each {
            println(it)
        }
        retornarAoMenu()
    }

    void atualizarCandidato() {
        println("Digite o ID do candidato que deseja atualizar:")
        def id = scanner.nextLine().toLong()
        def candidato = candidatoRegras.buscarCandidato(id)
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
        retornarAoMenu()
    }

    void excluirCandidato() {
        println("Digite o ID do candidato que deseja excluir:")
        def id = scanner.nextLine().toLong()
        if (candidatoRegras.excluirCandidato(id)) {
            println("Candidato excluído com sucesso!")
        } else {
            println("Candidato não encontrado.")
        }
        retornarAoMenu()
    }

    void retornarAoMenu() {
        println("Pressione Enter para retornar ao menu principal.")
        scanner.nextLine()
        exibirMenu()
    }
}
