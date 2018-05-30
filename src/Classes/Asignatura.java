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
public class Asignatura {
  String Nombre;  
  ArrayList <Tema> temas = new ArrayList();

    public Asignatura(String Nombre) {
        this.Nombre=Nombre;
    }

    Asignatura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addTema (Tema t){
        temas.add(t);
    }
    
    public Tema getTema (){
        Tema tema = null;
        for (Tema t : temas) {
            
        }
        return tema;
    }
    
    
    
    
    
}
