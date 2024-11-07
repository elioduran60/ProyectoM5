package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Horoscopo;
import procesaconexion.ConexionBD;

public class ObtenerHoroscopoDAO implements IHDAO {

    // Establecer conexión a la base de datos: "db_horoscopo" a través de ConexionBD
    private Connection conectar() throws SQLException, ClassNotFoundException {
        return ConexionBD.getInstance();
    }

    // Obtener el Horoscopo Chino por la fecha que el Usuario introduzca:
    @Override
    public Horoscopo horoscopoPorFecha(Date fecha_nacimiento) {
        Horoscopo horoscopo = null;
        //System.out.println(fecha_nacimiento);
        
        //Consulta para obtener el Horoscopo Chino por la fecha que el Usuario introduzca:
        String sql = "SELECT * FROM horoscopo WHERE fecha_fin >= '" + fecha_nacimiento + "' AND fecha_inicio <= '" + fecha_nacimiento + "';";
        try {
            java.sql.Statement st = conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                horoscopo = new Horoscopo(
                        rs.getLong("id_horoscopo"),
                        rs.getString("animal"),
                        rs.getDate("fecha_inicio"),
                        rs.getDate("fecha_fin"));
            }
        } catch (ClassCastException | SQLException | ClassNotFoundException e) {
            System.err.println(" Error al obtener el Horoscopo Chino");
            System.err.println(" Error: " + e.getMessage());
        }
        System.out.println(horoscopo.getAnimal());
        return horoscopo;
    }
}