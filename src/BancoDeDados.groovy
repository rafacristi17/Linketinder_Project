import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class BancoDeDados {
    static final String URL = "jdbc:postgresql://localhost:5432/linketinder_bd"
    static final String USER = "postgres"
    static final String PASSWORD = 123456

    static Connection getConnection() {
        Connection conexao = null
        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD)
            println("Conexão estabelecida com sucesso!")
        } catch (SQLException e) {
            println("Erro ao conectar ao banco de dados: " + e.getMessage())
        }
        return conexao
    }

    static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close()
                println("Conexão fechada com sucesso!")
            } catch (SQLException e) {
                println("Erro ao fechar a conexão: " + e.getMessage())
            }
        }
    }
}