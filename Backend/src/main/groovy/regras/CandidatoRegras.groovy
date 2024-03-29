package regras

import dao.CandidatoDAO
import model.Candidato

class CandidatoRegras {
    CandidatoDAO candidatoDAO

    CandidatoRegras(CandidatoDAO candidatoDAO) {
        this.candidatoDAO = candidatoDAO
    }

    void cadastrarCandidato(Candidato candidato) {
        try {
            if (candidato.nome && candidato.email && candidato.cpf && candidato.idade && candidato.estado && candidato.cep && candidato.descricao && candidato.senha && candidato.tecnologias) {
                candidatoDAO.insert(candidato)
            } else {
                throw new IllegalArgumentException("Dados incompletos para cadastrar o candidato.")
            }
        } catch (Exception e) {
            println("Erro ao cadastrar o candidato: ${e.message}")
        }
    }

    List<Candidato> listarCandidatos() {
        try {
            return candidatoDAO.all()
        } catch (Exception e) {
            println("Erro ao listar os candidatos: ${e.message}")
            return []
        }
    }

    void atualizarCandidato(Candidato candidato) {
        try {
            candidatoDAO.update(candidato)
        } catch (Exception e) {
            println("Erro ao atualizar o candidato: ${e.message}")
        }
    }

    boolean excluirCandidato(Long cpf) {
        try {
            candidatoDAO.delete(cpf)
            return true
        } catch (Exception e) {
            println("Erro ao excluir o candidato: ${e.message}")
            return false
        }
    }

    Candidato buscarCandidato(Long cpf) {
        try {
            return candidatoDAO.selectByCPF(cpf)
        } catch (Exception e) {
            println("Erro ao buscar o candidato: ${e.message}")
            return null
        }
    }
}
