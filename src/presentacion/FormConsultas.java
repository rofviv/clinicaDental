package presentacion;

import datos.ConsultasSQL;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class FormConsultas extends javax.swing.JDialog {

    ResultSet rs;
    ConsultasSQL con;
    DefaultTableModel model;
    
    public FormConsultas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.con = new ConsultasSQL();
        this.rs = con.mostrarConsulta();
    }
    
    public void cargarConsultas() {
        try {
            while(rs.next()) {
                String dentista = nombreDentista(Integer.parseInt(rs.getString("ciDent")));
                String paciente = nombrePaciente(Integer.parseInt(rs.getString("ciPac")));
                String tratamiento = tratamiento(Integer.parseInt(rs.getString("idTrat")));
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("fecha"),
                    rs.getString("hora"),
                    paciente,
                    dentista,
                    rs.getString("sintomas"),
                    tratamiento,
                    rs.getString("estado")
                });
            }
        } catch (Exception e) {
            System.err.println("Error al cargar la tabla consulta.");
        }
    }
    
    private String nombreDentista(int ci) {
        ResultSet rs = con.obtenerNombreDentistaConCI(ci);
        String nombre = "";
        try {
            rs.next();
            nombre = rs.getString(1);
        } catch (Exception e) {
            System.err.println("Error en mostrar dentista.");
        }
        return nombre;
    }
    
    private String nombrePaciente(int ci) {
        ResultSet rs = con.obtenerNombrePacienteConCI(ci);
        String nombre = "";
        try {
            rs.next();
            nombre = rs.getString(1);
        } catch (Exception e) {
            System.err.println("Error en mostrar paciente.");
        }
        return nombre;
    }
    
    private String tratamiento(int id) {
        ResultSet rs = con.obtenerNombreTratamiento(id);
        String nombre = "";
        try {
            rs.next();
            nombre = rs.getString(1);
        } catch (Exception e) {
            System.err.println("Error en mostrar tratamiento.");
        }
        return nombre;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        calendarComboBox1 = new datos.CalendarComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Fecha", "Hora", "Paciente", "Dentista", "Síntomas", "Tratamiento", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tblConsulta);

        jLabel1.setText("Fecha de Consulta");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Calendar Search.png"))); // NOI18N
        jButton1.setText("Buscar");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Calendar Add.png"))); // NOI18N
        jButton2.setText("Nueva");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(calendarComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(calendarComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.model = (DefaultTableModel) tblConsulta.getModel();
        cargarConsultas();
    }//GEN-LAST:event_formWindowActivated

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new FormNuevaConsulta(null, true).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FormConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormConsultas dialog = new FormConsultas(new javax.swing.JFrame(), true);
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
    private datos.CalendarComboBox calendarComboBox1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConsulta;
    // End of variables declaration//GEN-END:variables
}
