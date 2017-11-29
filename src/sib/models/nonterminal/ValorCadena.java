package sib.models.nonterminal;

public class ValorCadena extends ValorAsignacion {

	String value;

	public ValorCadena ( String s ) {
		value = s;
	}

	public String getValue() {
		return value;
	}

	public String getType() {
		return "string";
	}


	public ValorCadena evalua() {
		return this;
	}

	public void trans( Float f ) {
		// @todo falta checkear si es clef, etc ... y aplicar trans()
	}

	public String toString() {
		return value;
	}

	protected ValorCadena clone() {
		ValorCadena cad = new ValorCadena( this.value );
		return cad;
	}

	// Comparaciones
	public boolean igualQue( ValorAsignacion op2 ) {
		return this.value.compareTo( ((ValorCadena)op2).getValue() ) == 0;
	}
	public boolean distintoQue( ValorAsignacion op2 ) {
		return this.value.compareTo( ((ValorCadena)op2).getValue() ) != 0;
	}
	public boolean menorQue( ValorAsignacion op2 ) {
		return this.value.compareTo(((ValorCadena)op2).getValue() ) < 0;
	}
	public boolean menorIgualQue( ValorAsignacion op2 ) {
		return this.value.compareTo( ((ValorCadena)op2).getValue() ) <= 0;
	}
	public boolean mayorQue( ValorAsignacion op2 ) {
		return this.value.compareTo( ((ValorCadena)op2).getValue() ) > 0;
	}
	public boolean mayorIgualQue( ValorAsignacion op2 ) {
		return this.value.compareTo(((ValorCadena)op2).getValue() ) >= 0;
	}

}
