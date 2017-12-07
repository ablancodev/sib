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

%class AnalizadorLexicoMacros
%unicode
%column
%line

%{
	// Se agregó una propiedad para verificar si existen tokens pendientes
	private boolean _existenTokens = true;

	// Contiene las cadenas entre comillas
	StringBuilder string = new StringBuilder();

	public boolean existenTokens(){
		return this._existenTokens;
	}
%}

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
Letra = [A-Za-z]
LetraNumero = [A-Za-z0-9]
Str_ident = {Letra}{LetraNumero}*

SaltoDeLinea = \n|\r|\r\n
Espacio = [ \t\f]

Begin = BEGIN
End = ENDMACRO

%state MACRO

/* Finaliza expresiones regulares */

%%
/* Inicia sección de reglas */
<YYINITIAL> {
	{Str_ident} {
		Token t = new Token( sym.IDENTIFICADOR, yycolumn, yyline+1, 0, yytext(), Token.STR_IDENT );
		this._existenTokens = true;
		return t;
	}
	{Begin}	{
		Token t = new Token( sym.BEGIN, yycolumn, yyline+1, -1, yytext(), Token.PALABRA_RESERVADA );
		this._existenTokens = true;
		return t;
	}
}
// Estado dentro del cuerpo de un macro
<MACRO>	{
	{End}	{
		Token t = new Token( sym.END, yycolumn, yyline+1, -1, string.toString(), Token.PALABRA_RESERVADA );
		this._existenTokens = true;
		yybegin( YYINITIAL );
		return t;
	}

	[^\r\n{End}] {
		string.append( yytext() );
	}

 }

{Espacio} {  }

{SaltoDeLinea} {  }


// Todo lo demás ...
.	{ 
	//throw new Exception();
}
<<EOF>> { return new Token( sym.EOF, yycolumn, yyline+1, -1, yytext(), "FIN" ); }

