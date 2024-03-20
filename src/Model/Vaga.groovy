package Model

class Vaga {
    Integer id
    String tituloVaga
    String descrcaoVaga
    String tecnologias

    Vaga(String tituloVaga, String descrcaoVaga, String tecnologias) {
        this.tituloVaga = tituloVaga;
        this.descrcaoVaga = descrcaoVaga;
        this.tecnologias = tecnologias
    }

    Vaga(Integer id, String tituloVaga, String descricaoVaga, String tecnologias) {
        this(tituloVaga, descricaoVaga, tecnologias)
        this.id = id
    }

}