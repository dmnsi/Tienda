
package formularios;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import logica.Cliente;

public class FrmCliente extends javax.swing.JFrame {

    private final Cliente CC;
    int num = 0;


    public FrmCliente() {
        initComponents();
        CC = new Cliente();
        listar();
        this.setLocationRelativeTo(null);

    }
    
    // Metodo para listar los clientes
    private void listar (){
        tbDatosClientes.setModel(CC.getDatos());
    }
    
    private void limpiar (){
        txtIDCliente.setText("");
        txtNombreCliente.setText("");
        txtCalle.setText("");
        txtLocalidad.setText("");
        txtCuil.setText("");
        txtTelefono.setText("");
        txtAltura.setText("");
        cbRazonSocial.setSelectedIndex(0);
        txtNombreCliente.requestFocus();
    }
    
    private void guardar(){ 
        String id = txtIDCliente.getText();
        String nom = txtNombreCliente.getText();
        String cuil = txtCuil.getText();
        String rsoc = cbRazonSocial.getSelectedItem().toString();
        String loc = txtLocalidad.getText();
        String cal = txtCalle.getText();
        int alt = Integer.parseInt(txtAltura.getText());        
        int tel = Integer.parseInt(txtTelefono.getText());
             
        if (num == 0){
            int respuesta = CC.insertCliente(nom, cuil, rsoc, loc, cal, alt, tel);
            if (respuesta > 0 ){
                listar();
                limpiar();
        }
        } else {
            int respuesta = CC.updateCliente(id, nom, cuil, rsoc, loc, cal, alt, tel);
            if (respuesta > 0 ){
                listar();
                limpiar();
                num = 0;
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblIdCliente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIDCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        cbRazonSocial = new javax.swing.JComboBox<>();
        txtTelefono = new javax.swing.JTextField();
        lblCuil = new javax.swing.JLabel();
        lblLocalidad = new javax.swing.JLabel();
        lblCalle = new javax.swing.JLabel();
        txtCuil = new javax.swing.JTextField();
        txtLocalidad = new javax.swing.JTextField();
        txtCalle = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtAltura = new javax.swing.JTextField();
        btnNuevoCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDatosClientes = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnGuardarCliente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblClientes = new javax.swing.JLabel();
        cbBuscarCliente = new javax.swing.JComboBox<>();
        txtBuscarCliente = new javax.swing.JTextField();
        btnEliminarCliente = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(241, 248, 248));

        lblIdCliente.setText("Id");

        jLabel3.setText("Nombre");

        jLabel4.setText("Razón Social");

        jLabel5.setText("Teléfono");

        txtIDCliente.setEditable(false);

        cbRazonSocial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Consumidor Final", "Responsable Inscripto", "Monotributista", " ", " " }));

        lblCuil.setText("CUIL/CUIT");

        lblLocalidad.setText("Localidad");

        lblCalle.setText("Calle");

        jLabel1.setText("Altura");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(lblIdCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCliente)
                    .addComponent(cbRazonSocial, 0, 180, Short.MAX_VALUE)
                    .addComponent(txtTelefono))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCuil)
                    .addComponent(lblCalle)
                    .addComponent(lblLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCuil)
                            .addComponent(txtLocalidad, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAltura)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdCliente)
                    .addComponent(txtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCuil)
                    .addComponent(txtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLocalidad)
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCalle)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNuevoCliente.setText("Nuevo");
        btnNuevoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoClienteMouseClicked(evt);
            }
        });

        tbDatosClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbDatosClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDatosClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDatosClientes);

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        btnGuardarCliente.setText("Guardar");
        btnGuardarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarClienteMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(30, 150, 250));

        lblClientes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblClientes.setForeground(new java.awt.Color(255, 255, 255));
        lblClientes.setText("Clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClientes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClientes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbBuscarCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre" }));

        txtBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarClienteKeyReleased(evt);
            }
        });

        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarClienteMouseClicked(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(btnEliminarCliente)
                        .addComponent(btnNuevoCliente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarCliente)
                            .addComponent(btnVolver))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoClienteMouseClicked
        limpiar();
    }//GEN-LAST:event_btnNuevoClienteMouseClicked
    
    private void tbDatosClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatosClientesMouseClicked
        int row = tbDatosClientes.getSelectedRow();
        txtIDCliente.setText(tbDatosClientes.getValueAt(row, 0).toString());
        txtNombreCliente.setText(tbDatosClientes.getValueAt(row, 1).toString());
        cbRazonSocial.setSelectedItem(tbDatosClientes.getValueAt(row, 2).toString());
        txtTelefono.setText(tbDatosClientes.getValueAt(row, 3).toString());
        txtCuil.setText(tbDatosClientes.getValueAt(row, 4).toString());
        txtLocalidad.setText(tbDatosClientes.getValueAt(row, 5).toString());
        String est = tbDatosClientes.getValueAt(row, 6).toString();  
        
    }//GEN-LAST:event_tbDatosClientesMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnGuardarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarClienteMouseClicked
        guardar();
    }//GEN-LAST:event_btnGuardarClienteMouseClicked

    private void txtBuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClienteKeyReleased
        char tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_ENTER){
            tbDatosClientes.setModel(CC.getCliente(cbBuscarCliente.getSelectedIndex(), txtBuscarCliente.getText()));
        }
    }//GEN-LAST:event_txtBuscarClienteKeyReleased

    private void btnEliminarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarClienteMouseClicked
        int fila = tbDatosClientes.getSelectedRowCount();
        if (fila < 1 ){
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        } else {
            if (CC.deleteCliente(tbDatosClientes.getValueAt(tbDatosClientes.getSelectedRow(), 0).toString()) > 0){
                limpiar();
                listar();
            }
        }
    }//GEN-LAST:event_btnEliminarClienteMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        tbDatosClientes.setModel(CC.getCliente(cbBuscarCliente.getSelectedIndex(), txtBuscarCliente.getText()));
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        this.dispose();
        FrmInicio FI = new FrmInicio();
        FI.setVisible(true);
    }//GEN-LAST:event_btnVolverMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbBuscarCliente;
    private javax.swing.JComboBox<String> cbRazonSocial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblCuil;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JTable tbDatosClientes;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCuil;
    private javax.swing.JTextField txtIDCliente;
    private javax.swing.JTextField txtLocalidad;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
