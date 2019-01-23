/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author João Victhor Campos e Lucas Rocha Alves 01-08/12
 */
package Gals;

import java.util.ArrayList;

public class Semantico implements Constants {

    boolean checarSemantica;
    int posicao;

    int nivelAtual;
    int deslocamento;
    int tipoAtual;
    int tipoLadoEsq;
    String subCategVarInd;
    int tipoConst;
    int tipoExpr;
    int tipoExprSimples;
    int tipoTermo;
    int tipoFator;
    int tipoVetor;
    int numParamFormais;
    int numParamAtuais;
    int numElementos;

    Object valConst;
    String metodoAtual;
    String idAtual;
    String operador;

    boolean metTemTipo;
    boolean retorneUsado = false;
    boolean opNega;
    boolean opUnario;
    boolean divisao;

    String nomeDoPrograma;
    String categoriaAtual;
    String subcategoria;
    String contextoLID;
    String contextoEXPR;
    String MPP;
    ArrayList<Simbolo> LID = new ArrayList<>();
    ArrayList<Simbolo> listaPar = new ArrayList<>();
    //HashMap<String,Simbolo> tabela;
    ArrayList<TabelaDeSimbolos> tabelas = new ArrayList<>();

    public Semantico(boolean checarSemantica) {
        this.checarSemantica = checarSemantica;
    }

