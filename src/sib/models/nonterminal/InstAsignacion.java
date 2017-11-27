package sib.models.nonterminal;

public class InstAsignacion extends Instruccion {

	Variable variable;
	ValorAsignacion valorAsignacion;

	public InstAsignacion( Variable v, ValorAsignacion va ) {
		variable = v;
		valorAsignacion = va;
	}

	@Override
	public void run( TablaSimbolos ts ) {
		ValorAsignacion nuevoValor = valorAsignacion.evalua( ts );
		variable = ts.getVariable( variable.name );
		if ( tiposCompatibles( variable, nuevoValor ) ) {
			variable.setValue( nuevoValor );
			ts.updateVariable( variable );
		}
	}

	private boolean tiposCompatibles( Variable v, ValorAsignacion valor ) {
		// @todo falta implementarlo
		return true;
	}

}
