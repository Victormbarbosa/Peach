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
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DORIS SALCEDO
 */
public class Asignatura {

    String Nombre;
    ArrayList<Tema> temas = new ArrayList();

    public Asignatura(String Nombre) {
        this.Nombre = Nombre;
        try {
            setTemas();
        } catch (IOException ex) {
            Logger.getLogger(Asignatura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setTemas() throws FileNotFoundException, IOException {

        File f = new File("Profesor/" + Nombre + "/Temas.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        Metodos e = new Metodos();
        int h = 0;
        while (br.ready()) {
            String nombre = br.readLine();
            if (nombre != null) {
                System.out.println(nombre);
                nombre = e.Desco(nombre, 1);
                addTema(new Tema(nombre, this));
            }
        }
    }

    public void addTema(Tema t) {
        t.addAsignatura(this);
        temas.add(t);
    }

    public Tema getTema() {
        Tema tema = null;
        for (Tema t : temas) {

        }
        return tema;
    }

}
