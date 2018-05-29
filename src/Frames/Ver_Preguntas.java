/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Classes.Metodos;
import Frames.InterfazPrincipal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Ver_Preguntas extends javax.swing.JFrame {

    /**
     * Creates new form Ver_Preguntas
     */
    public Ver_Preguntas() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    File A;
    
    private void Mostrar(String S){
        try {
            A = new File(S);
            FileReader fr = new FileReader(A);
            BufferedReader br = new BufferedReader(fr);
            String n;
            String line = br.readLine();
            ver.setText(null);
            while ( line!= null) {
                ver.append(line+"\n");
                line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Error");
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        atras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ver = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        asignatura = new javax.swing.JComboBox<>();
        asign = new javax.swing.JComboBox<>();
        tema = new javax.swing.JComboBox<>();
        dificultad = new javax.swing.JComboBox<>();
        verAsignatura = new javax.swing.JButton();
        verTemas = new javax.swing.JButton();
        verPreguntas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atras.setText("Atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        getContentPane().add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        ver.setColumns(20);
        ver.setRows(5);
        jScrollPane1.setViewportView(ver);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 52, 604, 186));

        jLabel1.setText("Asignatura");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 180, -1));

        jLabel2.setText("Temas");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 290, 200, -1));

        jLabel3.setText("Preguntas");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 290, 200, -1));

        asignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignaturaActionPerformed(evt);
            }
        });
        getContentPane().add(asignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 150, -1));

        getContentPane().add(asign, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 140, -1));

        getContentPane().add(tema, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 140, -1));

        getContentPane().add(dificultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 140, -1));

        verAsignatura.setText("Ver Asignatura");
        verAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verAsignaturaActionPerformed(evt);
            }
        });
        getContentPane().add(verAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 490, 130, -1));

        verTemas.setText("Ver temas");
        verTemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTemasActionPerformed(evt);
            }
        });
        getContentPane().add(verTemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 490, 150, -1));

        verPreguntas.setText("Ver Preguntas");
        verPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPreguntasActionPerformed(evt);
            }
        });
        getContentPane().add(verPreguntas, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 490, 140, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        // TODO add your handling code here:
        InterfazPrincipal ip = new InterfazPrincipal();
        ip.setVisible(true);
        dispose();
    }//GEN-LAST:event_atrasActionPerformed

    private void verAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verAsignaturaActionPerformed
        // TODO add your handling code here:
        Mostrar("Profesor/Asignatura.txt");
    }//GEN-LAST:event_verAsignaturaActionPerformed

    private void verTemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTemasActionPerformed
        // TODO add your handling code here:
        String Asignatura = (String) asignatura.getSelectedItem();
        String direccion = "Profesor/"+ Asignatura + "/Temas.txt";
        Mostrar(direccion);
        
    }//GEN-LAST:event_verTemasActionPerformed

    private void verPreguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPreguntasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verPreguntasActionPerformed

    private void asignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignaturaActionPerformed
        // TODO add your handling code here:
        Metodos e = new Metodos();
        try {
            e.comboBox("Profesor/Asignatura.txt", tema);
        } catch (IOException ex) {
            Logger.getLogger(Ver_Preguntas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_asignaturaActionPerformed

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
            java.util.logging.Logger.getLogger(Ver_Preguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ver_Preguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ver_Preguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ver_Preguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ver_Preguntas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> asign;
    private javax.swing.JComboBox<String> asignatura;
    private javax.swing.JButton atras;
    private javax.swing.JComboBox<String> dificultad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> tema;
    private javax.swing.JTextArea ver;
    private javax.swing.JButton verAsignatura;
    private javax.swing.JButton verPreguntas;
    private javax.swing.JButton verTemas;
    // End of variables declaration//GEN-END:variables
}
