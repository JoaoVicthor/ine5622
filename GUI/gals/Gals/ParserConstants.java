package Gals;

public interface ParserConstants
{
    int START_SYMBOL = 52;

    int FIRST_NON_TERMINAL    = 52;
    int FIRST_SEMANTIC_ACTION = 86;

    int[][] PARSER_TABLE =
    {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  1, -1, -1, -1, -1, -1, -1,  1,  1, -1,  1,  1,  1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 30, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 32, -1, 33, -1, 34, 35, 36, 37, -1, -1, -1, -1, -1, -1 },
        { -1, 77, 78, 78, 78, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 78, 78 },
        { -1, -1, 83, 79, 80, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 81, 82 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 17, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  3, -1, -1, -1, -1, -1, -1,  2,  2, -1,  2,  2,  2,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 47, 47, 47, 47, -1, -1, -1, -1, -1, -1, 47, -1, -1, -1, -1, 47, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 47, 47, 47 },
        { -1, 56, 56, 56, 56, -1, -1, -1, -1, -1, -1, 56, -1, -1, -1, -1, 56, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 56, 56, 56 },
        { -1, 72, 73, 73, 73, -1, -1, -1, -1, -1, -1, 71, -1, -1, -1, -1, 70, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 69, 73, 73 },
        { -1, -1, -1, -1, -1, 15, -1, -1, -1, -1, 14, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 44, 44, 44, 44, -1, -1, -1, -1, -1, -1, 44, -1, -1, -1, -1, 44, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, 44, 44 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 25, 26, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 59, 60, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 61, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 65, 66, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 67, 68, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, 52, 51, 50, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 55, 54, 53, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, 43, -1, -1, -1, -1, -1, 42, -1, 41, -1, -1, -1, -1, -1, -1, 43, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, 58, 58, -1, 58, 58, 58, -1, 58, -1, 58, 57, 57, -1, -1, -1, 58, -1, -1, -1, 58, 58, 58, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 58, -1, 58, -1, -1, -1, 58, 57, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 45, -1, -1, -1, -1, -1, 46, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, 13, 12, -1, -1, -1, 13, -1, 13, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, 64, 64, -1, 64, 64, 64, -1, 64, -1, 64, 64, 64, 63, 63, -1, 64, -1, -1, -1, 64, 64, 64, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 64, -1, 64, -1, -1, -1, 64, 64, 63, 63, -1, -1, -1 },
        { -1, -1, -1, -1, -1, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 29, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, 49, 49, -1, 48, 48, 48, -1, 49, -1, 49, -1, -1, -1, -1, -1, 49, -1, -1, -1, 48, 48, 48, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 49, -1, 49, -1, -1, -1, 49, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, 76, 76, -1, 76, 76, 76, 74, 76, 75, 76, 76, 76, 76, 76, -1, 76, -1, -1, -1, 76, 76, 76, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 76, -1, 76, -1, -1, -1, 76, 76, 76, 76, -1, -1, -1 },
        { -1, -1, -1, -1, -1, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1 },
        { -1, 62, 62, 62, 62, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, -1, 62, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, 62, 62 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  4,  5, -1,  6,  7,  8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
    };

    int[][] PRODUCTIONS = 
    {
        { 28,  2,  6, 53,  8 },
        { 60, 59, 54 },
        { 84, 61, 66, 65,  6, 60 },
        {  0 },
        { 29 },
        { 30 },
        { 32 },
        { 33 },
        { 34, 14, 56, 15 },
        { 14, 56, 15 },
        {  0 },
        {  2, 76 },
        {  7, 66 },
        {  0 },
        { 11, 56 },
        {  0 },
        { 58,  6, 59 },
        {  0 },
        { 35,  2, 72, 85,  6, 53 },
        { 12, 68, 66, 20, 84, 77, 13 },
        {  0 },
        {  6, 68, 66, 20, 84, 77 },
        {  0 },
        { 20, 84 },
        {  0 },
        { 36 },
        { 37 },
        { 22, 55, 79, 21 },
        {  6, 55, 79 },
        {  0 },
        {  2, 73 },
        { 54 },
        { 38, 62, 39, 55, 82 },
        { 40, 62, 41, 55 },
        { 42, 12, 66, 13 },
        { 43, 12, 67, 13 },
        { 44, 62 },
        {  0 },
        { 45, 55 },
        {  0 },
        { 23, 62 },
        { 14, 62, 15, 23, 62 },
        { 12, 67, 13 },
        {  0 },
        { 62, 75 },
        {  7, 62, 75 },
        {  0 },
        { 63, 80 },
        { 71, 63 },
        {  0 },
        { 11 },
        { 10 },
        {  9 },
        { 27 },
        { 26 },
        { 25 },
        { 83, 74 },
        { 69, 83, 74 },
        {  0 },
        { 16 },
        { 17 },
        { 46 },
        { 64, 78 },
        { 70, 64, 78 },
        {  0 },
        { 18 },
        { 19 },
        { 47 },
        { 48 },
        { 49, 64 },
        { 17, 64 },
        { 12, 62, 13 },
        {  2, 81 },
        { 57 },
        { 12, 62, 75, 13 },
        { 14, 62, 15 },
        {  0 },
        {  2 },
        { 57 },
        {  4 },
        {  5 },
        { 50 },
        { 51 },
        {  3 }
    };

