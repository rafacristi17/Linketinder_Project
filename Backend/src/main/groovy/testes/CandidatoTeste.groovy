package testes

import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertTrue

import dao.BancoDeDados
import dao.CandidatoDAO
import model.Candidato
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test

class CandidatoDAOTest {

    static CandidatoDAO candidatoDAO

    @BeforeClass
    static void setUp() {
        BancoDeDados bancoDeDados = new BancoDeDados()
        candidatoDAO = new CandidatoDAO(bancoDeDados.getConnection())
    }

    @AfterClass
    static void tearDown() {
        candidatoDAO.close()
    }

    @Test
    void testInsert() {
        Candidato candidato = new Candidato(
                nome: "Fulano",
                email: "fulano@example.com",
                cpf: 123456789L,
                idade: 30,
                estado: "SP",
                cep: 12345678L,
                descricao: "Descrição do candidato",
                senha: "senha123",
                tecnologias: ["Java", "Python"]
        )

        candidatoDAO.insert(candidato)

        assertNotNull(candidato.idCandidato)
    }

    @Test
    void testAll() {
        List<Candidato> candidatos = candidatoDAO.all()

        assertTrue(candidatos.size() > 0)

        candidatos.each { candidato ->
            assertNotNull(candidato.idCandidato)
            assertNotNull(candidato.nome)
            assertNotNull(candidato.email)
            assertNotNull(candidato.cpf)
            assertNotNull(candidato.idade)
            assertNotNull(candidato.estado)
            assertNotNull(candidato.cep)
            assertNotNull(candidato.descricao)
            assertNotNull(candidato.senha)
            assertNotNull(candidato.tecnologias)
        }
    }
}
