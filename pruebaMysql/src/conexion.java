import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {

    private static Connection conn = null;
    private static String dataBase = "";
    private static String user = "";
    private static String password = "";
    private static String host = "";
    private static String port = "";
    private static String url = "";
    private static String driver = "";

    //CONNECTION MYSQL
    public static Connection conectarMySqlCopaMundial(){
        dataBase = "prueba";
        user = "root";
        password = "miryam2003";
        host = "localhost";
        port = "3306";
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://"+ host +":"+ port +"/"+ dataBase +"?useSSL=false";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null ) System.out.println("Conexion con MySQL establecida");
        }catch (Exception e){e.getMessage();}
        return conn;
    }



}