    String[] PARSER_ERROR =
       { "",
        "Era esperado o fim do programa",
        "Era esperado um identificador",
        "Era esperado literal",
        "Era esperado um numero inteiro",
        "Era esperado um numero real",
        "Era esperado \";\"",
        "Era esperado \",\"",
        "Era esperado \".\"",
        "Era esperado \">\"",
        "Era esperado \"<\"",
        "Era esperado \"=\"",
        "Era esperado \"(\"",
        "Era esperado \")\"",
        "Era esperado \"[\"",
        "Era esperado \"]\"",
        "Era esperado \"+\"",
        "Era esperado \"-\"",
        "Era esperado \"*\"",
        "Era esperado \"/\"",
        "Era esperado \":\"",
        "Era esperado \"}\"",
        "Era esperado \"{\"",
        "Era esperado \":=\"",
        "Era esperado \"..\"",
        "Era esperado \"<>\"",
        "Era esperado \"<=\"",
        "Era esperado \">=\"",
        "Era esperado programa",
        "Era esperado inteiro",
        "Era esperado real",
        "Era esperado const",
        "Era esperado booleano",
        "Era esperado caracter",
        "Era esperado cadeia",
        "Era esperado metodo",
        "Era esperado ref",
        "Era esperado val",
        "Era esperado se",
        "Era esperado entao",
        "Era esperado enquanto",
        "Era esperado faca",
        "Era esperado leia",
        "Era esperado escreva",
        "Era esperado retorne",
        "Era esperado senao",
        "Era esperado ou",
        "Era esperado div",
        "Era esperado e",
        "Era esperado nao",
        "Era esperado falso",
        "Era esperado verdadeiro",
        "Era esperado programa", //<programa>
        "Era esperado \"{\", inteiro, real, booleano, caracter, cadeia, metodo",//<bloco>
        "Era esperado \"{\"",//<com_composto>
        "Era esperado id, \"{\", se, enquanto, leia, escreva, retorne", //<comando>
        "Era esperado id, literal, um numero inteiro, um numero real, falso, verdadeiro", //<constante>
        "Era esperado literal, um numero inteiro, um numero real, falso, verdadeiro", //<constante_explicita>
        "Era esperado metodo", //<dcl_metodo>
        "Era esperado metodo", //<dcl_metodos> 
        "Era esperado inteiro, real, booleano, caracter, cadeia", //<dcl_var_const>
        "Era esperado \"[\"", //<dimensao>
        "Era esperado id, literal, um numero inteiro, um numero real, \"(\", \"-\", nao, falso, verdadeiro", //<expressao>
        "Era esperado id, literal, um numero inteiro, um numero real, \"(\", \"-\", nao, falso, verdadeiro", //<expsimp>
        "Era esperado id, literal, um numero inteiro, um numero real, \"(\", \"-\", nao, falso, verdadeiro", //<fator>
        "Era esperado \"=\"", //<fator_const>
        "Era esperado id", //<lid>
        "Era esperado id, literal, um numero inteiro, um numero real, \"(\", \"-\", nao, falso, verdadeiro", //<lista_expr>
        "Era esperado ref, val", //<mp_par>
        "Era esperado \"+\", \"-\", ou", //<op_add>
        "Era esperado \"*\", \"/\", div, e", //<op_mult>
        "Era esperado \">\", \"<\", \"=\", \"<>\", \"<=\", \">=\"", //<oprel>
        "Era esperado \"(\"", //<par_formais>
        "Era esperado \"(\", \"[\", \":=\"", //<rcomid>
        "Era esperado  \"+\", \"-\", ou",//<rep_expsimp>
        "Era esperado \",\"", //<rep_lexpr>
        "Era esperado \",\"", //<rep_lid>
        "Era esperado \";\"", //<rep_par>
        "Era esperado \"*\", \"/\", div, e", //<rep_termo>
        "Era esperado \";\"", //<replistacomando>
        "Era esperado \">\", \"<\", \"=\", \"<>\", \"<=\", \">=\"", //<resto_expressao> 
        "Era esperado \"(\", \"[\"", //<rvar>
        "Era esperado senao", //<senaoparte>
        "Era esperado id, literal, um numero inteiro, um numero real, \"(\", \"-\", nao, falso, verdadeiro", //<termo>
        "Era esperado inteiro, real, booleano, caracter, cadeia", //<tipo>
        "Era esperado \":\"" //<tipo_metodo>
    };
}
