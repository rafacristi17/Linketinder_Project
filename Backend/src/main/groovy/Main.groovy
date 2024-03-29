import dao.CandidatoDAO
import dao.BancoDeDados
import view.Menu

class Main {
    static void main(String[] args) {
        def sql = BancoDeDados.getConnection()
        def candidatoDAO = new CandidatoDAO(sql)
        def menu = new Menu(candidatoDAO)

        menu.executar()

        sql.close()
    }
}
