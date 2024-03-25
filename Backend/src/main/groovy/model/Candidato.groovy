package model

import groovy.transform.ToString

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
}
