

abstract class Pessoa {
    String nome
    String email
    String estado
    long cep
    String descricao

    Pessoa(String nome, String email, String estado, long cep, String descricao) {
        this.nome = nome
        this.email = email
        this.estado = estado
        this.cep = cep
        this.descricao = descricao
    }

    String toString() {
        "Nome: ${this.nome}, Email: ${this.email}, Estado: ${this.estado}, CEP: ${this.cep}, Descrição: ${this.descricao}"
    }
}

class Candidatos extends Pessoa {
    long cpf
    int idade

    Candidatos(String nome, String email, long cpf, int idade, String estado, long cep, String descricao) {
        super(nome, email, estado, cep, descricao)
        this.cpf = cpf
        this.idade = idade
    }
}

class Empresa extends Pessoa {
    int cnpj

    Empresa(String nome, String emailCorp, long cnpj, String estado, long cep, String descricao) {
        super(nome, emailCorp, estado, cep, descricao)
        this.cnpj = cnpj
    }
}


def candidatos =[
        [nome: 'João', email: 'joao@live.com', cpf: 12375398463, idade: 30, estado: 'Pernambuco', cep: 58457, descricao: 'PYTHON'],
        [nome: 'Carlo', email: 'carlos@live.com', cpf: 45732198652, idade: 34, estado: 'Minas Gerais', cep: 55245, descricao: 'JAVA'],
        [nome: 'Maria', email: 'maria@live.com', cpf: 24578324899, idade: 40, estado: 'São Paulo', cep: 11845, descricao: 'Angular'],
        [nome: 'Abreu', email: 'abreu@live.com', cpf: 45687025487, idade: 20, estado: 'Bahia', cep: 84366, descricao: 'NODE.JS'],
        [nome: 'Rafaela', email: 'rafaela@live.com', cpf: 74027509833, idade: 35, estado: 'Pernambuco', cep: 50630, descricao: 'JAVASCRIPT']
]

def empresas =[
        [nome:'TAB TECH', emailCorp: 'adm@tabtach.com', cnpj: 12345678000190, estado: 'Pernambuco', cep: 50000, descricao: 'Descrição da vaga'],
        [nome:'ABC CORPORATE', emailCorp: 'rh@abccorp.com', cnpj: 98765432000110, estado: 'São Paulo', cep: 11845, descricao: 'Descrição da vaga'],
        [nome:'EIA SA', emailCorp: 'human@eiasa.org.com', cnpj: 11122333444455, estado: 'Minas Gerais', cep: 55245, descricao: 'Descrição da vaga'],
        [nome:'OSG GROUP', emailCorp: 'osg@osggroup.com', cnpj: 17475368999855, estado: 'Bahia', cep: 84366, descricao: 'Descrição da vaga'],
        [nome:'LDJ DIGITAL', emailCorp: 'recruiter@ldjdigi.com', cnpj: 7452389688822, estado: 'Pernambuco', cep: 50630, descricao: 'Descrição da vaga']
]


def cadastrarCandidatos(candidatos, scanner) {
    println "Insira o nome do Candidato:"
    String nome = scanner.nextLine()
    println "Insira o email do Candidato:"
    String email = scanner.nextLine()
    println "Insira o CPF do Candidato:"
    long cpf = scanner.nextLine().toLong()
    println "Insira a idade :"
    int idade = scanner.nextLine().toInteger()
    println "Insira o Estado do Candidato:"
    String estado = scanner.nextLine()
    println "Insira o CEP :"
    long cep = scanner.nextLine().toLong()
    println "Insira a Descrição do Candidato:"
    String descricao = scanner.nextLine()
    candidatos << new Candidatos(nome, email, cpf, idade, estado, cep, descricao )
}


def cadastrarEmpresas(empresas, scanner) {
    println "Insira o nome do Empresa:"
    String nome = scanner.nextLine()
    println "Insira o email Corporativo da Empresa:"
    String emailCorp = scanner.nextLine()
    println "Insira o CNPJ :"
    long cnpj = scanner.nextLine().toLong()
    println "Insira o Estado da Empresa:"
    String estado = scanner.nextLine()
    println "Insira o CEP :"
    long cep = scanner.nextLine().toLong()
    println "Insira a Descrição da vaga:"
    String descricao = scanner.nextLine()
    empresas << new Empresa(nome, emailCorp, cnpj, estado, cep, descricao )
}

def exibirCandidatos(candidatos) {
    candidatos.each { candidato ->
        println "Nome: ${candidato.nome}, email: ${candidato.email}, CPF: ${candidato.cpf}, Idade: ${candidato.idade}, Estado: ${candidato.estado}, CEP: ${candidato.cep}, Descrição: ${candidato.descricao}"
    }
}

def exibirEmpresas(empresas) {
    empresas.each { empresa ->
        println "Nome: ${empresa.nome}, EmailCorp: ${empresa.emailCorp}, CNPJ: ${empresa.cnpj}, Estado : ${empresa.estado}, CEP: ${empresa.cep}, Descrição:${empresa.descricao}"
    }
}

// Teste unitário
def testeCadastro(candidatos, scanner) {
    println "Iniciando os testes..."
    candidatos << new Candidatos('Ana','ana@live.com', 45678912322, 35, 'Pernambuco', 58457, 'PYTHON')
    exibirCandidatos(candidatos)
    println "Candidato cadastrado com sucesso!"
    }



def menu = """
            Escolha uma opção:
            [1]. Ver informações de Candidatos
            [2]. Cadastrar Candidatos
            [3]. Ver informações das Empresas
            [4]. Cadastrar Empresas
            [5]. Teste de Cadastro
            [6]. Sair
            
            """


def opcao = 0
Scanner scanner = new Scanner(System.in)
while (opcao != 6) {
    println menu
    opcao = scanner.nextLine().toInteger()
    switch (opcao) {
        case 1:
            println "Informações de Candidatos:"
            exibirCandidatos(candidatos)
            break
        case 2:
            println "Cadastrar Candidatos:"
            cadastrarCandidatos(candidatos, scanner)
            break
        case 3:
            println "Informações das Empresas:"
            exibirEmpresas(empresas)
            break
        case 4:
            println "Cadastrar Empresas:"
            cadastrarEmpresas(empresas, scanner)
            break
        case 5:
            println "Iniciando Teste:"
            testeCadastro(candidatos, scanner)
            break
        case 6:
            println "Saindo do sistema"
            break
        default:
            println "Opção inválida! Por favor, tente novamente."
            break
    }

}