    public void executeAction(int action, Token token) throws SemanticError {

        if (checarSemantica) {

            System.out.println("Ação #" + action + ", Token: " + token);
            String lexeme = token.getLexeme();
            this.posicao = token.getPosition();
            switch (action) {
                default:
                    break;
                case 101:
                    nivelAtual = 0;
                    deslocamento = 0;
                    nomeDoPrograma = lexeme;
                    tabelas.add(new TabelaDeSimbolos(0));
                    break;

                case 102:
                    contextoLID = l_decl;
                    break;

                case 103:
                    break;

                case 104:
                    for (Simbolo s : LID) {
                        s.putAtributo(a_categoria, categoriaAtual);
                        s.putAtributo(a_subcateg, subcategoria);
                        s.putAtributo(a_tipovar, tipoAtual);
                    }
                    if (subcategoria.equals(s_vetor)) {
                        for (Simbolo s : LID) {
                            ArrayList<Simbolo> elementos = new ArrayList<>();
                            for (int n = 1; n <= numElementos; n++) {
                                Simbolo simbolo = createSimbolo((String) s.getAtributo(a_nome), (Integer) s.getAtributo(a_nivel));
                                elementos.add(simbolo);
                            }
                            s.putAtributo(a_numElem, numElementos);
                        }
                    }
                    if (subcategoria.equals(s_cadeia)) {
                        for (Simbolo s : LID) {
                            s.putAtributo(a_numElem, numElementos);
                        }
                    }
                    if (categoriaAtual.equals(c_constante)) {
                        for (Simbolo s : LID) {
                            s.putAtributo(a_valor, valConst);
                        }
                    }

                    for (Simbolo s : LID) {
                    	if(tabelas.get(nivelAtual).containsKey((String) s.getAtributo(a_nome))){
                    		throw new SemanticError("Ids s� podem ser declarados uma vez", posicao);
                    	}
                        tabelas.get(nivelAtual).put((String) s.getAtributo(a_nome), s);
                    }
                    LID.clear();
                    break;

                case 105:
                    tipoAtual = t_inteiro;
                    break;

                case 106:
                    tipoAtual = t_real;
                    break;

                case 107:
                    tipoAtual = t_booleano;
                    break;

                case 108:
                    tipoAtual = t_caracter;
                    break;

                case 109:
                    if (tipoConst != t_inteiro) {
                        throw new SemanticError("Esperava-se uma constante inteira", posicao);
                    } else if (Integer.parseInt((String) valConst) > 256) {
                        throw new SemanticError("Cadeia maior que o permitido", posicao);
                    } else {
                        tipoAtual = t_cadeia;
                    }
                    break;

                case 110:
                    if (comparaTipos(tipoAtual, t_cadeia)) {
                        throw new SemanticError("Vetor do tipo cadeia não é permitido", posicao);
                    } else {
                        subcategoria = s_vetor;
                    }
                    break;

                case 111:
                    if (tipoConst != t_inteiro) {
                        throw new SemanticError("A dimensao deve ser uma constante inteira", posicao);
                    } else {
                        numElementos = Integer.parseInt((String) valConst);
                    }
                    break;

                case 112:
                    if (comparaTipos(tipoAtual, t_cadeia)) {
                        subcategoria = s_cadeia;
                    } else {
                        subcategoria = s_predef;
                    }
                    break;

                case 113:
                    if (contextoLID.equals(l_leitura)) {
                        if (checkDeclId(lexeme, nivelAtual, contextoLID)) {
                            if ((getSimbolo(lexeme).getAtributo(a_categoria).equals(c_variavel))
                                    || getSimbolo(lexeme).getAtributo(a_categoria).equals(c_parametro)
                                    && (!getSimbolo(lexeme).getAtributo(a_tipovar).equals(t_booleano))) {
                                //Gera cod para leitura
                            } else {
                                throw new SemanticError("Tipo invalido para leitura", posicao);
                            }
                        }
                    } else {
                        addLID(lexeme, nivelAtual, contextoLID);
                    }
                    break;

                case 114:
                    if (subcategoria.equals(s_cadeia) || subcategoria.equals(s_vetor)) {
                        throw new SemanticError("Apenas id's de tipo pre-definido podem ser declarados como constante", posicao);
                    } else {
                        categoriaAtual = c_constante;
                    }
                    break;

                case 115:
                    if (!comparaTipos(tipoAtual, tipoConst)) {
                        throw new SemanticError("Tipo da constante incorreto", posicao);
                    }
                    break;

                case 116:
                    categoriaAtual = c_variavel;
                    break;

                case 117:
                    if (!checkDeclId(lexeme, nivelAtual, l_decl)) {
                        Simbolo met = addSimbolo(lexeme, nivelAtual, contextoLID);
                        met.putAtributo(a_categoria, c_metodo);
                        metodoAtual = lexeme;
                        numParamFormais = 0;
                        nivelAtual++;
                        tabelas.add(new TabelaDeSimbolos(nivelAtual));
                    }
                    break;

                case 118:
                    getSimbolo(metodoAtual).putAtributo(a_listaParam, listaPar.clone());
                    listaPar = new ArrayList<>();
                    getSimbolo(metodoAtual).putAtributo(a_nparam, numParamFormais);
                    break;

                case 119:
                    break;

                case 120:
                	if ((Integer) getSimbolo(metodoAtual).getAtributo(a_tipovar) != t_nulo) {
                		if(!retorneUsado) {
                			 throw new SemanticError("Metodo com tipo precisa de retorno", posicao);
                		}
                	}
                	else {
                    tabelas.remove(nivelAtual);
                    nivelAtual--;
                	}

                case 121:
                    contextoLID = l_parformal;
                    break;

                case 122:
                    break;

                case 123:
                    if (tipoAtual != t_cadeia) {
                        for (Simbolo s : LID) {
                            s.putAtributo(a_categoria, c_parametro);
                            s.putAtributo(a_MPP, MPP);
                            s.putAtributo(a_tipovar, tipoAtual);
                            listaPar.add(s);
                            tabelas.get(nivelAtual).put((String) s.getAtributo(a_nome), s);
                            numParamFormais++;
                        }
                        LID.clear();
                    } else {
                        throw new SemanticError("Parametros devem ser de tipo pre-definido", posicao);
                    }
                    break;

                case 124:
                    if (tipoAtual != t_cadeia) {
                        getSimbolo(metodoAtual).putAtributo(a_tipovar, tipoAtual);
                        metTemTipo = true;
                    } else {
                        throw new SemanticError("Metodos devem ser de tipo predefinido", posicao);
                    }
                    break;

                case 125:
                    getSimbolo(metodoAtual).putAtributo(a_tipovar, t_nulo);
                    break;

                case 126:
                    MPP = m_ref;
                    break;

                case 127:
                    MPP = m_val;
                    break;

                case 128:
                    if (checkDeclId(lexeme, nivelAtual, l_leitura)) {
                        System.out.println("chega aqui");
                        idAtual = lexeme;
                    }
                    break;

                case 129:
                    if (tipoExpr == t_booleano || tipoExpr == t_inteiro) {
                        //gera codigo
                    } else {
                        throw new SemanticError("Tipo invalido da expressao", posicao);
                    }
                    break;

                case 130:
                    contextoLID = l_leitura;
                    break;

                case 131:
                    contextoEXPR = e_impr;
                    break;

                case 132:
                	
                    if (metodoAtual != null) {
                        if ((Integer) getSimbolo(metodoAtual).getAtributo(a_tipovar) != t_nulo) {
                            if (tipoExpr != (Integer) getSimbolo(metodoAtual).getAtributo(a_tipovar)) {
                                throw new SemanticError("Tipo de retorno Invalido", posicao);
                            
                            }
                        } else {
                            throw new SemanticError("Retorne so pode ser usado em metodo com tipo", posicao);
                        }
                    } else {
                        throw new SemanticError("Retorne so pode ser usado em metodo com tipo", posicao);
                    }
                    retorneUsado = true;
                    break;

                case 133:
                    if (getSimbolo(idAtual).getAtributo(a_categoria).equals(c_variavel)
                            || getSimbolo(idAtual).getAtributo(a_categoria).equals(c_parametro)) {
                        if (getSimbolo(idAtual).getAtributo(a_tipovar) != s_vetor) {
                            tipoLadoEsq = (Integer) getSimbolo(idAtual).getAtributo(a_tipovar);
                        } else {
                            throw new SemanticError("Identificador deveria estar indexado.", posicao);
                        }
                    } else {
                        throw new SemanticError("identificador deveria ser variavel ou parametro", posicao);
                    }
                    break;

                case 134:
                    if (comparaTipos(tipoLadoEsq, tipoExpr)) {
                        // Gera codigo
                    } else {
                        throw new SemanticError("Tipos incompativeis", posicao);
                    }
                    break;

                case 135:
                    if (getSimbolo(idAtual).getAtributo(a_categoria).equals(c_variavel)) {
                        if (!getSimbolo(idAtual).getAtributo(a_subcateg).equals(s_predef)) {
                            subCategVarInd = (String) getSimbolo(idAtual).getAtributo(a_subcateg);
                            tipoVetor = (Integer) getSimbolo(idAtual).getAtributo(a_tipovar);
                        } else {
                            throw new SemanticError("Apenas vetores e cadeias podem ser indexados", posicao);
                        }
                    } else {
                        throw new SemanticError("esperava-se uma variavel", posicao);
                    }
                    break;

                case 136:
                    if (tipoExpr == t_inteiro) {
                        if (subCategVarInd.equals(s_cadeia)) {
                            tipoLadoEsq = t_caracter;
                        } else {
                            tipoLadoEsq = tipoVetor;
                        }
                    } else {
                        throw new SemanticError("Indice deveria ser inteiro", posicao);
                    }
                    break;

                case 137:
                    if (getSimbolo(idAtual).getAtributo(a_categoria).equals(c_metodo)) {
                        if (!getSimbolo(idAtual).getAtributo(a_tipovar).equals(t_nulo)) {
                            throw new SemanticError("Esperava-se metodo sem tipo", posicao);
                        } else {
                            //gera codigo
                        }
                    } else {
                        throw new SemanticError("Id deveria ser de metodo", posicao);
                    }
                    break;

                case 138:
                    numParamAtuais = 0;
                    contextoEXPR = e_par;
                    break;

                case 139:
                    if (numParamAtuais == numParamFormais) {
                        //Gera codigo
                    } else {
                        throw new SemanticError("Erro na quantidade de parametros", posicao);
                    }
                    break;

                case 140:
                    if (getSimbolo(idAtual).getAtributo(a_categoria).equals(c_metodo)) {
                        if (getSimbolo(idAtual).getAtributo(a_tipovar).equals(t_nulo)) {
                            if (numParamAtuais == 0) {
                                //gera codigo
                            } else {
                                throw new SemanticError("Erro na quantidade de parametros", posicao);
                            }
                        } else {
                            throw new SemanticError("Esperava-se metodo sem tipo", posicao);
                        }
                    } else {
                        throw new SemanticError("Id deveria ser de metodo", posicao);
                    }
                    break;

                case 141:
                    if (contextoEXPR.equals(e_par)) {
                        numParamAtuais++;
                        ArrayList<Simbolo> listaParam = (ArrayList<Simbolo>) getSimbolo(metodoAtual).getAtributo(a_listaParam);
                        if (MPP.equals(listaParam.get(numParamAtuais - 1).getAtributo(a_MPP))) {
                            if (!comparaTipos(tipoExpr, (Integer) listaParam.get(numParamAtuais - 1).getAtributo(a_tipovar))) {
                                throw new SemanticError("Tipo de expressão diferente do esperado", posicao);
                            }
                        } else {
                            throw new SemanticError("Metodo de passagem de parametro diferente do esperado", posicao);
                        }
                    } else if (contextoEXPR.equals(e_impr)) {
                        if (tipoExpr == t_booleano) {
                            throw new SemanticError("Tipo invalido para impressao", posicao);
                        } else {
                            //gera cod
                        }
                    }
                    break;

                case 142:
                    tipoExpr = tipoExprSimples;
                    break;

                case 143:
                    if (comparaTipos(tipoExpr, tipoExprSimples)) {
                        tipoExpr = t_booleano;
                    } else {
                        throw new SemanticError("Operandos incompativeis", posicao);
                    }
                    break;

                case 144:
                case 145:
                case 146:
                case 147:
                case 148:
                case 149:
                    operador = lexeme;
                    break;

                case 150:
                    tipoExprSimples = tipoTermo;
                    break;

                case 151:
                    if (tipoExprSimples == t_inteiro
                            || tipoExprSimples == t_real) {
                        if (operador.equals("ou")) {
                            throw new SemanticError("Operador e operando incompativeis", posicao);
                        }
                    } else if (tipoExprSimples == t_booleano) {
                        if (!operador.equals("ou")) {
                            throw new SemanticError("Operador e operando incompativeis", posicao);
                        }
                    }
                    break;

                case 152:
                    if (getTipoResultadoExp(tipoTermo, tipoExprSimples) == -1) {
                        throw new SemanticError("Operandos incompativeis", posicao);
                    } else {
                        tipoExprSimples = getTipoResultadoExp(tipoTermo, tipoExprSimples);
                    }
                    break;

                case 153:
                case 154:
                case 155:    
                    operador = lexeme;
                    break;

                case 156:
                    tipoTermo = tipoFator;
                    break;

                case 157:
                    if (operador.equals("div")) {
                        if (tipoTermo != t_inteiro || tipoLadoEsq != t_inteiro) {
                            throw new SemanticError("Operador e operando incompativeis", posicao);
                        }
                    } else if (operador.equals("e")) {
                        if (tipoTermo != t_booleano) {
                            throw new SemanticError("Operador e operando incompativeis", posicao);
                        }
                    } else {
                        if (tipoTermo != t_inteiro
                                && tipoTermo != t_real) {
                            throw new SemanticError("Operador e operando incompativeis", posicao);
                        }
                    }
                    break;

                case 158:
               
                    if (getTipoResultadoExp(tipoFator, tipoTermo) == -1) {
                        throw new SemanticError("Operandos incompativeis", posicao);
                    } else {
                         if(operador.equals("/")) {
                        	 tipoTermo = getTipoResultadoMultExp(tipoFator, tipoTermo);
                         }
                         else {
                        tipoTermo = getTipoResultadoExp(tipoFator, tipoTermo);
                         }
                         }
                    break;

                case 159:
                case 160:
                case 161:
                case 162:    
                    operador = lexeme;
                    break;

                case 163:
                    if (opNega) {
                        throw new SemanticError("Operador 'nao' repetido nao pode!", posicao);
                    } else {
                        opNega = true;
                    }
                    break;

                case 164:
                    if (tipoFator != t_booleano) {
                        throw new SemanticError("Operador 'nao' exige operando booleano", posicao);
                    } else {
                        opNega = false;
                    }
                    break;

                case 165:
                    if (opUnario || operador.equals("-")) {
                        throw new SemanticError("Operador 'unario' repetido", posicao);
                    } else {
                        opUnario = true;
                    }
                    break;

                case 166:
                    if (tipoFator != t_inteiro && tipoFator != t_real) {
                        throw new SemanticError("Operador unario exige operando numero", posicao);
                    } else {
                        opUnario = false;
                    }
                    break;

                case 167:
                    opNega = false;
                    opUnario = false;
                    break;

                case 168:
                    tipoFator = tipoExpr;
                    break;

                case 169:
                    
                    tipoFator = tipoAtual;
                    break;

                case 170:
                    tipoFator = tipoConst;
                    break;

                case 171:
                    if (getSimbolo(idAtual).getAtributo(a_categoria).equals(c_metodo)) {
                        if (!getSimbolo(idAtual).getAtributo(a_tipovar).equals(t_nulo)) {
                            numParamAtuais = 0;
                            contextoEXPR = e_par;
                            
                        } else {
                            throw new SemanticError("Esperava-se metodo com tipo", posicao);
                        }
                    } else {
                        throw new SemanticError("Identificador deveria ser de metodo", posicao);
                    }
                    break;

                case 172:
                    if (numParamAtuais == numParamFormais) {
                        tipoAtual = (Integer) getSimbolo(idAtual).getAtributo(a_tipovar);
                    } else {
                        throw new SemanticError("Erro na quantidade de parametros", posicao);
                    }
                    break;

                case 173:
                    if (tipoExpr == t_inteiro) {
                        if (subCategVarInd == s_cadeia) {
                            tipoVetor = t_caracter;
                        } else {
                            tipoVetor = (Integer) getSimbolo(idAtual).getAtributo(a_tipovar);
                        }
                    }
                    break;

                case 174:
                    System.out.println("idAtual é: " + idAtual);
                    if (getSimbolo(idAtual).getAtributo(a_categoria).equals(c_variavel)
                            || getSimbolo(idAtual).getAtributo(a_categoria).equals(c_parametro)) {
                        if (!getSimbolo(idAtual).getAtributo(a_subcateg).equals(s_vetor)) {
                            
                            tipoAtual = (Integer) getSimbolo(idAtual).getAtributo(a_tipovar);
                        } else {
                            throw new SemanticError("Vetor deve ser indexado", posicao);
                        }
                    } else if (getSimbolo(idAtual).getAtributo(a_categoria).equals(c_metodo)) {
                        if (!getSimbolo(idAtual).getAtributo(a_tipovar).equals(t_nulo)) {
                            if ((Integer)   getSimbolo(idAtual).getAtributo(a_nparam) == 0) {
                                tipoAtual = (Integer) getSimbolo(idAtual).getAtributo(a_tipovar);
                                //gera codigo
                            } else {
                                throw new SemanticError("Erro na quantidade de parametros", posicao);
                            }
                        } else {
                            throw new SemanticError("Esperava-se metodo com tipo", posicao);
                        }
                    } else if (getSimbolo(idAtual).getAtributo(a_categoria).equals(c_constante)) {
                        tipoAtual = tipoConst;
                    } else {
                        throw new SemanticError("Esperava-se variavel, identificador de metodo ou constante", posicao);
                    }
                    break;

                case 175:
                    if (!getSimbolo(lexeme).getAtributo(a_categoria).equals(c_constante)) {
                        throw new SemanticError("id de Constante esperado", posicao);
                    } else {
                        tipoConst = (Integer) getSimbolo(lexeme).getAtributo(a_tipovar);
                    }
                    break;

                case 176:
                    tipoConst = t_inteiro;
                    valConst = lexeme;
                    MPP = m_val;
                    break;

                case 177:
                    tipoConst = t_real;
                    valConst = lexeme;
                    MPP = m_val;
                    break;

                case 178:
                    tipoConst = t_booleano;
                    valConst = lexeme;
                    MPP = m_val;
                    break;

                case 179:
                    tipoConst = t_booleano;
                    valConst = lexeme;
                    MPP = m_val;
                    break;

                case 180:
                    tipoConst = t_cadeia;
                    valConst = lexeme;
                    MPP = m_val;
                    break;
            }
        } else {
            //nao faz nada
        }
    }

