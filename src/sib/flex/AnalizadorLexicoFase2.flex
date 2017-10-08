/* Sección de declaraciones de JFlex */
package sib.flex;

import sib.cup.*;

%%
// Clase pública
%public

%class AnalizadorLexicoFase2
%unicode
%column
%line
%cup

%{
 
 /* Código personalizado */
 
 // Se agregó una propiedad para verificar si existen tokens pendientes
	private boolean _existenTokens = false;

	public boolean existenTokens(){
		return this._existenTokens;
	}

	public int getLine() {
		return yyline;
	}

	public int getColumn() {
		return yycolumn;
	}

%}

/* Devolvemos objetos del tipo Token */
%type Token

%init{
 	/* Código que se ejecutará en el constructor de la clase */
%init}
 
%eof{
 
 /* Código a ejecutar al finalizar el análisis, en este caso cambiaremos el valor de una variable bandera */
 this._existenTokens = false;
 
%eof}

%yylexthrow Exception

/* Inicio de Expresiones regulares */

PalabraReservada = BEGIN | END | IF | ENDIF | ELSE | WHILE | ENDWHILE

Package = PACKAGE
Import = IMPORT

Tipo = int | float | frac | nfrac | string | step | clef | object | array | note | partiture

Punto = "."
Punto_y_coma = ";"

Simbolo = "*"|"+"|"-"|"/"|"#"|"@"|"b"|"("|")"|";"|"."|"="|","|"{"|"}"|"["|"]"|"<"|">"|"!"|"\""|"'"

Variable = "$"{Str_ident}

Operador = "_#"|"_##"|"_b"|"_bb"|"_@"|"_."|"_.."|"_..."

Step = A[#b]* | B[#b]* | C[#b]* | D[#b]* | E[#b]* | F[#b]* | G[#b]* | A[@]? | B[@]? | C[@]? | D[@]? | E[@]? | F[@]? | G[@]? | S

Digito = [0-9]
Numero = {Digito}{Digito}*
Letra = [A-Za-z]
Str_ident = {Letra}{Letra}*

SaltoDeLinea = \n|\r|\r\n
Espacio = [ \t\f]

//Package = PACKAGE{Espacio}{Palabra}("."{Palabra})*";"

//Import = IMPORT{Espacio}{Palabra}".sid;"

/* Finaliza expresiones regulares */
 
%%
/* Finaliza la sección de declaraciones de JFlex */
 
/* Inicia sección de reglas */
 
// Cada regla está formada por una {expresión} espacio {código}

// Terminales
/*
{Package}	{
	Token t = new Token( 0, 0, this.numLinea, 0, yytext(), "PACKAGE" );
	this._existenTokens = true;
	return t;
}
*/
/*
{Import}	{
	// No estoy seguro si el lexico debe aqui insersar el texto importado para procesarlo
	Token t = new Token( 0, 0, this.numLinea, 0, yytext(), "IMPORT" );
	this._existenTokens = true;
	return t;
}
*/

{PalabraReservada}	{
	Token t = new Token( sym.PALABRA_RESERVADA, yycolumn, yyline+1, -1, yytext(), Token.PALABRA_RESERVADA );
	this._existenTokens = true;
	return t;
}

{Package}	{
	Token t = new Token( sym.PACKAGE, yycolumn, yyline+1, -1, yytext(), Token.PALABRA_RESERVADA );
	this._existenTokens = true;
	return t;
}
{Import}	{
	Token t = new Token( sym.IMPORT, yycolumn, yyline+1, -1, yytext(), Token.PALABRA_RESERVADA );
	this._existenTokens = true;
	return t;
}

{Punto}	{
	Token t = new Token( sym.PUNTO, yycolumn, yyline+1, -1, yytext(), Token.PALABRA_RESERVADA );
	this._existenTokens = true;
	return t;
}
{Punto_y_coma}	{
	Token t = new Token( sym.PUNTO_Y_COMA, yycolumn, yyline+1, -1, yytext(), Token.PALABRA_RESERVADA );
	this._existenTokens = true;
	return t;
}

{Tipo}	{
	Token t = new Token( 0, yycolumn, yyline+1, 0, yytext(), Token.TIPO);
	this._existenTokens = true;
	return t;
}

{Step}	{
	Token t = new Token( 0, yycolumn, yyline+1, 0, yytext(), "STEP");
	this._existenTokens = true;
	return t;
}

{Simbolo}	{
	Token t = new Token( 0, yycolumn, yyline+1, 0, yytext(), "SIMBOLO");
	this._existenTokens = true;
	return t;
}

{Variable}	{
	Token t = new Token( 0, yycolumn, yyline+1, 0, yytext(), Token.VARIABLE );
	this._existenTokens = true;
	return t;
}

{Operador}	{
	Token t = new Token( 0, yycolumn, yyline+1, 0, yytext(), "OPERADOR");
	this._existenTokens = true;
	return t;
}

{Numero} {
	Token t = new Token( 0, yycolumn, yyline+1, 0, yytext(), "NUMERO" );
	this._existenTokens = true;
	return t;
}

{Str_ident} {
	Token t = new Token( sym.IDENTIFICADOR, yycolumn, yyline+1, 0, yytext(), Token.STR_IDENT );
	this._existenTokens = true;
	return t;
}

{Espacio} {
	// Ignorar cuando se ingrese un espacio
	//Token t = new Token( 0, yycolumn, yyline+1, 0, "Espacio", "ESPACIO");
	//this._existenTokens = true;
	//return t;
}

{SaltoDeLinea} {
	// Quizás este token no proceda y simplemente haya que limpiar los saltos
	//Token t = new Token( 0, yycolumn, yyline+1, 0, "Enter", "NUEVA_LINEA");
	//this._existenTokens = true;
	//return t;
}
// Todo lo demás ...
.	{ 
	//throw new Exception();
}
<<EOF>> { return new Token( sym.EOF, yycolumn, yyline+1, -1, yytext(), "FIN" ); }
