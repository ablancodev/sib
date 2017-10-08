/* Sección de declaraciones de JFlex */
package ejemplo;


%%
// Clase pública
%public

%class Lexico
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

PalabraReservada = PACKAGE

SaltoDeLinea = \n|\r|\r\n

/*
Tipo = int | float | frac | nfrac | string | step | clef | object | array | note | partiture

Simbolo = "*"|"+"|"-"|"/"|"#"|"@"|"b"|"("|")"|";"|"."|"="|","|"{"|"}"|"["|"]"|"<"|">"|"!"|"\""|"'"

Variable = "$"{Palabra}

Operador = "_#"|"_##"|"_b"|"_bb"|"_@"|"_."|"_.."|"_..."

Step = A[#b]* | B[#b]* | C[#b]* | D[#b]* | E[#b]* | F[#b]* | G[#b]* | A[@]? | B[@]? | C[@]? | D[@]? | E[@]? | F[@]? | G[@]? | S

Digito = [0-9]
Numero = {Digito}{Digito}*
Letra = [A-Za-z]
Palabra = {Letra}{Letra}*

SaltoDeLinea = \n|\r|\r\n
Espacio = [ \t\f]
*/
/* Finaliza expresiones regulares */
 
%%
/* Finaliza la sección de declaraciones de JFlex */
 
/* Inicia sección de reglas */
 
// Cada regla está formada por una {expresión} espacio {código}

// Terminales

{PalabraReservada}	{
	Token t = new Token( sym.RESERVADA, yycolumn, yyline+1, -1, yytext(), Token.PALABRA_RESERVADA );
	//Symbol s = new Symbol( csym.RESERVADA, t );
	this._existenTokens = true;
	return t;
}

{SaltoDeLinea}	{ return new Token( sym.EOF, yycolumn, yyline+1, -1, yytext(), "FIN" ); }

/*
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

{Palabra} {
	Token t = new Token( 0, yycolumn, yyline+1, 0, yytext(), Token.PALABRA );
	this._existenTokens = true;
	return t;
}

{Espacio} {
	// Ignorar cuando se ingrese un espacio
	Token t = new Token( 0, yycolumn, yyline+1, 0, "Espacio", "ESPACIO");
	this._existenTokens = true;
	return t;
}

{SaltoDeLinea} {
	// Quizás este token no proceda y simplemente haya que limpiar los saltos
	Token t = new Token( 0, yycolumn, yyline+1, 0, "Enter", "NUEVA_LINEA");
	this._existenTokens = true;
	return t;
}
*/
// Todo lo demás ...
.	{ 
	//throw new Exception();
}

<<EOF>> { return new Token( sym.EOF, yycolumn, yyline+1, -1, yytext(), "FIN" ); }
