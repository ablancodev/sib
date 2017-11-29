package sib.models.nonterminal;

public class InstAsignacion extends Instruccion {

	Variable variable;
	ValorAsignacion valorAsignacion;

	public InstAsignacion( Variable v, ValorAsignacion va ) {
		variable = v;
		valorAsignacion = va;
	}

	@Override
	public void run() {
		ValorAsignacion nuevoValor = valorAsignacion.evalua();
		if ( tiposCompatibles( variable, nuevoValor ) ) {
			variable.setValue( nuevoValor );
		}
	}

	private boolean tiposCompatibles( Variable v, ValorAsignacion valor ) {
		// @todo falta implementarlo
		return true;
	}

}
