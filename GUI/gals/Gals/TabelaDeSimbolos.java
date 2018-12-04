/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gals;

import java.util.HashMap;

/**
 *
 * @author joao
 */
public class TabelaDeSimbolos {
    HashMap<String,Simbolo> simbolos = new HashMap<>();
    int nivel;

    public TabelaDeSimbolos(int nivel) {
        this.nivel = nivel;
    }
    
    void put(String lexeme, Simbolo simbolo){
        simbolos.put(lexeme, simbolo);
    }
    boolean containsKey(String key){
        return simbolos.containsKey(key);
    }
    Simbolo get(String lexeme){
        return simbolos.get(lexeme);
    }
    int getNivel(){
        return nivel;
    }
    
}
