package sib.models.nonterminal;

public class OperacionTrans extends ValorAsignacion {

	Variable variable;

	TipoNumero valor;

	public OperacionTrans( Variable v, TipoNumero tn ) {
		variable = v;
		valor = tn;
	}

	public Variable evalua( TablaSimbolos ts ) {
		if ( variable != null ) {
			variable = ts.getVariable( variable.name );
			if ( variable != null ) {
				variable.trans( valor.toFloat() );
			}
		}
		return variable;
	}
}
