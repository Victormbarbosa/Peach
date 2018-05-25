/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Classes.Archivo;

/**
 *
 * @author danie
 */
public class Registrarse extends javax.swing.JFrame {

    /**
     * Creates new form Registrarse
     */
    public Registrarse() {
        initComponents();
        this.setLocationRelativeTo(null);
        vali.setVisible(false);
        cedu.setVisible(false);
    }

    public boolean confNum(String x) {

        boolean sw;

        try {
            Integer.parseInt(x);
            sw = true;
        } catch (NumberFormatException excepcion) {
            sw = false;
        }

        return sw;
    }
    
    
    public void registrar_usuario(String temp) throws IOException{
        File F = new File("Usuario.txt");
        FileWriter fw = new FileWriter(F);
        
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter  pw = new PrintWriter(fw);
        
        String nombre = nom.getText();
        String contraseña = con.getText();
        String validar = val.getText();
        String cedula = ced.getText();
        String materia = mat.getText();
        String nickname = nick.getText();
        
        if (confNum(cedula) == false) {
                cedu.setVisible(true);
                pw.write(temp);
                pw.append("");
                pw.close();
                bw.close();
                fw.close();
        }else{
            if (!con.equals(val)) {
                vali.setVisible(true);
                pw.write(temp);
                pw.append("");
                pw.close();
                bw.close();
                fw.close();
            }else{
                pw.write(temp);
                pw.append(nombre+";"+contraseña+";"+nickname+";"+validar+";"+materia+";");
                pw.close();
                bw.close();
                fw.close();
                Inicio in = new Inicio();
                dispose();
            }
        }
        
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        ced = new javax.swing.JTextField();
        mat = new javax.swing.JTextField();
        con = new javax.swing.JPasswordField();
        val = new javax.swing.JPasswordField();
        nick = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        vali = new javax.swing.JLabel();
        cedu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 84, -1, -1));

        jLabel2.setText("cedula");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 134, -1, -1));

        jLabel3.setText("materia");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        jLabel4.setText("contraseña");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 247, -1, -1));

        jLabel5.setText("nickname");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        jLabel6.setText("Validar Contraseña");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 300, -1, -1));
        getContentPane().add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 81, 160, -1));
        getContentPane().add(ced, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 131, 160, -1));
        getContentPane().add(mat, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 160, -1));
        getContentPane().add(con, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 244, 160, -1));
        getContentPane().add(val, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 297, 160, -1));
        getContentPane().add(nick, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 160, -1));

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        getContentPane().add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, -1, -1));

        vali.setForeground(new java.awt.Color(255, 0, 0));
        vali.setText("*No ha validado su contraseña correctamente");
        getContentPane().add(vali, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 230, -1));

        cedu.setForeground(new java.awt.Color(255, 0, 0));
        cedu.setText("*La cedula solo debe contener valores numericos");
        getContentPane().add(cedu, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 240, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        Archivo a = new Archivo();
        try {
            registrar_usuario(a.concatenar("Usuario.txt"));
        } catch (IOException ex) {
            Logger.getLogger(Registrarse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guardarActionPerformed

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
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrarse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ced;
    private javax.swing.JLabel cedu;
    private javax.swing.JPasswordField con;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField mat;
    private javax.swing.JTextField nick;
    private javax.swing.JTextField nom;
    private javax.swing.JPasswordField val;
    private javax.swing.JLabel vali;
    // End of variables declaration//GEN-END:variables
}
