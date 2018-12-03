package Gals;

public class Semantico implements Constants
{
    int nivelAtual;
    int deslocamento;
    int tipoAtual;
    int tipoLadoEsq;
    int tipoVarInd;
    int tipoConst;
    int tipoExpr;
    int numParamFormais;
    int numParamAtuais;
    
    
    boolean metTemTipo;
    boolean opNega;
    boolean opUnario;
    
    String categoriaAtual;
    String contextoLID;
    String contextoEXPR;
    List<Simbolo> listaPar;
    TabelaDeSimbolos tabela;
    
    public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("Ação #"+action+", Token: "+token);
    }	
}
