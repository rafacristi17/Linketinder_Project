import dao.CandidatoDAO
import model.Candidato

class Main {
    static void main(String[] args) {
        CandidatoDAO dao = new CandidatoDAO()
        Candidato candidato = new Candidato(idCandidato: 1, nome: "Nome", email: "Email", cpf: 12345678901, idade: 30, estado: "Estado", cep: 12345678, descricaoProfissional: "Descricao", senha: "Senha")
        dao.insert(candidato)

        dao.close()
    }
}
