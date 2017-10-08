/* Sección de declaraciones de JFlex */
package sib.flex;

%%
// Clase pública
%public

%class AnalizadorLexico
%{
 
 /* Código personalizado */
 
 // Se agregó una propiedad para verificar si existen tokens pendientes
 private boolean _existenTokens = false;
 public int numLinea = 1;
 
 public boolean existenTokens(){
	 return this._existenTokens;
 }
 
%}
 
 /* Al utilizar esta instrucción, se le indica a JFlex que devuelva objetos del tipo Token */
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

PalabraReservada = PACKAGE | IMPORT | BEGIN | END | IF | ENDIF | ELSE | WHILE | ENDWHILE

Tipo = int | float | frac | nfrac | string | step | clef | object | array | note | partiture

Simbolo = "*"|"+"|"-"|"/"|"#"|"@"|"b"|"("|")"|";"|"."|"="|","|"{"|"}"|"["|"]"|"<"|">"|"!"|"\""|"'"

Variable = "$"{Palabra}

Operador = "_#"|"_##"|"_b"|"_bb"|"_@"|"_."|"_.."|"_..."

Step = A[#b]* | B[#b]* | C[#b]* | D[#b]* | E[#b]* | F[#b]* | G[#b]* | A[@]? | B[@]? | C[@]? | D[@]? | E[@]? | F[@]? | G[@]? | S

Digito = [0-9]
Numero = {Digito}{Digito}*
Letra = [A-Za-z]
Palabra = {Letra}{Letra}*
CharNoSaltoDeLinea = [^\r\n]
 
SaltoDeLinea = \n|\r|\r\n
Espacio = [ \t\f]
Comentario = "//" {CharNoSaltoDeLinea}* {SaltoDeLinea}?
// @todo falta comentarios multipleslíneas

/*Package = PACKAGE{Espacio}{Palabra}("."{Palabra})*";"*/

Import = IMPORT{Espacio}{Palabra}".sid;"

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

{Import}	{
	// No estoy seguro si el lexico debe aqui insersar el texto importado para procesarlo
	Token t = new Token( 0, 0, this.numLinea, 0, yytext(), "IMPORT" );
	this._existenTokens = true;
	return t;
}


{PalabraReservada}	{
	Token t = new Token( 0, 0, this.numLinea, -1, yytext(), "PALABRA RESERVADA");
	this._existenTokens = true;
	return t;
}

{Tipo}	{
	Token t = new Token( 0, 0, this.numLinea, 0, yytext(), "TIPO");
	this._existenTokens = true;
	return t;
}

{Step}	{
	Token t = new Token( 0, 0, this.numLinea, 0, yytext(), "STEP");
	this._existenTokens = true;
	return t;
}

{Simbolo}	{
	Token t = new Token( 0, 0, this.numLinea, 0, yytext(), "SIMBOLO");
	this._existenTokens = true;
	return t;
}

{Variable}	{
	Token t = new Token( 0, 0, this.numLinea, 0, yytext(), "VARIABLE");
	this._existenTokens = true;
	return t;
}

{Operador}	{
	Token t = new Token( 0, 0, this.numLinea, 0, yytext(), "OPERADOR");
	this._existenTokens = true;
	return t;
}

{Comentario}	{
	// No sé si no crear este token y simplemente limpiar los comentarios
	Token t = new Token( 0, 0, this.numLinea, 0, yytext(), "COMENTARIO");
	this._existenTokens = true;
	this.numLinea ++;
	return t;
}

{Numero} {
	Token t = new Token( 0, 0, this.numLinea, 0, yytext(), "NUMERO" );
	this._existenTokens = true;
	return t;
}

{Palabra} {
 Token t = new Token( 0, 0, this.numLinea, 0, yytext(), "PALABRA" );
 this._existenTokens = true;
 return t;
}

{Espacio} {
	// Ignorar cuando se ingrese un espacio
	Token t = new Token( 0, 0, this.numLinea, 0, "Espacio", "ESPACIO");
	this._existenTokens = true;
	return t;
}

{SaltoDeLinea} {
	// Quizás este token no proceda y simplemente haya que limpiar los saltos
	Token t = new Token( 0, 0, this.numLinea, 0, "Enter", "NUEVA_LINEA");
	this._existenTokens = true;
	this.numLinea ++;
	return t;
}
// Todo lo demás ...
.	{ 
	throw new Exception();
}