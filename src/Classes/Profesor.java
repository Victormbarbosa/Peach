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
public class Profesor {

    ArrayList<Asignatura> Asignaturas = new ArrayList();

    public Profesor() {
        try {
            setAsignaturas();
        } catch (IOException ex) {
            Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setAsignaturas() throws FileNotFoundException, IOException {

        File f = new File("Profesor/Asignatura.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        Metodos e = new Metodos();
        int h = 0;
        while (br.ready()) {
            String Nombre = br.readLine();
            if (Nombre != null) {
                Nombre = e.Desco(Nombre, 1);
                System.out.println("" + Nombre);
                AddAsignatura(new Asignatura(Nombre));
            }
        }
    }

    public void AddAsignatura(Asignatura asigna) {
        Asignaturas.add(asigna);
    }

}
