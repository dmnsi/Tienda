package logica;

import conexion.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Producto {
    
    private final String SQL_INSERT = "INSERT INTO productos (pro_descripcion, pro_categoria, pro_cantidad, pro_costo, pro_precio, pro_estado) values(?,?,?,?,?,?)";
    private final String SQL_SELECT = "SELECT * FROM productos";
    private PreparedStatement PS;
    private DefaultTableModel DT;
    private ResultSet RS;
    private final Conectar CN;
    
    public Producto(){
        PS = null;
        CN = new Conectar();
    }
    
    // Metodo para los titulos de la tabla.
    private DefaultTableModel setTitulos(){
        DT = new DefaultTableModel();
        DT.addColumn("Id");
        DT.addColumn("Descripcion");
        DT.addColumn("Categoria");
        DT.addColumn("Cantidad");
        DT.addColumn("Costo");
        DT.addColumn("Precio");
        DT.addColumn("Estado");
        return DT;
    }
    
    // Metodo para listar datos.
    public DefaultTableModel getDatos(){
        try {
            setTitulos();
            PS = CN.getConnection().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[7];
            
            while (RS.next()){
                fila[0] = RS.getInt(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getInt(4);
                fila[4] = RS.getFloat(5);
                fila[5] = RS.getFloat(6);
                fila[6] = RS.getString(7);
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
    public int insertProducto(String des, String cat, int cant, float cost, float pre, String est){
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setString(1, des);
            PS.setString(2, cat);
            PS.setInt(3, cant);
            PS.setFloat(4, cost);
            PS.setFloat(5, pre);
            PS.setString(6,est);
            res = PS.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
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
    public DefaultTableModel getDato(int crt, String prm){
        String SQL;
        
        if (crt == 0){
            SQL = "SELECT * FROM productos WHERE pro_id = " + prm;
        } else {
            SQL = "SELECT * FROM productos WHERE pro_descripcion like '" + prm + "%'";
        }
      
        try {
            setTitulos();
            PS = CN.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();
            Object[] fila = new Object[7];
            
            while (RS.next()){
                fila[0] = RS.getInt(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getInt(4);
                fila[4] = RS.getFloat(5);
                fila[5] = RS.getFloat(6);
                fila[6] = RS.getString(7);
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

// Metodo para actualizar datos.
    public int updateProductos(String id, String des, String cat, int cant, float cost, float pre, String est){
        String SQL = "UPDATE productos SET pro_descripcion='" + des + "',pro_categoria = '" + cat +"',pro_cantidad = '"+ cant +"',"
                + "pro_costo='"+cost+"', pro_precio = '"+ pre + "', pro_estado = '"+ est +"' WHERE pro_id =" + id; 
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Registro Actualizado");
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
    public int deleteDatos(String id){
        String SQL = "DELETE from productos WHERE pro_id=" + id;
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
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