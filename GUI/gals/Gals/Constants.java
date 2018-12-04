 package Gals;

public interface Constants extends ScannerConstants, ParserConstants
{
    int EPSILON  = 0;
    int DOLLAR   = 1;

    int t_id = 2;
    int t_literal = 3;
    int t_num_int = 4;
    int t_num_real = 5;
    int t_TOKEN_6 = 6; //";"
    int t_TOKEN_7 = 7; //","
    int t_TOKEN_8 = 8; //"."
    int t_TOKEN_9 = 9; //">"
    int t_TOKEN_10 = 10; //"<"
    int t_TOKEN_11 = 11; //"="
    int t_TOKEN_12 = 12; //"("
    int t_TOKEN_13 = 13; //")"
    int t_TOKEN_14 = 14; //"["
    int t_TOKEN_15 = 15; //"]"
    int t_TOKEN_16 = 16; //"+"
    int t_TOKEN_17 = 17; //"-"
    int t_TOKEN_18 = 18; //"*"
    int t_TOKEN_19 = 19; //"/"
    int t_TOKEN_20 = 20; //":"
    int t_TOKEN_21 = 21; //"}"
    int t_TOKEN_22 = 22; //"{"
    int t_TOKEN_23 = 23; //":="
    int t_TOKEN_24 = 24; //"<>"
    int t_TOKEN_25 = 25; //"<="
    int t_TOKEN_26 = 26; //">="
    int t_programa = 27;
    int t_inteiro = 28;
    int t_real = 29;
    int t_booleano = 30;
    int t_caracter = 31;
    int t_cadeia = 32;
    int t_metodo = 33;
    int t_ref = 34;
    int t_val = 35;
    int t_se = 36;
    int t_entao = 37;
    int t_enquanto = 38;
    int t_faca = 39;
    int t_leia = 40;
    int t_escreva = 41;
    int t_retorne = 42;
    int t_senao = 43;
    int t_ou = 44;
    int t_div = 45;
    int t_e = 46;
    int t_nao = 47;
    int t_falso = 48;
    int t_verdadeiro = 49;
    
    //atributos
    String a_nome = "nome";
    String a_tipovar = "tipoVar";
    String a_categoria = "categoria";
    String a_nivel = "nivel";
    String a_valor = "valor";
    String a_desloc = "deslocamento";
    String a_numElem = "numeroDeElementos";
    String a_elementos = "elementos";
    String a_subcateg = "subCategoria";
    String a_endereco = "endereco";
    String a_nparam = "nroParametros";
    String a_pontparam = "ponteiroParametro";
    String a_tipores = "tipoResultadoFuncao";
    String a_mecpass = "mecanismoPassagem";
    
    //contextoLID
    String l_decl = "decl";
    String l_parformal = "par-formal";
    String l_leitura = "leitura";
    
    //contextoEXPR
    String e_impr = "impressao";
    String e_par = "par-atual";
    
    //categorias
    String c_programa = "programa";
    String c_constante = "constante";
    String c_variavel = "variavel";
    String c_metodo = "metodo";
    String c_parametro = "parametro";

    //MPP
    String m_ref = "referencia";
    String m_val = "valor";
    
    //subcategorias
    String s_vetor = "vetor";
    String s_cadeia = "cadeia";
    String s_predef = "preDefinido";
}
