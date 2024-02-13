def candidatos =[
        [nome: 'João', email: 'joao@live.com', cpf: 12375398463, idade: 30, estado: 'Pernambuco', cep: 58457, descricao: 'PYTHON'],
        [nome: 'Carlo', email: 'carlos@live.com', cpf: 45732198652, idade: 34, estado: 'Minas Gerais', cep: 55245, descricao: 'JAVA'],
        [nome: 'Maria', email: 'maria@live.com', cpf: 24578324899, idade: 40, estado: 'São Paulo', cep: 11845, descricao: 'Angular'],
        [nome: 'Abreu', email: 'abreu@live.com', cpf: 45687025487, idade: 20, estado: 'Bahia', cep: 84366, descricao: 'NODE.JS'],
        [nome: 'Rafaela', email: 'rafaela@live.com', cpf: 74027509833, idade: 35, estado: 'Pernambuco', cep: 50630, descricao: 'JAVASCRIPT']
    ]

def empresas =[
        [nome:'TAB TECH', emailCorp: 'adm@tabtach.com', cnpj: 12345678000190, estado: 'Pernambuco', cep: 50000, descricao: 'Descrição da pessoa'],
        [nome:'ABC CORPORATE', emailCorp: 'rh@abccorp.com', cnpj: 98765432000110, estado: 'São Paulo', cep: 11845, descricao: 'Descrição da pessoa'],
        [nome:'EIA SA', emailCorp: 'human@eiasa.org.com', cnpj: 11122333444455, estado: 'Minas Gerais', cep: 55245, descricao: 'Descrição da pessoa'],
        [nome:'OSG GROUP', emailCorp: 'osg@osggroup.com', cnpj: 17475368999855, estado: 'Bahia', cep: 84366, descricao: 'Descrição da pessoa'],
        [nome:'LDJ DIGITAL', emailCorp: 'recruiter@ldjdigi.com', cnpj: 7452389688822, estado: 'Pernambuco', cep: 50630, descricao: 'Descrição da pessoa']
]


def exibirCandidatos(candidatos) {
    candidatos.each { candidatoss ->
        println "Nome: ${candidatos.nome}, email: ${candidatos.email}, CPF: ${candidatos.cpf}, Idade: ${candidatos.idade}, Estado: ${candidatos.estado}, CEP: ${candidatos.cep}, Descrição: ${candidatos.descricao}"
    }
}

def exibirEmpresas(empresas) {
    empresas.each { empresass ->
        println "Nome: ${empresas.nome}, EmailCorp: ${empresas.emailCorp}, CNPJ: ${empresas.cnpj}, Estado : ${empresas.estado}, CEP: ${empresas.cep}, Descrição:${empresas.descricao}"
    }
}

def menu = """
            Escolha uma opção:
            1. Ver informações de Candidatos
            2. Ver informações das Empresas
            3. Sair
            """


        def opcao = 0
        Scanner scanner = new Scanner(System.in)
        while (opcao != 3) {
            println menu
        opcao = scanner.nextLine().toInteger()
        switch (opcao) {
            case 1:
                println "Informações de Candidatos:"
                exibirCandidatos(candidatos)
                break
            case 2:
                println "Informações de Pessoas Jurídicas:"
                exibirEmpresas(empresas)
                break;
            case 3:
                println "Saindo do sistema"
                break
            default:
                println "Opção inválida! Por favor, tente novamente."
                break
        }
}

