/**
 * Proyecto Sib - SI BEMOL, LENGUAJE DE PROGRAMACION MUSICAL
 * 
 * @author Antonio Blanco Oliva
 * @class InstDeclaracion
 * @version 1.0
 * 
 */

package sib.models.nonterminal;

public class InstDeclaracion extends Instruccion {

	String tipo;
	ListaVariables variables;

	public InstDeclaracion( String tipo, ListaVariables lv ) {
		this.tipo = tipo;
		this.variables = lv;
		variables.setType( tipo );
	}

	@Override
	public void run() {
		variables.run();
	}

}
