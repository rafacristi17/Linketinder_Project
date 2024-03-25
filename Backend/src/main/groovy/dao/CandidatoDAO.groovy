package dao

import model.Candidato

import java.sql.*

class CandidatoDAO {
    private Connection connection

    CandidatoDAO() {
        String url = "jdbc:postgresql://localhost:5432/linketinder_bd"
        String user = "postgres"
        String password = "123456"

        try {
            connection = DriverManager.getConnection(url, user, password)
        } catch (SQLException e) {
            println(e.getMessage())
        }
    }

    void close() {
        connection.close()
    }

    void insert(Candidato candidato) {
        String sql = "INSERT INTO candidato (idCandidato, nome, email, cpf, idade, estado, cep, descricao, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"

        PreparedStatement pstmt = connection.prepareStatement(sql)
        pstmt.setInt(1, candidato.id)
        pstmt.setString(2, candidato.nome)
        pstmt.setString(3, candidato.email)
        pstmt.setLong(4, candidato.cpf)
        pstmt.setInt(5, candidato.idade)
        pstmt.setString(6, candidato.estado)
        pstmt.setLong(7, candidato.cep)
        pstmt.setString(8, candidato.descricao)
        pstmt.setString(9, candidato.senha)

        pstmt.executeUpdate()
    }

    Candidato select(int id) {
        String sql = "SELECT * FROM candidato WHERE idCandidato = ?"

        PreparedStatement pstmt = connection.prepareStatement(sql)
        pstmt.setInt(1, id)

        ResultSet rs = pstmt.executeQuery()

        if (rs.next()) {
            return new Candidato(
                    idCandidato: rs.getInt("idCandidato"),
                    nome: rs.getString("nome"),
                    email: rs.getString("email"),
                    cpf: rs.getLong("cpf"),
                    idade: rs.getInt("idade"),
                    estado: rs.getString("estado"),
                    cep: rs.getLong("cep"),
                    descricao: rs.getString("descricao"),
                    senha: rs.getString("senha")
            )
        } else {
            return null
        }
    }

    void update(Candidato candidato) {
        String sql = "UPDATE candidato SET nome = ?, email = ?, cpf = ?, idade = ?, estado = ?, cep = ?, descricao = ?, senha = ? WHERE idCandidato = ?"

        PreparedStatement pstmt = connection.prepareStatement(sql)
        pstmt.setString(1, candidato.nome)
        pstmt.setString(2, candidato.email)
        pstmt.setLong(3, candidato.cpf)
        pstmt.setInt(4, candidato.idade)
        pstmt.setString(5, candidato.estado)
        pstmt.setLong(6, candidato.cep)
        pstmt.setString(7, candidato.descricao)
        pstmt.setString(8, candidato.senha)
        pstmt.setInt(9, candidato.id)

        pstmt.executeUpdate()
    }

    void delete(int id) {
        String sql = "DELETE FROM candidato WHERE idCandidato = ?"

        PreparedStatement pstmt = connection.prepareStatement(sql)
        pstmt.setInt(1, id)

        pstmt.executeUpdate()
    }
}
