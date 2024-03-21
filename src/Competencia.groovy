class Competencia {
    Integer id
    String nomeCompetencia

    Competencia(String nomeCompetencia){
        this.nomeCompetencia = nomeCompetencia
    }
    Competencia( Integer id, String nomeCompetencia){
        this(nomeCompetencia)
        this.id = id
    }
}
