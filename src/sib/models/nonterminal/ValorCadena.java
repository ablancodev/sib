package sib.models.nonterminal;

public class ValorCadena extends ValorAsignacion {

	String valor;

	public ValorCadena ( String s ) {
		valor = s;
	}

	public String getValue() {
		return valor;
	}

	public ValorCadena evalua() {
		return this;
	}

	public void trans( Float f ) {
		// @todo falta checkear si es clef, etc ... y aplicar trans()
	}

	public String toString() {
		return valor;
	}

	protected ValorCadena clone() {
		ValorCadena cad = new ValorCadena( this.valor );
		return cad;
	}

	// Comparaciones
	public boolean igualQue( ValorAsignacion op2 ) {
		System.err.println( "VALOR CADENA->" + this.valor);
		return this.valor.compareTo( ((ValorCadena)op2).getValue() ) == 0;
	}
	public boolean distintoQue( ValorAsignacion op2 ) {
		return this.valor.compareTo( ((ValorCadena)op2).getValue() ) != 0;
	}
	public boolean menorQue( ValorAsignacion op2 ) {
		return this.valor.compareTo(((ValorCadena)op2).getValue() ) < 0;
	}
	public boolean menorIgualQue( ValorAsignacion op2 ) {
		return this.valor.compareTo( ((ValorCadena)op2).getValue() ) <= 0;
	}
	public boolean mayorQue( ValorAsignacion op2 ) {
		return this.valor.compareTo( ((ValorCadena)op2).getValue() ) > 0;
	}
	public boolean mayorIgualQue( ValorAsignacion op2 ) {
		return this.valor.compareTo(((ValorCadena)op2).getValue() ) >= 0;
	}
}
