package sib.flex;

public class Token extends java_cup.runtime.Symbol {

	public static final String PALABRA_RESERVADA = "0";
	public static final String TIPO              = "1";
	public static final String STR_IDENT         = "2";
	public static final String PALABRA           = "3";
	public static final String VARIABLE          = "4";
	public static final String CARACTER          = "5";
	public static final String OPERADOR_NOTA     = "6";
	public static final String STEP              = "7";
	public static final String SIMBOLO           = "8";
	public static final String STRING            = "9";

	private int tipoToken;
	private int numColumna;
	private int numLinea;
	private int posicionSimbolo;
	private String token;
	private String lexema;

	public Token ( String lexema, String token ) {
		super( 1, lexema ); // @todo tengo que cambiar el 1, no puede ser un int fijo
		this.lexema = lexema;
		this.token  = token;
	}

	/**
	 * 
	 * @param tipoToken
	 * @param numColumna
	 * @param numLinea
	 * @param posicionSimbolo -1 en caso de ser palabra reservada
	 * @param lexema
	 * @param token
	 */
	public Token ( int tipoToken, int numColumna, int numLinea, int posicionSimbolo, String lexema, String token ) {
		super ( tipoToken, lexema );
		this.tipoToken       = tipoToken;
		this.numColumna      = numColumna;
		this.numLinea        = numLinea;
		this.posicionSimbolo = posicionSimbolo;
		this.lexema          = lexema;
		this.token           = token;
	}

	public int getTipoToken() {
		return tipoToken;
	}
	public int getNumColumna() {
		return numColumna;
	}
	public int getNumLinea() {
		return numLinea;
	}
	public int getPosicionSimbolo() {
		return posicionSimbolo;
	}
	public String getToken() {
		return token;
	}
	public String getLexema() {
		return lexema;
	}

	public String toString() {
		return "Token #" + this.posicionSimbolo + " Token<" + this.tipoToken + ">: " + this.token + " Lexema: " + this.lexema + " [" + this.numLinea + ", " + this.numColumna + "]";
	}
}