import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    private static Connection MyConexion = conexion.conectarMySqlCopaMundial();

    public static List<Persona> accesoCuenta(){
        List<Persona> lista = new ArrayList<>();
        try{
            String sql = "SELECT * FROM PERSONA;";
            Statement statement = MyConexion.createStatement(); //STATEMENT PERMITE EJERCUTAR SENTENCIAS DDL Y DML EN JAVA
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Persona persona = new Persona();
                persona.setId(rs.getInt("intID"));
                persona.setNombres(rs.getString("NOMBRE"));
                persona.setApellidos(rs.getString("APELLIDO"));
                lista.add(persona);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }


}
