/**
 * Proyecto Sib - SI BEMOL, LENGUAJE DE PROGRAMACION MUSICAL
 * 
 * @author Antonio Blanco Oliva
 * @class InstOperador
 * @version 1.0
 * 
 */

package sib.models.nonterminal;

import java.util.ArrayList;
import java.util.ListIterator;

public class InstOperador extends Instruccion {

	Variable variable;
	ArrayList<String> listaOperadores;

	public InstOperador( Variable v, String on ) {
		variable = v;
		listaOperadores = new ArrayList<String>();
		listaOperadores.add( on );
	}

	public void addOperadorNota( String op ) {
		listaOperadores.add( op );
	}

	public void run() {
		String operador;
		ListIterator<String> it = listaOperadores.listIterator();
		while ( it.hasNext() ) {
			operador = it.next();
			variable.aplicarOperadorNota( operador );
		}
		variable.register();
	}

}
