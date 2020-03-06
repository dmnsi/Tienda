// Con esta clase hacemos la conexion a MySQL
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;




public class Conectar {
    
        private static final String DRIVER = "com.mysql.jdbc.Driver";
        private static final String URL = "jdbc:mysql://127.0.0.1:3306/tienda?characterEncoding=latin1";
        private static final String USER = "root";
        private static final String PASSWORD = "030390";
        private Connection CN;

    public Conectar() {
        CN = null;   
    }
     
    // Metodo para retornar la conexion
    public Connection getConnection (){
        try { 
            Class.forName(DRIVER);
            CN = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al conectar con la base de datos", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return CN;
    }
    
    // Metodo de desconexion
    public void close(){
        try {
            CN.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cerrar la conexion con la base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