    Simbolo addSimbolo(String nome, int nivel, String contexto) throws SemanticError {
        if (!checkDeclId(nome, nivel, contexto)) {
            Simbolo simbolo = createSimbolo(nome, nivel);
            tabelas.get(nivel).put(nome, simbolo);
            return simbolo;
        }
        return null;
    }

    Simbolo getSimbolo(String nome) throws SemanticError {
        for (int nivel = nivelAtual; nivel >= 0; nivel--) {
            System.out.println("getSimbolo: "+ nome + " " + tabelas.get(nivel).containsKey(nome));
                if (tabelas.get(nivel).containsKey(nome)) {
                    return tabelas.get(nivel).get(nome);
                }
        }
        throw new SemanticError("Id não declarado", posicao);
    }
    
    boolean checkIfDecl(String nome){
        for (int nivel = nivelAtual; nivel >= 0; nivel--) {
            System.out.println("checkIfDecl: " + nome + " " + tabelas.get(nivel).containsKey(nome));
                    if (tabelas.get(nivel).containsKey(nome)) {
                    return true;
                }
        }
        return false;
    }

    void addLID(String nome, int nivel, String contexto) throws SemanticError {
        if (!checkDeclId(nome, nivel, contexto)) {
            LID.add(createSimbolo(nome, nivel));
        }
    }

