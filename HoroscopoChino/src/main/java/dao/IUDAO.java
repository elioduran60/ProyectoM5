package dao;

import java.util.List;
import java.util.Optional;

import modelo.Usuario;
/*
 * Interface para la Clase Usuario.DAO
 */
public interface IUDAO<I> {
    List<I> mostrarUsuarios() throws ClassNotFoundException;

    Boolean agregarUsuario(Usuario u) throws ClassNotFoundException;

    Boolean eliminarUsuario(Long id) throws ClassNotFoundException;

    Boolean actualizarUsuario(Usuario u) throws ClassNotFoundException;

    Optional<I> buscarUsuarioPorId(Long id) throws ClassNotFoundException;

    
}