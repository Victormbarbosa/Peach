/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author DORIS SALCEDO
 */
public class Generar_examen extends javax.swing.JFrame {

    /**
     * Creates new form Generar_examen
     */
    public Generar_examen() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        materia = new javax.swing.JTextField();
        evaluacion = new javax.swing.JTextField();
        fecha = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        generar.setText("Generar Examen");
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });
        getContentPane().add(generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 434, 246, 48));

        jLabel1.setText("Nombre del Profesor:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jLabel2.setText("Asignatura:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jLabel3.setText("Evaluacion:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel4.setText("Fecha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 200, -1));
        getContentPane().add(materia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 200, -1));
        getContentPane().add(evaluacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 200, -1));
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 200, -1));

        jButton3.setText("Atras");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
        // TODO add your handling code here:
        String titulo = "Examen de " + materia.getText();
        String nom = "Nombre del profesor: " + nombre.getText();
        String mat = "Asignatura: " + materia.getText();
        String ev = "Evaluacion: " + evaluacion.getText();
        String fec = "Fecha: " + fecha.getText();

        XWPFDocument documento = new XWPFDocument();

        //Declaramos el titulo y le asignamos algunas propiedades
        XWPFParagraph titulo_doc = documento.createParagraph();
        titulo_doc.setAlignment(ParagraphAlignment.CENTER);
        titulo_doc.setVerticalAlignment(TextAlignment.TOP);

        //Declaramos el parrafo y le asignamos algunas propiedades
        XWPFParagraph parrafo = documento.createParagraph();
        parrafo.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun r1 = titulo_doc.createRun();
        r1.setBold(true);
        r1.setText(titulo);
        r1.setFontFamily("Times New Roman");
        r1.setFontSize(14);
        r1.setTextPosition(10);
        r1.setUnderline(UnderlinePatterns.SINGLE);

        //Para el parrafo
        XWPFRun r2 = parrafo.createRun();
        r2.setText(nom);
        r2.setFontSize(12);
        r2.addCarriageReturn();

        XWPFRun r3 = parrafo.createRun();
        r3.setText(mat);
        r3.setFontSize(12);
        r3.addCarriageReturn();

        XWPFRun r4 = parrafo.createRun();
        r4.setText(ev);
        r4.setFontSize(12);
        r4.addCarriageReturn();

        XWPFRun r5 = parrafo.createRun();
        r5.setText(fec);
        r5.setFontSize(12);
        r5.addCarriageReturn();

        FileOutputStream word = null;
        try {
            word = new FileOutputStream(titulo + ".docx");

            documento.write(word);
            word.close();

        } catch (IOException ex) {
            Logger.getLogger(Generar_examen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //

        try {
            File path = new File(titulo + ".docx");
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_generarActionPerformed

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
            java.util.logging.Logger.getLogger(Generar_examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Generar_examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Generar_examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Generar_examen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Generar_examen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField evaluacion;
    private javax.swing.JTextField fecha;
    private javax.swing.JButton generar;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField materia;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
