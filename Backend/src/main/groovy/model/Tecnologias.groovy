package model

class Tecnologias {
    List<String> nomes

    Tecnologias(String nomesComVirgula) {
        this.nomes = nomesComVirgula.split(',').collect { it.trim() }
    }
}
