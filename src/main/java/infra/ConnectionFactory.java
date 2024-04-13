package infra;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/dberp?useTimezone=true&serverTimezone=UTC";
    private static String user = "root";
    private static String passworld = "Marcos@123";

    // conexao

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, passworld);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


}
