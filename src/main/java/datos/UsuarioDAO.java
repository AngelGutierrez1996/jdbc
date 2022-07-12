package datos;

import domain.Usuario;
import datos.ConexionUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT * FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario (usuario, "
            + "password) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ?"
            + "WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";

    public List<Usuario> seleccionar() {
        Connection conn = null;
        PreparedStatement consulta = null;
        ResultSet rs = null;
        List<Usuario> usuarios = null;

        try {
            conn = ConexionUsuario.getConexion();
            consulta = conn.prepareStatement(SQL_SELECT);
            rs = consulta.executeQuery();
            usuarios = new ArrayList<>();

            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String usuario = rs.getString("usuario");
                String password = rs.getString("password");

                Usuario usuarioSeleccion = new Usuario(idUsuario, usuario, password);

                usuarios.add(usuarioSeleccion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                consulta.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return usuarios;
    }

    public void insertar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement insert = null;

        try {
            conn = ConexionUsuario.getConexion();
            insert = conn.prepareStatement(SQL_INSERT);

            insert.setString(1, usuario.getUsuario());
            insert.setString(2, usuario.getPassword());

            insert.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                insert.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void actualizar(int idUsuario, Usuario usuario) {
        Connection conn = null;
        PreparedStatement insert = null;

        try {
            conn = ConexionUsuario.getConexion();
            insert = conn.prepareStatement(SQL_UPDATE);

            insert.setString(1, usuario.getUsuario());
            insert.setString(2, usuario.getPassword());
            insert.setInt(3, idUsuario);

            insert.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                insert.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }
    
    public void eliminar(int idUsuario){
        Connection conn = null;
        PreparedStatement insert = null;

        try {
            conn = ConexionUsuario.getConexion();
            insert = conn.prepareStatement(SQL_DELETE);

            insert.setInt(1, idUsuario);
            insert.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                insert.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }
}
