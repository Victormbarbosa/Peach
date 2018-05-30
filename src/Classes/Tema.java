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
public class Tema {

    String Nombre;
    Asignatura asignatura;
    ArrayList<Pregunta> preguntas_1 = new ArrayList();

    public Tema(String titulo, Asignatura asig) {
        this.Nombre = titulo;
        this.asignatura=asig;
        try {
            setPreguntas();
        } catch (IOException ex) {
            Logger.getLogger(Tema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setPreguntas() throws FileNotFoundException, IOException {
        System.out.println(""+asignatura.Nombre);
        File f = new File("Profesor/" + asignatura.Nombre +"/"+Nombre+"/Preguntas.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        Metodos e = new Metodos();
        int h = 0;
        while (br.ready()) {
            String contenido = e.Desco(br.readLine(), 2);
            /*int Dificultad = Integer.parseInt( e.Desco(br.readLine(), 1));*/
            System.out.println(contenido);
            addPregunta(new Pregunta(contenido, 2));
        }

    }
    
    public void addAsignatura(Asignatura asig){
        asignatura = asig;
    }
    
    private void addPregunta(Pregunta e) {
        preguntas_1.add(e);
    }

    
}
