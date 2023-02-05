public class Main {
    public static void main(String[] args) {

        //conexion.conectarMySqlCopaMundial();
        DAO.accesoCuenta().forEach(System.out::println);

    }
}