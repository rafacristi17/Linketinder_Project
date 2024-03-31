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
            if (validarDados(candidato)) {
                candidatoDAO.insert(candidato)
            } else {
                throw new IllegalArgumentException("Dados incompletos para cadastrar o candidato.")
            }
        } catch (Exception e) {
            println("Erro ao cadastrar o candidato: ${e.message}")
        }
    }

    private boolean validarDados(Candidato candidato) {
        return candidato.nome && candidato.email && candidato.cpf && candidato.idade && candidato.estado && candidato.cep && candidato.descricao && candidato.senha && candidato.tecnologias
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

    boolean excluirCandidato(Long id) {
        try {
            candidatoDAO.delete(id)
            return true
        } catch (Exception e) {
            println("Erro ao excluir o candidato: ${e.message}")
            return false
        }
    }

    Candidato buscarCandidato(Long id) {
        try {
            return candidatoDAO.selectById(id)
        } catch (Exception e) {
            println("Erro ao buscar o candidato: ${e.message}")
            return null
        }
    }
}
