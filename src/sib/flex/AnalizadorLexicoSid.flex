/* 
Analizador léxico de ficheros de definición de tipos para Sib
*/
package sib.flex;

%%
%public
%class AnalizadorLexicoSid
%{
 
 /* Código personalizado */
 
 // Se agregó una propiedad para verificar si existen tokens pendientes
 private boolean _existenTokens = false;
 public int linea = 1;
 
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

Palabra_reservada = DEF

Tipo = int | float | frac | nfrac | string | step | object | note | array"("{Numero}")"

Simbolo = ";"|"{"|"}"|"["|"]"

Digito = [0-9]
 Numero = {Digito} {Digito}*
 Letra  = [A-Za-z]
 LetraN = [A-Za-z0-9]
 SaltoDeLinea = \n|\r|\r\n
 Espacio = [ \t\f]
 Comentario = "//" {CharNoSaltoDeLinea}* {SaltoDeLinea}?

 Str_ident = {Letra}{LetraN}*
 CharNoSaltoDeLinea = [^\r\n]

/*
Str_definicion = DEF {Str_ident} "{" {Declaraciones} "}"
Definicion = {Comentario} | {Str_definicion}

Definiciones = {Definicion}+
Declaraciones = {Declaracion_tipo}+

Declaracion_tipo = {Tipo} {Str_ident};
*/
/* Finaliza expresiones regulares */
 
%%
/* Finaliza la sección de declaraciones de JFlex */
 
/* Inicia sección de reglas */
 
// Cada regla está formada por una {expresión} espacio {código}

// Terminales
{Palabra_reservada}	{
				Token t = new Token(yytext(), "PALABRA RESERVADA");
				this._existenTokens = true;
				return t;
			}

{Tipo}	{
				Token t = new Token(yytext(), "TIPO");
				this._existenTokens = true;
				return t;
			}

{Simbolo}	{
				Token t = new Token(yytext(), "SIMBOLO");
				this._existenTokens = true;
				return t;
			}

{Str_ident}	{
				Token t = new Token(yytext(), "STR_IDENT");
				this._existenTokens = true;
				return t;
			}

{Comentario}	{
				Token t = new Token(yytext(), "COMENTARIO");
				this._existenTokens = true;
				this.linea ++;
				return t;
			}

{Espacio} {
 // Ignorar cuando se ingrese un espacio
}
 
{SaltoDeLinea} {
 Token t = new Token("Enter", "NUEVA_LINEA");
 this._existenTokens = true;
 this.linea ++;
 return t;
}
.	{ throw new Exception(); }