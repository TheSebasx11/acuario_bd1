package acuario_bd1;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {

    private Connection Con;
    private final String url = "jdbc:mysql://localhost:3306/acuario";
    private final String user = "root";

    public conexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(url, user, "");
            System.out.println("Conectado");

        } catch (Exception e) {
            System.out.println("No se ha establecido conexión");

        }
    }

    public Connection getConexion() {
        return Con;
    }

}
