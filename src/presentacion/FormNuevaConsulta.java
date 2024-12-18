package presentacion;

import datos.ConsultasSQL;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class FormNuevaConsulta extends javax.swing.JDialog {

    ConsultasSQL con;
    ResultSet rs;
    public FormNuevaConsulta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.con = new ConsultasSQL();
        llenarPacientes();
        llenarDentistas();
        llenarTratamientos();
    }
    
    public void llenarPacientes() {
        rs = con.mostrarPacientes();
        try {
            while (rs.next()) {
                cbPaciente.addItem(rs.getString("nombre"));
            }
        } catch (Exception e) {
        }
    }
    
    public void llenarDentistas() {
        rs = con.mostrarDentista();
        try {
            while (rs.next()) {
                cbDentista.addItem(rs.getString("nombre"));
            }
        } catch (Exception e) {
            System.err.println("Error al cargar los tratamientos.");
        }
    }
    
    public void llenarTratamientos() {
        rs = con.mostrarTratamientos();
        try {
            while (rs.next()) {
                cbTratamiento.addItem(rs.getString("tratamiento"));
            }
        } catch (Exception e) {
            System.err.println("Error al cargar los tratamientos.");
        }
    }
    
    public void generarFactura() {
        con.nuevaFactura(cbPago.getSelectedItem().toString());
    }
    
    public int ciPaciente() {
        rs = con.obtenerCIPaciente(cbPaciente.getSelectedItem().toString());
        int i = 0;
        try {
            rs.next();
            i = Integer.parseInt(rs.getString(1));
            System.out.println("paciente: "+ i);
        } catch (Exception e) {
        }
        return i;
    }
    
    public int ciDentista() {
        rs = con.obtenerCIDentista(cbDentista.getSelectedItem().toString());
        int i = 0;
        try {
            rs.next();
            i = Integer.parseInt(rs.getString(1));
            System.out.println("dentista: "+ i);
        } catch (Exception e) {
        }
        return i;
    }
    
    public int idTratamiento() {
        rs = con.obtenerIDTratamiento(cbTratamiento.getSelectedItem().toString());
        int i = 0;
        try {
            rs.next();
            i = Integer.parseInt(rs.getString(1));
            System.out.println("tratamiento: "+ i);
        } catch (Exception e) {
        }
        return i;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDtConsulta = new javax.swing.JLabel();
        lbHrConsulta = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        lblPaciente = new javax.swing.JLabel();
        lblDentista = new javax.swing.JLabel();
        cbDentista = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSintomas = new javax.swing.JTextArea();
        lblTratamento = new javax.swing.JLabel();
        cbTratamiento = new javax.swing.JComboBox();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbPago = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        lblCosto = new javax.swing.JLabel();
        cbPaciente = new javax.swing.JComboBox();
        txtFecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblDtConsulta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDtConsulta.setText("Fecha de Consulta :");

        lbHrConsulta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbHrConsulta.setText("Hora de Consulta :");

        lblPaciente.setText("CI del paciente:");

        lblDentista.setText("Dentista:");

        cbDentista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---- Seleccione un Dentista ----" }));

        jLabel1.setText("Síntomas:");

        txtSintomas.setColumns(20);
        txtSintomas.setLineWrap(true);
        txtSintomas.setRows(5);
        txtSintomas.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtSintomas);

        lblTratamento.setText("Tratamiento:");

        cbTratamiento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---- Seleccione un tratamiento ----" }));
        cbTratamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbTratamientoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbTratamientoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbTratamientoMouseReleased(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Calendar Confirmed.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Calendar Stop.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Forma de pago:");

        cbPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tarjeta", "Al contado" }));

        jLabel2.setText("Importe");

        lblCosto.setText("/");

        cbPaciente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--- Seleccione un Paciente ---" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDtConsulta)
                    .addComponent(lblPaciente)
                    .addComponent(lblDentista)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(lblTratamento)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbHrConsulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(cbDentista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbPago, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCosto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbPaciente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDtConsulta)
                    .addComponent(lbHrConsulta)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaciente)
                    .addComponent(cbPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDentista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDentista))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTratamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCosto))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbTratamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTratamientoMouseClicked
        
    }//GEN-LAST:event_cbTratamientoMouseClicked

    private void cbTratamientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTratamientoMousePressed
        
    }//GEN-LAST:event_cbTratamientoMousePressed

    private void cbTratamientoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTratamientoMouseReleased

    }//GEN-LAST:event_cbTratamientoMouseReleased

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();
        double importe = Integer.parseInt(txtImporte.getText());
        String sintomas = txtSintomas.getText();
        con.nuevaConsulta(fecha, hora, importe, sintomas, ciPaciente(), ciDentista(), idTratamiento());
        JOptionPane.showMessageDialog(this, "Guardado con éxito.");
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormNuevaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNuevaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNuevaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNuevaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormNuevaConsulta dialog = new FormNuevaConsulta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbDentista;
    private javax.swing.JComboBox cbPaciente;
    private javax.swing.JComboBox cbPago;
    private javax.swing.JComboBox cbTratamiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHrConsulta;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblDentista;
    private javax.swing.JLabel lblDtConsulta;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblTratamento;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextArea txtSintomas;
    // End of variables declaration//GEN-END:variables
}
