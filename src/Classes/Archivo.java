/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author DORIS SALCEDO
 */
public class Archivo {
    
    public void crearArchivo(String...str) throws IOException{
        int cont = 0;
        String archivo = "";
        String contenido = "";
        for (String string : str) {
            if (cont == 0) {
                archivo = string;
            }else{
                contenido = contenido + string +";";
            }
            cont++;
        }
        File f = new File (archivo);
        f.createNewFile();
        
    }
    
    public void Sobreescribir(String x, String y) throws IOException{
    
        File F = new File(x);
        FileWriter fw = new FileWriter(F);
        
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter  pw = new PrintWriter(fw);
        
        pw.write(y);
        
        
        pw.close();
        bw.close();
        fw.close();
    }
    
    
    public String LeerArchivo(String Nombre) throws IOException {
        File F = new File(Nombre);

        FileReader fw = new FileReader(F);

        BufferedReader bw = new BufferedReader(fw);
        String L = "";
        String x = "";
        while (true) {
            x = bw.readLine();

            if (x != null) {
                L = L + x + "\r\n";

            } else {
                break;
            }
        }
        bw.close();
        fw.close();
        return L;
    }
    
    
    public void modificar(String indice, String archivo) throws FileNotFoundException, IOException{
        String datoAnterior = (String)JOptionPane.showInputDialog(null, "Ingrese dato anterior");
        String datoNuevo = (String)JOptionPane.showInputDialog(null, "Ingrese dato nuevo");  
      
        File originalFile = new File(archivo);
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        File temporal = new File("temporal.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(temporal));
        
        String line = null;
        String linea = null;
        String temp="";
        
        while ((line = br.readLine()) != null) {
            if (line.contains(indice)) {
                linea = line;
                StringTokenizer st = new StringTokenizer (linea,";");
                while(st.hasMoreTokens()){
                    String token = st.nextToken();
                    if (!token.equals(datoAnterior)) {
                    temp=temp+token+";";                    
                    }else{
                    temp=temp+datoNuevo+";";
                    }
                }
                line= line.replace(line, temp);
            }       
            pw.println(line);
            pw.flush();
        } 
 
        pw.close();
        br.close();
        
        
        Archivo p = new Archivo();
        String nuevo=p.LeerArchivo("temporal.txt");
        p.Sobreescribir(archivo, nuevo);
        p.Sobreescribir("temporal.txt", "");
    }
    
    public String concatenar(String nombre) throws IOException {
        String temp = this.LeerArchivo(nombre);
        if ("null".equals(temp)) {
            temp = "";
        } else {
            temp = this.LeerArchivo(nombre);
        }
        return temp;
    }
    
}
