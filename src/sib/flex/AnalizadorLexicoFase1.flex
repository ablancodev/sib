/**
 * Analizador Léxico fase 1.
 * Limpia el código de:
 * - Saltos de línea
 * - Comentarios
 */

/* Sección de declaraciones de JFlex */
package sib.flex;

%%
// Clase pública
%public

/* Devolvemos objetos del tipo String */
%type String

%class AnalizadorLexicoFase1
%unicode
%column
%line

%{
	// Se agregó una propiedad para verificar si existen tokens pendientes
	private boolean _existenTokens = true;

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

%init{
	/* Código que se ejecutará en el constructor de la clase */
%init}

%eof{
	/* Código a ejecutar al finalizar el análisis, en este caso cambiaremos el valor de una variable bandera */
	this._existenTokens = false;
%eof}

%yylexthrow Exception

/* Inicio de Expresiones regulares */

SaltoDeLinea = \n|\r|\r\n

/* Finaliza expresiones regulares */

%state COMENTARIO_MULTIPLE
%state COMENTARIO

%%
/* Inicia sección de reglas */

<YYINITIAL> {
	"/*"			{ yybegin( COMENTARIO_MULTIPLE ); }
	"//"			{ yybegin( COMENTARIO ); }
	{SaltoDeLinea}	{
						return yytext(); // lo mostramos, pero luego hay que eliminarlos
					}
	.				{
						//this._existenTokens = true;
						return yytext();
					}
}
<COMENTARIO> {
	{SaltoDeLinea}	{
						yybegin( YYINITIAL );
						return yytext(); // lo mostramos, pero luego hay que eliminarlos
					}
	.		{ }
}
<COMENTARIO_MULTIPLE> {
	"*/"	{ yybegin( YYINITIAL ); }
	.		{ }
}
