import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/linketinder_bd";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
};
