
package test;

import java.sql.*;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        //useSSL = arrancar en zona segura ... useTimezone = zona horaria
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone"
                + "=true&serverTimezone=UTC&allowPublicKeyRetrieval=true"; // cadena de conexión
        try {
            // este paso se omite en nuevas versiones ... pero se puede utilizar en aplicaciones web
            //Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection conexion = DriverManager.getConnection(url,"root", "admin");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT idpersona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.print("Id Persona: "+resultado.getInt("idpersona"));
                System.out.print(" Nombre: "+resultado.getString("nombre"));
                System.out.print(" Apellido: "+resultado.getString("apellido"));
                System.out.print(" email: "+resultado.getString("email"));
                System.out.print(" telefono: "+resultado.getString("telefono"));
                System.out.println();
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
}
