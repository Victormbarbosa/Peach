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

/**
 *
 * @author DORIS SALCEDO
 */
public class Profesor {

    ArrayList<Asignatura> Asignaturas = new ArrayList();

    public Profesor() {
       
        Asignatura asig = new Asignatura();
        
        
        
        
        
    }
    
    
    
    public void setAsignaturas() throws FileNotFoundException, IOException {
        File f = new File("Profesor/Asignatura.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String g;
        
       /* while (br.ready()) {
            g = br.readLine();  
            Metodos p = new Metodos();
            String h = p.Desco(g, 1);
            Asignaturas.add(h);
            h2=h2+1;
        }*/
    }

 

}
