package Gals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Semantico implements Constants {

    boolean checarSemantica;

    int nivelAtual;
    int deslocamento;
    int tipoAtual;
    int tipoLadoEsq;
    int tipoVarInd;
    int tipoConst;
    int tipoExpr;
    int numParamFormais;
    int numParamAtuais;
    int numElementos;

    Object valConst;
    String metodoAtual;

    boolean metTemTipo;
    boolean opNega;
    boolean opUnario;

    String nomeDoPrograma;
    String categoriaAtual;
    String subcategoria;
    String contextoLID;
    String contextoEXPR;
    String MPP;
    ArrayList<Simbolo> LID = new ArrayList<>();
    //HashMap<String,Simbolo> tabela;
    ArrayList<TabelaDeSimbolos> tabelas = new ArrayList<>();

    public Semantico(boolean checarSemantica) {
        this.checarSemantica = checarSemantica;
    }

    public void executeAction(int action, Token token) throws SemanticError {

        if (checarSemantica) {

            System.out.println("Ação #" + action + ", Token: " + token);
            String lexeme = token.getLexeme();
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
                    if(subcategoria.equals(s_vetor)){
                        for(Simbolo s : LID){
                            ArrayList<Simbolo> elementos = new ArrayList<>();
                            for (int n = 1; n <= numElementos; n++) {
                                Simbolo simbolo = createSimbolo((String) s.getAtributo(a_nome),(Integer) s.getAtributo(a_nivel));
                                elementos.add(simbolo);
                            }
                            s.putAtributo(a_numElem, numElementos);
                        }
                    }
                    if(subcategoria.equals(s_cadeia)){
                        for(Simbolo s : LID){
                            s.putAtributo(a_numElem, numElementos);
                        }
                    }
                    if(categoriaAtual.equals(c_constante)){
                        for(Simbolo s : LID){
                            s.putAtributo(a_valor, valConst);
                        }
                    }
                    
                    for(Simbolo s: LID){
                        tabelas.get(nivelAtual).put(lexeme, s);
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
                        throw new SemanticError("Esperava-se uma constante inteira");
                    } else if (Integer.parseInt((String) valConst) > 256) {
                        throw new SemanticError("Cadeia maior que o permitido");
                    } else {
                        tipoAtual = t_cadeia;
                    }
                    break;

                case 110:
                    if (tipoAtual == t_cadeia) {
                        throw new SemanticError("Vetor do tipo cadeia não é permitido");
                    } else {
                        subcategoria = s_vetor;
                    }
                    break;

                case 111:
                    if (tipoConst != t_inteiro) {
                        throw new SemanticError("A dimensao deve ser uma constante inteira");
                    } else {
                        numElementos = Integer.parseInt((String) valConst);
                    }
                    break;

                case 112:
                    if (tipoAtual == t_cadeia) {
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
                                throw new SemanticError("Tipo invalido para leitura");
                            }
                        }
                    } else {
                        addLID(lexeme, nivelAtual, contextoLID);
                    }
                    break;

                case 114:
                    if (subcategoria.equals(s_cadeia) || subcategoria.equals(s_vetor)) {
                        throw new SemanticError("Apenas id's de tipo pre-definido podem ser declarados como constante");
                    } else {
                        categoriaAtual = c_constante;
                    }
                    break;

                case 115:
                    if (tipoConst != tipoAtual) {
                        throw new SemanticError("Tipo da constante incorreto");
                    }
                    break;

                case 116:
                    categoriaAtual = c_variavel;
                    break;
                    
                case 117:
                    if(!checkDeclId(lexeme, nivelAtual, contextoLID)){
                        Simbolo met = addSimbolo(lexeme, nivelAtual, contextoLID);
                        met.putAtributo(a_categoria, c_metodo);
                        metodoAtual = lexeme;
                        numParamFormais = 0;
                        nivelAtual++;
                    }
                    break;
                    
                case 118:
                    getSimbolo(metodoAtual).putAtributo(a_nparam, numParamFormais);
                    break;
                
                case 119: 
                    break;
               
                case 120:
                    tabelas.remove(nivelAtual);
                    nivelAtual--;
                    
                case 121:
                    contextoLID = l_parformal;
                    break;
                 
                case 122:
                    break;
                    
                case 123:
                    if(subcategoria.equals(s_predef)){
                        ArrayList<Simbolo> params = new ArrayList<>();
                        getSimbolo(metodoAtual).putAtributo(a_listaParam, params);
                        for(Simbolo s : LID){
                            s.putAtributo(a_categoria, c_parametro);
                            s.putAtributo(a_MPP, MPP);
                            s.putAtributo(a_tipovar, tipoAtual);
                            params.add(s);
                        }
                    }
                    else{
                        throw new SemanticError("Parametros devem ser de tipo pre-definido");
                    }
                    break;
                    
                case 124:
                    if(tipoAtual != t_cadeia){
                        getSimbolo(metodoAtual).putAtributo(a_tipovar, tipoAtual);
                    }
                    else{
                        throw new SemanticError("Metodos devem ser de tipo predefinido");
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
                
                case 175:
                    if (!getSimbolo(lexeme).getAtributo(a_categoria).equals(c_constante)) {
                        throw new SemanticError("id de Constante esperado");
                    } else {
                        tipoConst = (Integer) getSimbolo(lexeme).getAtributo(a_tipovar);
                    }
                    break;

                case 176:
                    tipoConst = t_inteiro;
                    valConst = lexeme;
                    break;

                case 177:
                    tipoConst = t_real;
                    valConst = lexeme;
                    break;

                case 178:
                    tipoConst = t_booleano;
                    valConst = lexeme;
                    break;

                case 179:
                    tipoConst = t_booleano;
                    valConst = lexeme;
                    break;

                case 180:
                    tipoConst = t_cadeia;
                    valConst = lexeme;
                    break;
            }
        }
        else{
            //nao faz nada
        }
    }

    Simbolo addSimbolo(String nome, int nivel, String contexto) throws SemanticError {
        if (nivel >= tabelas.size()) {
            tabelas.add(new TabelaDeSimbolos(nivel));
        } else if (checkDeclId(nome, nivel, contexto)) {
            //throws exception no checkDeclId Id ja existe
        }
        return createSimbolo(nome, nivel);
    }

    Simbolo getSimbolo(String nome) throws SemanticError {
        for (int nivel = nivelAtual; nivel >= 0; nivel--) {
            if (tabelas.get(nivel).containsKey(nome)) {
                return tabelas.get(nivel).get(nome);
            }
        }
        throw new SemanticError("Id não declarado");
    }

    void addLID(String nome, int nivel, String contexto) throws SemanticError {
        if (!checkDeclId(nome, nivel, contexto)) {
            LID.add(createSimbolo(nome, nivel));
            if (contexto.equals(l_parformal)) {
                numParamFormais++;
            }
        }
    }

    boolean checkDeclId(String nome, int nivel, String contexto) throws SemanticError {
        if (nome.equals(nomeDoPrograma)) {
            throw new SemanticError("Nenhum identificador pode ter o mesmo nome que o programa");
        }
        if (tabelas.get(nivel).containsKey(nome)) {
            if (contexto.equals(l_decl)) {
                throw new SemanticError("Id ja declarado");
            } else if (contexto.equals(l_parformal)) {
                throw new SemanticError("Id de parametro repetido");
            } else {
                return true;
            }
        } else {
            if (contexto.equals(l_leitura)) {
                throw new SemanticError("Id nao declarado");
            }
            return false;
        }
    }

    private Simbolo createSimbolo(String nome, int nivel) {
        Simbolo simbolo = new Simbolo(nome, nivel);
        simbolo.putAtributo(a_nivel, nivel);
        tabelas.get(nivel).put(nome, simbolo);
        return simbolo;
    }
}
