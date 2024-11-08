package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import modelo.Usuario;
import procesaconexion.ConexionBD;

/*
 * Clase de acceso y manejo de Datos desde la base de datos: "db_hoscopo" 
 */
@SuppressWarnings("rawtypes")
public class UsuarioDAO implements IUDAO {

    // Establecer conexión a la base de datos: "db_horoscopo" a través de ConexionBD
    private static Connection conectar() throws SQLException, ClassNotFoundException {
        return ConexionBD.getInstance();
    }

    // Mostrar Usuarios existentes en la base de datos "db_horoscopo":
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public List<Usuario> mostrarUsuarios() throws ClassNotFoundException {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuarioIndividual;
        String sql = "SELECT * FROM usuarios";
        try {
            Connection conn = conectar();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String username = rs.getString("username");
                Date fechaNacimiento = rs.getDate("fecha_nacimiento");
                String password = rs.getString("password");
                String animal = rs.getString("animal");
                usuarioIndividual = new Usuario(nombre, email, username, fechaNacimiento, password, animal);
                usuarioIndividual.setId(rs.getLong("id"));
                usuarios.add(usuarioIndividual);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    // Agregar usuario a la base de datos "db_horoscopo":
    @Override
    public Boolean agregarUsuario(Usuario u) throws ClassNotFoundException {
        String sql = "INSERT INTO usuarios (nombre, email, username, fecha_nacimiento, password, animal) VALUES (?,?,?,?,?,?)";

        try {
            Connection conn = conectar();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, u.getNombre());
            st.setString(2, u.getEmail());
            st.setString(3, u.getUsername());
            st.setDate(4, (java.sql.Date) u.getFechaNacimiento());
            st.setString(5, u.getPassword());
            st.setString(6, u.getAnimal());
            System.out.println(st.toString());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar el usuario");
            System.err.println("Error: " + e.getMessage());
        }
        return false;
    }

    // Eliminar Uusario por su Id:
    @SuppressWarnings({"override", "CallToPrintStackTrace"})
    public Boolean eliminarUsuario(Long id) throws ClassNotFoundException {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try {
            Connection conn = conectar();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setLong(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Actualizar usuario en base de Datos "db_horoscopo":
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public Boolean actualizarUsuario(Usuario u) throws ClassNotFoundException {
        String sql = "UPDATE usuarios SET nombre = ?, email = ?, username = ?, fecha_nacimiento = ?, password = ?, animal = ? WHERE id = ?";
        System.out.println("Nombre: " + u.getNombre());
        System.out.println("Email: " + u.getEmail());
        System.out.println("Username: " + u.getUsername());
        System.out.println("Fecha de Nacimiento: " + u.getFechaNacimiento());
        System.out.println("Password: " + u.getPassword());
        System.out.println("Animal: " + u.getAnimal());
        System.out.println("Id: " + u.getId());
        
        try {
            Connection conn = conectar();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, u.getNombre());
            st.setString(2, u.getEmail());
            st.setString(3, u.getUsername());
            st.setDate(4, (java.sql.Date) u.getFechaNacimiento());
            st.setString(5, u.getPassword());
            st.setString(6, u.getAnimal());
            st.setLong(7, u.getId());
            st.executeUpdate();
            System.out.println("Se actualizo el usuario");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario");
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    // Buscar Usuario por su id:
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public Optional<Usuario> buscarUsuarioPorId(Long id) throws ClassNotFoundException {
        Optional<Usuario> usuario = Optional.empty();
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try {
            Connection conn = conectar();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String username = rs.getString("username");
                Date fechaNacimiento = rs.getDate("fecha_nacimiento");
                String password = rs.getString("password");
                String animal = rs.getString("animal");
                usuario = Optional.of(new Usuario(nombre, email, username, fechaNacimiento, password, animal));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public Usuario login(String username, String password) throws ClassNotFoundException {
        String sql = "SELECT * FROM usuarios WHERE username = ?";
        try {
            Connection conn = conectar();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String username2 = rs.getString("username");
                Date fechaNacimiento = rs.getDate("fecha_nacimiento");
                String password2 = rs.getString("password");
                String animal = rs.getString("animal");
                System.out.println("Usuario encontrado: " + nombre);
                System.out.println("Contraseña encontrada: " + password2);
                return new Usuario(nombre, email, username2, fechaNacimiento, password2, animal);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar un usuario");
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println("Return null result");

        return null;
    }
}
