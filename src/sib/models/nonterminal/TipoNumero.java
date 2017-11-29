package sib.models.nonterminal;

public class TipoNumero extends OperandoAritmetico {

	String valor;
	String tipo;

	public TipoNumero( String num, String t ) {
		valor = num;
		tipo = t;
	}

	public String getType() {
		return tipo;
	}

	/**
	 * Devuelve el valor del TipoNumero como el string del float que lo representa.
	 */
	public String getValue() {
		// @todo esto habrá que mejorarlo para que contemple todos los tipos de cadenas que representan a frac, ...
		return String.valueOf( toFloat() );
	}

	public void setValue( Float f ) {
		valor = f.toString();
	}

	public String toString() {
		return tipo + ":" + valor;
	}

	public float toFloat() {
		float result = 0;
		try {
			result = Float.valueOf( valor );
		} catch ( Exception e ) {
			System.err.println( e.toString() );
		}
		return result;
	}

	public void trans( Float f ) {
		Float origen = Float.valueOf( valor );
		origen = origen + f;
		valor = origen.toString();
	}

	protected TipoNumero clone() {
		TipoNumero num = new TipoNumero( this.valor, this.tipo );
		return num;
	}

	// Comparaciones
	public boolean igualQue( ValorAsignacion op2 ) {
		return this.toFloat() == ((TipoNumero)op2).toFloat();
	}
	public boolean distintoQue( ValorAsignacion op2 ) {
		return this.toFloat() != ((TipoNumero)op2).toFloat();
	}
	public boolean menorQue( ValorAsignacion op2 ) {
		return this.toFloat() < ((TipoNumero)op2).toFloat();
	}
	public boolean menorIgualQue( ValorAsignacion op2 ) {
		return this.toFloat() <= ((TipoNumero)op2).toFloat();
	}
	public boolean mayorQue( ValorAsignacion op2 ) {
		return this.toFloat() > ((TipoNumero)op2).toFloat();
	}
	public boolean mayorIgualQue( ValorAsignacion op2 ) {
		return this.toFloat() >= ((TipoNumero)op2).toFloat();
	}

	public ValorAsignacion evalua() {
		return this;
	}
}
