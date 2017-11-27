package sib.models.nonterminal;

public class ValorAsignacion {

	public ValorAsignacion evalua( TablaSimbolos ts ) {
		return this;
	}

	public ValorAsignacion evalua( ) {
		return this;
	}

	/**
	 * TRansporta el valor
	 * @param float1 float
	 */
	public void trans( Float float1 ) {

	}

	protected ValorAsignacion clone() {
		return new ValorAsignacion();
	}

}
