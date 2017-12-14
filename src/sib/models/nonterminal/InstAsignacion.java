/**
 * Proyecto Sib - SI BEMOL, LENGUAJE DE PROGRAMACION MUSICAL
 * 
 * @author Antonio Blanco Oliva
 * @class InstAsignacion
 * @version 1.0
 * 
 */

package sib.models.nonterminal;

public class InstAsignacion extends Instruccion {

	Variable variable;
	/**
	 * Propiedad de la variable en caso de que aplique a propiedad, en otro caso es null
	 */
	String property;

	ValorAsignacion valorAsignacion;

	public InstAsignacion( ValorAsignacion va, Variable v, String prop ) {
		variable = v;
		valorAsignacion = va;
		property = prop;
	}

	public InstAsignacion( ValorAsignacion va, Variable v ) {
		variable = v;
		valorAsignacion = va;
		property = null;
	}

	@Override
	public void run() {
		ValorAsignacion nuevoValor = valorAsignacion.evalua();
		if ( tiposCompatibles( variable, nuevoValor ) ) {
			if ( property != null ) {
				variable.setValue( nuevoValor, property );
			} else {
				variable.setValue( nuevoValor );
			}
		}
	}

	private boolean tiposCompatibles( Variable v, ValorAsignacion valor ) {
		// Actualmente el analizador sintáctico es el encargado de testar esta comprobación.
		return true;
	}

}
