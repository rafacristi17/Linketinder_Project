package view

import dao.CandidatoDAO
import model.Candidato
import model.Tecnologias
import regras.CandidatoRegras

class Menu {
    CandidatoRegras candidatoRegras
    Scanner sc = new Scanner(System.in)

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
            if (System.console() != null) {
                def opcao = System.console().readLine("Escolha uma opção: ")
                switch (opcao) {
                    case "1":
                        cadastrarCandidato()
                        break;
                    case "2":
                        listarCandidatos()
                        break;
                    case "3":
                        atualizarCandidato()
                        break;
                    case "4":
                        excluirCandidato()
                        break;
                    case "5":
                      println("Saindo do programa...")

                    default:
                        println("Opção inválida.")
                }
            }

        }

    }


    void cadastrarCandidato() {
        println("Digite os dados do candidato:")
        println("Nome:")
        String nome = sc.nextLine()
        println("Email:")
        String email = sc.nextLine()
        println("CPF:")
        String cpfString = sc.nextLine()
        cpfString = cpfString.replaceAll("\\.", "").replaceAll("-", "")
        Long cpf = Long.parseLong(cpfString)
        println("Idade:")
        Integer idade = Integer.parseInt(sc.nextLine())
        println("Estado:")
        String estado = sc.nextLine()
        println("CEP:")
        String cepString = sc.nextLine()
        cepString = cepString.replaceAll("\\.", "").replaceAll("-", "")
        Long cep = Long.parseLong(cepString)
        println("Descrição:")
        String descricao = sc.nextLine()
        println("Senha:")
        String senha = sc.nextLine()

        def tecnologias = []
        println("Tecnologias (separadas por vírgula):")
        String[] tecInput = sc.nextLine().split(',')
        tecInput.each { tec ->
            def tecnologia = Tecnologias.valueOf(tec.trim())
            if (tecnologia != null) {
                tecnologias << tecnologia
            } else {
                println("Tecnologia inválida: $tec")
            }
        }

        Candidato novoCandidato = new Candidato(nome: nome, email: email, cpf: cpf, idade: idade, estado: estado, cep: cep, descricao: descricao, senha: senha, tecnologias: tecnologias)
        candidatoRegras.cadastrarCandidato(novoCandidato)
        println("Candidato cadastrado com sucesso!")
    }

    void listarCandidatos() {
        println("Listando candidatos:")
        List<Candidato> candidatos = candidatoRegras.listarCandidatos()
        candidatos.each {
            println(it)
        }
    }

    void atualizarCandidato() {
        println("Digite o CPF do candidato que deseja atualizar:")
        String cpfString = sc.nextLine()
        cpfString = cpfString.replaceAll("\\.", "").replaceAll("-", "")
        Long cpf = Long.parseLong(cpfString)
        Candidato candidato = candidatoRegras.buscarCandidato(cpf)
        if (candidato != null) {
            println("Digite os novos dados do candidato (deixe em branco para manter o mesmo):")
            println("Nome (atual: ${candidato.nome}):")
            String nome = sc.nextLine()
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
        String cpfString = sc.nextLine()
        cpfString = cpfString.replaceAll("\\.", "").replaceAll("-", "")
        Long cpf = Long.parseLong(cpfString)
        if (candidatoRegras.excluirCandidato(cpf)) {
            println("Candidato excluído com sucesso!")
        } else {
            println("Candidato não encontrado.")
        }
    }
}
