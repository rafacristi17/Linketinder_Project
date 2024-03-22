import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException

class Candidato {
    Integer id
    String nome
    String email
    long cpf
    Integer idade
    String estado
    long cep
    String descricaoProfissional

    Candidato(String nome, String email, long cpf, Integer idade, String estado, long cep, String descricaoProfissional) {
        this.nome = nome
        this.email = email
        this.cpf = cpf
        this.idade = idade
        this.estado = estado
        this.cep = cep
        this.descricaoProfissional = descricaoProfissional
    }

    Candidato(Integer id, String nome, String email, long cpf, Integer idade, String estado, long cep, String descricaoProfissional) {
        this(nome, email, cpf, idade, estado, cep, descricaoProfissional)
        this.id = id
    }

    String toString() {
        "id=$id, nome=$nome, email=$email, cpf=$cpf, idade=$idade, estado=$estado, cep=$cep, descricaoProfissional=$descricaoProfissional"
    }
    void salvar(BancoDeDados bd) {
        Connection conexao = bd.getConnection()
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO candidato (nome, email, cpf, idade, estado, cep, descricaoProfissional) VALUES (?, ?, ?, ?, ?, ?, ?)")
            stmt.setString(1, this.nome)
            stmt.setString(2, this.email)
            stmt.setLong(3, this.cpf)
            stmt.setInt(4, this.idade)
            stmt.setString(5, this.estado)
            stmt.setLong(6, this.cep)
            stmt.setString(7, this.descricaoProfissional)
            stmt.executeUpdate()
            System.out.println("Candidato salvo com sucesso!")
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o candidato: " + e.getMessage())
        } finally {
            bd.fecharConexao(conexao)
        }
    }
    void atualizar(BancoDeDados bd) {
        Connection conexao = bd.getConnection()
        try {
            PreparedStatement stmt = conexao.prepareStatement("UPDATE candidato SET nome=?, email=?, cpf=?, idade=?, estado=?, cep=?, descricaoProfissional=? WHERE id=?")
            stmt.setString(1, this.nome)
            stmt.setString(2, this.email)
            stmt.setLong(3, this.cpf)
            stmt.setInt(4, this.idade)
            stmt.setString(5, this.estado)
            stmt.setLong(6, this.cep)
            stmt.setString(7, this.descricaoProfissional)
            stmt.setInt(8, this.id)
            stmt.executeUpdate()
            System.out.println("Candidato atualizado com sucesso!")
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o candidato: " + e.getMessage())
        } finally {
            bd.fecharConexao(conexao)
        }
    }
    void deletar(BancoDeDados bd) {
        Connection conexao = bd.getConnection()
        try {
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM candidato WHERE id=?")
            stmt.setInt(1, this.id)
            stmt.executeUpdate()
            System.out.println("Candidato deletado com sucesso!")
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o candidato: " + e.getMessage())
        } finally {
            bd.fecharConexao(conexao)
        }
    }
    static Candidato buscarPorId(BancoDeDados bd, Integer id) {
        Connection conexao = bd.getConnection()
        Candidato candidato = null
        try {
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM candidato WHERE id=?")
            stmt.setInt(1, id)
            ResultSet rs = stmt.executeQuery()
            if (rs.next()) {
                candidato = new Candidato(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getLong("cpf"), rs.getInt("idade"), rs.getString("estado"), rs.getLong("cep"), rs.getString("descricaoProfissional"))
                System.out.println("Candidato encontrado: " + candidato)
            } else {
                System.out.println("Candidato não encontrado.")
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o candidato: " + e.getMessage())
        } finally {
            bd.fecharConexao(conexao)
        }
        return candidato
    }

}
