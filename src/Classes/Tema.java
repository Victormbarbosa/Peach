/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author DORIS SALCEDO
 */
public class Tema {

   ArrayList<Pregunta> preguntas = new ArrayList();

   public Tema(String titulo) {
       this.preguntas = new ArrayList();
    }

    /*public ArrayList<Pregunta> getPreguntas(Nivel nivel) {
        ArrayList <Pregunta> temp = new ArrayList();
        for (Pregunta p : preguntas) {
            if (p.nivel.equals(nivel)) {
                temp.add(p);
            }
        }
        return temp;
    }*/
    
   /* public void addPregunta(Pregunta e){
        preguntas.add(e);
        e.tema = this;
    }*/
    

}
