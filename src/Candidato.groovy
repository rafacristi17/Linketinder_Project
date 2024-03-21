
class Candidato {
    Integer id
    String nome
    String email
    long cpf
    Integer idade
    String estado
    long cep
    String descricaoProfissional

    Candidato(String nome, String email, long cpf, Integer idade, String estado, long cep, String descricaoProfissional) {
        this.nome = nome
        this.email = email
        this.cpf = cpf
        this.idade = idade
        this.estado = estado
        this.cep = cep
        this.descricaoProfissional = descricaoProfissional
    }

    Candidato(Integer id, String nome, String email, long cpf, Integer idade, String estado, long cep, String descricaoProfissional) {
        this(nome, email, cpf, idade, estado, cep, descricaoProfissional)
        this.id = id
    }

    String toString() {
        "id=$id, nome=$nome, email=$email, cpf=$cpf, idade=$idade, estado=$estado, cep=$cep, descricaoProfissional=$descricaoProfissional"
    }
}
