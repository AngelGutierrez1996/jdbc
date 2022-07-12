
package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

public class TestManejoUsuarios {
    
    public static void main(String[] args) {
        UsuarioDAO usuarios = new UsuarioDAO();
        
//        Usuario nuevoUsuario = new Usuario("Abelardo", "123");
//        usuarios.insertar(nuevoUsuario);
        
        Usuario updateUsuario = new Usuario("Edith", "123");
        int idUsuario = 3; // usuario que se va a modificar
        usuarios.actualizar(idUsuario, updateUsuario);
        
        idUsuario = 4; // id de usuario que se va a eliminar
        usuarios.eliminar(idUsuario);
        
        List<Usuario> listaUsuarios = usuarios.seleccionar();
        listaUsuarios.forEach(usuario -> {
            System.out.println("usuario = " +usuario);
        });
    }
}