    boolean checkDeclId(String nome, int nivel, String contexto) throws SemanticError {
        if (nome.equals(nomeDoPrograma)) {
            throw new SemanticError("Nenhum identificador pode ter o mesmo nome que o programa", posicao);
        }
        
        if (contexto.equals(l_decl)) {
            if (tabelas.get(nivel).containsKey(nome)) {
                throw new SemanticError("Id ja declarado", posicao);
            } else {
                return false;
            }
        }
        else if (contexto.equals(l_parformal)) {
            if(tabelas.get(nivel).containsKey(nome)){ 
                throw new SemanticError("Id de parametro repetido", posicao);
            } else {
                return false;
            }
        }
        else if (contexto.equals(l_leitura)) {
            if(!checkIfDecl(nome)){
                throw new SemanticError("Id nao declarado", posicao);
            }
        }
        return true;
    }

    private Simbolo createSimbolo(String nome, int nivel) {
        Simbolo simbolo = new Simbolo(nome, nivel);
        simbolo.putAtributo(a_nivel, nivel);
        return simbolo;
    }

    private boolean comparaTipos(int esquerdo, int direito) {
        switch (esquerdo) {
            case t_real:
                if (direito == t_inteiro) {
                    return true;
                } else {
                    return direito == t_real;
                }

            case t_cadeia:
                if (direito == t_caracter) {
                    return true;
                } else {
                    return direito == t_cadeia;
                }

            default:
                return esquerdo == direito;
        }
    }
    private int getTipoResultadoMultExp(int a, int b) {
        if ((a == t_real && b == t_inteiro)
                || b == t_real && a == t_inteiro) {
            return t_real;
        } else if (a == b) {
        	if(a ==t_inteiro) {
        		return t_real;
        	}
        	else {
            return a;
        	}
        } else {
            return -1;
        }
    }
    
    private int getTipoResultadoExp(int a, int b) {
        if ((a == t_real && b == t_inteiro)
                || b == t_real && a == t_inteiro ) {
            return t_real;
        } else if (a == b) {
            return a;
        } else {
            return -1;
        }
    }

}
