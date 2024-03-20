package Model

class Empresa {
    Integer id
    String nomeEmpresa
    String emailEmpresa
    long cnpj
    String estado
    long cep
    String descricaoDaEmpresa

    Empresa(String nomeEmpresa, String emailEmpresa, long cnpj, String estado, long cep, String descricaoDaEmpresa){
        this.nomeEmpresa =nomeEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.cnpj = cnpj;
        this.estado = estado;
        this.cep = cep;
        this.descricaoDaEmpresa = descricaoDaEmpresa
    }
    Empresa(Integer id, String nomeEmpresa, String emailEmpresa, long cnpj, String estado, long cep, String descricaoDaEmpresa) {
        this(nomeEmpresa, emailEmpresa, cnpj, estado, cep, descricaoDaEmpresa)
        this.id = id
    }
}
