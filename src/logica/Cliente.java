package logica;

import conexion.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Cliente {
    private final String SQL_INSERT = "INSERT INTO cliente (cli_nombre, cli_cuil, cli_razonsocial, cli_localidad, cli_calle, cli_altura, cli_telefono) values(?,?,?,?,?,?,?)";
    private final String SQL_SELECT = "SELECT * FROM cliente";
    private PreparedStatement PS;
    private DefaultTableModel DT;
    private ResultSet RS;
    private final Conectar CN;
    
    public Cliente(){
        PS = null;
        CN = new Conectar();
    }
    
    // Metodo para los titulos de la tabla.
    private DefaultTableModel setTitulos(){
        DT = new DefaultTableModel();
        DT.addColumn("Id");
        DT.addColumn("Nombre");
        DT.addColumn("CUIL/CUIT");
        DT.addColumn("Razón Social");
        DT.addColumn("Localidad");
        DT.addColumn("Calle");
        DT.addColumn("Altura");
        DT.addColumn("Telefóno");
        return DT;
    }
    
    // Metodo para listar datos.
    public DefaultTableModel getDatos(){
        try {
            setTitulos();
            PS = CN.getConnection().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[8];
            
            while (RS.next()){
                fila[0] = RS.getInt(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getString(6);
                fila[6] = RS.getInt(7);
                fila[7] = RS.getInt(8);
                DT.addRow(fila);
            }
             
        } catch (SQLException e){
            System.out.println("Error al listar los datos: " + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.close();
        } 
        return DT;
    }
    
    // Metodo para Guardar Datos.
    public int insertCliente(String nom, String cuil, String rsoc, String loc, String call, int alt, int tel){
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setString(1, nom);
            PS.setString(2, cuil);
            PS.setString(3, rsoc);
            PS.setString(4, loc);
            PS.setString(5, call);
            PS.setInt(6,alt);
            PS.setInt(7,tel);
            res = PS.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Cliente Guardado");
            }
        } catch (SQLException e){
            System.err.println("Error al guardar: " + e.getMessage());     
        } finally {
            PS = null;
            CN.close();
        }
        return res;
    }
    
    // Metodo para buscar.
    public DefaultTableModel getCliente(int crt, String prm){
        String SQL;
        
        if (crt == 0){
            SQL = "SELECT * FROM productos WHERE cli_id = " + prm;
        } else {
            SQL = "SELECT * FROM productos WHERE cli_nombre like '" + prm + "%'";
        }
      
        try {
            setTitulos();
            PS = CN.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();
            Object[] fila = new Object[8];
            
            while (RS.next()){
                fila[0] = RS.getInt(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getString(6);
                fila[6] = RS.getInt(7);
                fila[7] = RS.getInt(8);
                DT.addRow(fila);
            }
             
        } catch (SQLException e){
            System.out.println("Error al listar cliente7s: " + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.close();
        } 
        return DT;
    }

// Metodo para actualizar datos.
    public int updateCliente(String id, String nom, String cuil, String rsco, String loc, String call, int alt, int tel){
        String SQL = "UPDATE cliente SET cli_nombre='" + nom + "',cli_cuil = '" + cuil +"',cli_razonsocial = '"+ rsco +"',"
                + "cli_localidad='" + loc + "', cli_calle = '"+ call + "', cli_altura = '"+ alt +"cli_telefono ='" + tel + "' WHERE pro_id =" + id; 
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Cliente Actualizado");
            }
        } catch (SQLException e){
            System.err.println("Error al actualizar: " + e.getMessage());     
        } finally {
            PS = null;
            CN.close();
        }
        return res;
    }

// Metodo para eliminar datos.
    public int deleteCliente(String id){
        String SQL = "DELETE from cliente WHERE cli_id=" + id;
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Cliente Eliminado");
            }
        } catch (SQLException e){
            System.err.println("Error al eliminar: " + e.getMessage());     
        } finally {
            PS = null;
            CN.close();
        }
        return res;
    }
    
}
