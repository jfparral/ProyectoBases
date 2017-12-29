
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class Conectar {
    private static Connection com;
    public static final String driver= "com.mysql.jdbc.Driver";
    public static final String user="root";
    public static final String password="1214";
    public static final String url="jdbc:mysql://localhost:3306/tienda";

    public Conectar() {
        com=null;
        try {
            Class.forName(driver);
            com=DriverManager.getConnection(url,user,password);
            if(com!=null)
                System.out.println("Conexion establecida");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar: "+e);
        }
    }
    //con este metodo nos retorna la conexion a la case
    public Connection getConnection()
    {
        return com;
    }
    
    public void Desconectar()
    {
        com=null;
        if(com==null)
            System.out.println("Conexion terminada");
    }
}
