/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Classes.Metodos;

/**
 *
 * @author Usuario
 */
public class AñadirInformacion extends javax.swing.JFrame {

    /**
     * Creates new form AñadirInformacion
     */
    public AñadirInformacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        Metodos e = new Metodos();
        int h = 0;
        try {
            h = e.Generador_de_Combobox("Profesor/Asignatura.txt", ComboAsignatura, h);
            if (h < 1) {
                JOptionPane.showMessageDialog(null, "No hay Asignaturas, deberia agregar alguna.");
            }
        } catch (IOException ex) {
            Logger.getLogger(AñadirInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pregunta = new javax.swing.JTextField();
        ComboTemas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        ComboDificultad = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ComboAsignatura = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pregunta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Pregunta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Pregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreguntaActionPerformed(evt);
            }
        });
        getContentPane().add(Pregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 453, 205));

        ComboTemas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));
        ComboTemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTemasActionPerformed(evt);
            }
        });
        getContentPane().add(ComboTemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 170, 36));

        jLabel1.setText("Asignatura");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 453, 28));

        ComboDificultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "1", "2", "3" }));
        getContentPane().add(ComboDificultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 50, 40));

        jLabel2.setText("Dificultad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 160, 20));

        jLabel4.setText("Temas");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 20));

        ComboAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));
        ComboAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboAsignaturaActionPerformed(evt);
            }
        });
        getContentPane().add(ComboAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 170, 36));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 140, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreguntaActionPerformed

    }//GEN-LAST:event_PreguntaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String Asignatura = (String) ComboAsignatura.getSelectedItem();
        String tema = (String) ComboTemas.getSelectedItem();
        Metodos e = new Metodos();
        String nom, jor;
        nom = Pregunta.getText();
        jor = (String) ComboDificultad.getSelectedItem();
        String total = jor + ";" + nom + ";";
        String temp = null;
        String x = "Profesor/" + Asignatura + "/" + tema + "/Preguntas_"+jor+".txt";
        if (Asignatura.equals("...")) {
            JOptionPane.showMessageDialog(null, "No ha Selccionado ninguna Asignatura.");
        } else {
            if (tema.equals("...")) {
                JOptionPane.showMessageDialog(null, "No ha Selccionado ningun Tema.");
            } else {
                if (jor.equals("...")) {
                    JOptionPane.showMessageDialog(null, "No ha Selccionado ninguna Dificultad.");
                } else {
                    if (nom.equals("")) {
                        JOptionPane.showMessageDialog(null, "No ha escrito ninguna pregunta.");
                    } else {
                        try {
                            temp = e.concatenar(x);
                            e.guardar(temp, x, total);
                        } catch (IOException ex) {
                            Logger.getLogger(AñadirInformacion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        InterfazPrincipal ia = new InterfazPrincipal();
                        ia.setVisible(true);
                        dispose();
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboAsignaturaActionPerformed
        String Asignatura = (String) ComboAsignatura.getSelectedItem();
        Metodos e = new Metodos();
        ComboTemas.removeAllItems();
        ComboTemas.addItem("...");
        int h = 0;
        try {

            h = e.Generador_de_Combobox("Profesor/" + Asignatura + "/Temas.txt", ComboTemas, h);
            if (h < 1) {
                JOptionPane.showMessageDialog(null, "La Asignatura que ha seleccionado no tiene Temas, sí desea usar esta asignatura es necesario que añada temas.");

            }
        } catch (IOException ex) {
            Logger.getLogger(AñadirInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ComboAsignaturaActionPerformed

    private void ComboTemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTemasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboTemasActionPerformed

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
            java.util.logging.Logger.getLogger(AñadirInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AñadirInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AñadirInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AñadirInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AñadirInformacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboAsignatura;
    private javax.swing.JComboBox<String> ComboDificultad;
    private javax.swing.JComboBox<String> ComboTemas;
    private javax.swing.JTextField Pregunta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
