package sib.models.nonterminal;

import sib.models.datatype.DataType;

public class TipoNumero extends OperandoAritmetico {

	float valor;
	String tipo;

	public TipoNumero( String num, String t ) {
		valor = Float.parseFloat( num );
		tipo = t;
	}

	public String getType() {
		return tipo;
	}

	/**
	 * Devuelve el valor. Como TipoNúmero es 'atómico', devuelte un TipoNumero
	 *
	 * @return ValorAsignacion > TipoNumero
	 */
	public ValorAsignacion getValue() {
		return this;
	}

	public String getStringValue() {
		return String.valueOf( valor );
	}

	public void setValue( Float f ) {
		valor = f;
	}

	public String toString() {
		return tipo + ":" + String.valueOf( valor );
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
		valor = valor + f;
	}

	protected TipoNumero clone() {
		TipoNumero num = new TipoNumero( String.valueOf( valor ), this.tipo );
		return num;
	}

	// Comparaciones
	public boolean igualQue( ValorAsignacion op2 ) {
		return valor == ((TipoNumero)op2).toFloat();
	}
	public boolean distintoQue( ValorAsignacion op2 ) {
		return valor != ((TipoNumero)op2).toFloat();
	}
	public boolean menorQue( ValorAsignacion op2 ) {
		return valor < ((TipoNumero)op2).toFloat();
	}
	public boolean menorIgualQue( ValorAsignacion op2 ) {
		return valor <= ((TipoNumero)op2).toFloat();
	}
	public boolean mayorQue( ValorAsignacion op2 ) {
		return valor > ((TipoNumero)op2).toFloat();
	}
	public boolean mayorIgualQue( ValorAsignacion op2 ) {
		return valor >= ((TipoNumero)op2).toFloat();
	}

	public ValorAsignacion evalua() {
		return this;
	}
}
