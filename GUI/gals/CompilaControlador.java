/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author João Victhor Campos e Lucas Rocha Alves 17-18/11
 */

import Gals.LexicalError;
import Gals.Lexico;
import Gals.SemanticError;
import Gals.Semantico;
import Gals.Sintatico;
import Gals.SyntaticError;
import Gals.Token;
import java.util.ArrayList;
import java.util.List;

public class CompilaControlador {

	List<Token> listaTokens;
	private Lexico lexico;
	private Sintatico sintatico;
	private Semantico semantico;

	public CompilaControlador() {
		listaTokens = new ArrayList<Token>();
		lexico = new Lexico();
		sintatico = new Sintatico();
		semantico = new Semantico();
		
	}

	public List<Token> analisarLexico(String texto) throws LexicalError {
		List<Token> tokens = new ArrayList<Token>();
		lexico.setInput(texto);
		Token t = lexico.nextToken();
		while (t != null) {
			tokens.add(t);
			t = lexico.nextToken();
		}
		return tokens;

	}

	public void analisarSintatico(String texto) throws LexicalError, SyntaticError, SemanticError {
		lexico.setInput(texto);
		semantico = new Semantico();
		sintatico.parse(lexico, semantico);
	}
	
	public void analisarSemantico(String texto) throws LexicalError, SyntaticError, SemanticError {
			semantico = new Semantico();
			lexico.setInput(texto);
			sintatico.parse(lexico, semantico);
	
	}

}

