package dao

import model.Candidato
import model.Tecnologias
import groovy.sql.Sql

class CandidatoDAO {
    private Sql sql

    CandidatoDAO(Sql sql) {
        this.sql = sql
    }

    void insert(Candidato candidato) {
        sql.execute("""
        INSERT INTO candidato (nome, email, cpf, idade, estado, cep, descricao, senha, tecnologias) 
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
    """, [
                candidato.nome, candidato.email, candidato.cpf, candidato.idade,
                candidato.estado, candidato.cep, candidato.descricao,
                candidato.senha, candidato.tecnologias.join(',')
        ])
    }

    List<Candidato> all() {
        def candidatos = []
        sql.eachRow("SELECT * FROM candidato") { row ->
            candidatos << new Candidato(
                    idCandidato: row.idCandidato,
                    nome: row.nome,
                    email: row.email,
                    cpf: formatCpf(row.cpf).toLong(),
                    idade: row.idade as Integer,
                    estado: row.estado,
                    cep: row.cep,
                    descricao: row.descricao,
                    senha: row.senha,
                    tecnologias: row.tecnologias ? row.tecnologias.split(',').collect { Tecnologias.valueOf(it) } : []
            )
        }
        return candidatos
    }

    void update(Candidato candidato) {
        sql.execute("""
            UPDATE candidato 
            SET nome = ?, email = ?, cpf = ?, idade = ?, estado = ?, cep = ?, descricao = ?, senha = ?, tecnologias = ? 
            WHERE idCandidato = ?
        """, [
                candidato.nome, candidato.email, candidato.cpf, candidato.idade, candidato.estado,
                candidato.cep, candidato.descricao, candidato.senha,
                candidato.tecnologias.join(','), candidato.idCandidato
        ])
    }

    void delete(int id) {
        sql.execute("DELETE FROM candidato WHERE idCandidato = ?", [id])
    }
}
