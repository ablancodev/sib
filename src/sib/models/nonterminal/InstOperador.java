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


/*
	public Variable run() {
		String temp;
		ListIterator<String> it = listaOperadores.listIterator();
		while ( it.hasNext() ) {
			temp = it.next();
			variable.aplicarOperador( temp );
		}
		return variable;
	}

	public void run( TablaSimbolos ts ) {
		String temp;
		ListIterator<String> it = listaOperadores.listIterator();
		while ( it.hasNext() ) {
			temp = it.next();
			variable.aplicarOperador( temp );
		}
		ts.updateVariable( variable );
	}
*/

}
