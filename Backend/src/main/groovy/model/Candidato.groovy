package model

import groovy.transform.ToString

import java.lang.reflect.Constructor

@ToString(includeNames=true)
class Candidato {
    Integer idCandidato
    String nome
    String email
    Long cpf
    Integer idade
    String estado
    Long cep
    String descricao
    String senha
    List<String> tecnologias

    Candidato(Integer idCandidato, String nome, String email, Long cpf, Integer idade, String estado, Long cep, String descricao, String senha, List<String> tecnologias) {
        this.idCandidato = idCandidato
        this.nome = nome
        this.email = email
        this.cpf = cpf
        this.idade = idade
        this.estado = estado
        this.cep = cep
        this.descricao = descricao
        this.senha = senha
        this.tecnologias = tecnologias
    }
    Candidato(){

    }

    void setTecnologias(Tecnologias tecnologias) {
        this.tecnologias = tecnologias.nomes
    }

}
