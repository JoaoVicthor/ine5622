/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gals;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author joao
 */
class Simbolo {
    HashMap<String, Object> atributos;

    public Simbolo(String nome,int nivel) {
        putAtributo("nome", nome);
        putAtributo("nivel", nivel);
    }
    
    void putAtributo(String key, Object obj){
            atributos.put(key, obj);
    }
    void removeAtributo(String key){
            atributos.remove(key);
    }
    Object getAtributo(String key){
            return atributos.get(key);
    }
    
}
