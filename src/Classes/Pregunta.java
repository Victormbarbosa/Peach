/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author DORIS SALCEDO
 */
public class Pregunta {

    String contenido;
    Tema tema;
    Nivel nivel;

    public Pregunta(String contenido, Nivel nivel) {
        this.contenido = contenido;
        this.nivel = nivel;
    }

    public String getContenido() {
        return contenido;
    }

}
