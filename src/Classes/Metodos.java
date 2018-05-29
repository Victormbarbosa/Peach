/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class Metodos {

    public Metodos() {
    }

    public String especifico(String Nombre) throws FileNotFoundException, IOException {

        File F = new File(Nombre);
        FileReader fw = new FileReader(F);
        BufferedReader bw = new BufferedReader(fw);
        String es = "";
        String x = "";
        while (bw.ready()) {
            if ("".equals(x)) {
            } else {
                es = x;
            }
            x = bw.readLine();
            if (x != null && !x.equals("")) {
                es = x + "r";

            } else {
                break;
            }
        }
        bw.close();
        fw.close();
        JOptionPane.showMessageDialog(null, es);
        return es;
    }

    public void guardar(String temp, String x, String info) throws IOException {
        String b = "";
        int conpilador = 1;
        File F = new File(x);
        FileWriter fw = new FileWriter(F);
        Metodos e = new Metodos();
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(fw);

        pw.write(temp);
        pw.append(info);

        pw.close();
        bw.close();
        fw.close();
    }
    
      public void comboBox(String archivo, JComboBox combo) throws FileNotFoundException, IOException {
        File F = new File(archivo);
        FileReader fr = new FileReader(F);
        BufferedReader br = new BufferedReader(fr);
        String n;
        String line = br.readLine();
        while (line != null) {
            String[] parts = line.split(";");
            String item = parts [0];
            combo.addItem(item);
            line = br.readLine();
        }
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

    public void modificar_contraseña(String cod, String con) throws FileNotFoundException, IOException {
        File originalFile = new File("Usuario.txt");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        File temporal = new File("temporal.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(temporal));

        String line = null;
        String linea = null;
        int var = 0;
        String temp = "";

        while ((line = br.readLine()) != null) {
            if (line.contains(cod)) {
                linea = line;
                StringTokenizer st = new StringTokenizer(linea, ";");

                while (var < 3) {
                    temp = temp + st.nextToken() + ";";
                    var++;
                }
                temp = temp + con + ";";
                while (st.hasMoreTokens()) {
                    if (st.nextToken().equals(cod)) {
                        temp = temp + cod + ";";
                    }
                }
                line = line.replace(line, temp);
            }
            pw.println(line);
            pw.flush();

        }

        pw.close();
        br.close();

        Metodos p = new Metodos();
        String pancreas = p.LeerArchivo("temporal.txt");
        p.Sobreescribir("Usuario.txt", pancreas);
        p.Sobreescribir("temporal.txt", "");

    }

    public void Sobreescribir(String x, String y) throws IOException {

        File F = new File(x);
        FileWriter fw = new FileWriter(F);

        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(fw);

        pw.write(y);

        pw.close();
        bw.close();
        fw.close();
    }

    public void Eliminar_Linea(String indice, String archivo) throws FileNotFoundException, IOException {
        File originalFile = new File(archivo);
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        File temporal = new File("temporal.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(temporal));

        String line = null;

        while ((line = br.readLine()) != null) {
            if (!line.contains(indice)) {
                pw.println(line);
                pw.flush();
            }
        }

        pw.close();
        br.close();

        Metodos p = new Metodos();
        String nuevo = p.LeerArchivo("temporal.txt");
        p.Sobreescribir(archivo, nuevo);
        p.Sobreescribir("temporal.txt", "");
    }

    public void modificar(String indice, String archivo) throws FileNotFoundException, IOException {
        String datoAnterior = (String) JOptionPane.showInputDialog(null, "Ingrese dato anterior");
        String datoNuevo = (String) JOptionPane.showInputDialog(null, "Ingrese dato nuevo");

        File originalFile = new File(archivo);
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        File temporal = new File("temporal.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(temporal));

        String line = null;
        String linea = null;
        String temp = "";

        while ((line = br.readLine()) != null) {
            if (line.contains(indice)) {
                linea = line;
                StringTokenizer st = new StringTokenizer(linea, ";");
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    if (!token.equals(datoAnterior)) {
                        temp = temp + token + ";";
                    } else {
                        temp = temp + datoNuevo + ";";
                    }
                }
                line = line.replace(line, temp);
            }
            pw.println(line);
            pw.flush();
        }

        pw.close();
        br.close();

        Metodos p = new Metodos();
        String nuevo = p.LeerArchivo("temporal.txt");
        p.Sobreescribir(archivo, nuevo);
        p.Sobreescribir("temporal.txt", "");
    }

    public int indice(String archivo) throws FileNotFoundException, IOException {
        File originalFile = new File(archivo);
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        String line = null;
        int cont = 0;
        do {
            cont++;
        } while ((line = br.readLine()) != null);
        br.close();
        return cont;
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

    public String buscar(String x, String f) throws FileNotFoundException, IOException {
        String y = null;
        String ty = "";
        boolean sw = false;
        String po = f;
        /*int cont =0;*/
        File F = new File(x);
        FileReader fr = new FileReader(F);
        BufferedReader br = new BufferedReader(fr);
        while (sw == false && br.ready()/*&& /*cont<v*/) {
            y = br.readLine();
            for (int i = 0; i < y.length(); i++) {
                if (y.substring(i, i + 1).equals(";")) {
                    if (ty.equals(po)) {
                        sw = true;

                    } else {
                        ty = "";
                        /*cont=cont+1;*/
                    }
                } else {
                    ty = ty + y.substring(i, i + 1);
                }
            }
        }
        fr.close();
        br.close();
        
        
        return ty;

    }

    public boolean verificar(String x, String f) {          //verificar va a decir usando un booleano si x palabra existe en algun campo
        String ty = "";
        boolean j = false;
        String po = f;

        for (int i = 0; i < x.length(); i++) {
            if (x.substring(i, i + 1).equals(";")) {
                if (ty.equals(po)) {
                    j = true;

                } else {
                    ty = "";
                }
            } else {
                ty = ty + x.substring(i, i + 1);
            }
        }

        return j;
    }

    public String Desco(String x, int y) {              //Desco se va a encargar que dependiendo de la poscion y, extraer un campo especifico
        int cont = 0;
        int j = 0, i = 0;
        String ty = "";
        while (j == 0) {

            if (x.substring(i, i + 1).equals(";")) {
                cont = cont + 1;
                if (cont == y) {
                    j = 1;
                } else {
                    ty = "";
                }
            } else {
                ty = ty + x.substring(i, i + 1);
            }
            i = i + 1;
        }
        
            
            
        
        return ty;
    }

    public int Generador_de_Combobox(String x, JComboBox y, int  h2) throws FileNotFoundException, IOException {
        
        File f = new File(x);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String g;
        
        while (br.ready()) {
            g = br.readLine();  
            Metodos p = new Metodos();
            String h = p.Desco(g, 1);
            y.addItem(h);
            h2=h2+1;
        }
        return h2;
    }
}
