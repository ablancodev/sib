package sib.models.nonterminal;

public class OperacionTrans extends ValorAsignacion {

	Variable variable;
	TipoNumero valor;

	public OperacionTrans( Variable v, TipoNumero tn ) {
		variable = v;
		valor = tn;
	}

	public Variable evalua() {
		try {
			if ( variable != null ) {
				variable.trans( valor.toFloat() );
			}
		} catch ( Exception e ) {
			System.err.println( "ERROR en OperacionTrans->evalua: " + e.getMessage());
			e.printStackTrace();
		}
		return variable;
	}

	public String getType() {
		return variable.getType();
	}

	/**
	 * Obtiene el valor de la variable. No aplica la operación trans para obtener el valor.
	 *
	 * @return ValorAsignacion
	 */
	public ValorAsignacion getValue() {
		return variable.getValue();
	}

	public String getStringValue() {
		return variable.getStringValue();
	}

	/**
	 * Aplica la función de transportación de 'numTonos' sobre la variable anteriormente asignada.
	 */
	public void trans(Float numTonos) {
		try {
			if ( variable != null ) {
				variable.trans( valor.toFloat() );
			}
		} catch ( Exception e ) {
			System.err.println( "ERROR en OperacionTrans->trans: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	protected ValorAsignacion clone() {
		OperacionTrans op = new OperacionTrans( variable.clone(), valor.clone() );
		return op;
	}

	@Override
	public boolean igualQue(ValorAsignacion op2) {
		return this.evalua().igualQue( op2 );
	}

	@Override
	public boolean distintoQue(ValorAsignacion op2) {
		return this.evalua().distintoQue( op2 );
	}

	@Override
	public boolean menorQue(ValorAsignacion op2) {
		return this.evalua().menorQue( op2 );
	}

	@Override
	public boolean menorIgualQue(ValorAsignacion op2) {
		return this.evalua().menorIgualQue( op2 );
	}

	@Override
	public boolean mayorQue(ValorAsignacion op2) {
		return this.evalua().mayorQue( op2 );
	}

	@Override
	public boolean mayorIgualQue(ValorAsignacion op2) {
		return this.evalua().mayorIgualQue( op2 );
	}
}
