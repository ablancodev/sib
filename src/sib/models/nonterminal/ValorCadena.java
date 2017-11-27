package sib.models.nonterminal;

public class ValorCadena extends ValorAsignacion {

	String valor;

	public ValorCadena ( String s ) {
		valor = s;
	}

	public ValorAsignacion evalua() {
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
}
