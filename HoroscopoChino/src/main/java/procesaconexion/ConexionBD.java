package procesaconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// Genera la conexion a la DB: "db_horostopo"
public class ConexionBD {
    private static Connection conn;
    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})

    private static final String URL = "jdbc:mysql://localhost:3306/db_horoscopo?serverTimezone=America/Santiago";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "1357";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection getInstance() throws SQLException,ClassNotFoundException{
        if (conn == null) {
            try {
                System.out.println("CONEXION NULL");
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(getUrl(), getUsuario(), getPASSWORD());
                System.out.println("CREACION DE CONEXION CON GetConnection"+conn);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("ERROR EN LA CONEXION");
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        return conn;
    }

    private static String getUrl() {
        return URL;
    }

    private static String getUsuario() {
        return USUARIO;
    }

    private static String getPASSWORD() {
        return PASSWORD;
    }
}