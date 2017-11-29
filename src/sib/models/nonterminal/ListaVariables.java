package sib.models.nonterminal;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListaVariables {

	ArrayList<Variable> variables;

	public ListaVariables( Variable v ) {
		variables = new ArrayList<Variable>();
		variables.add( v );
	}

	public void add( Variable v ) {
		variables.add( v );
	}

	public void setType( String tipo ) {
		Variable temp;
		ListIterator<Variable> it = variables.listIterator();
		while ( it.hasNext() ) {
			temp = it.next();
			temp.setType( tipo );
		}
	}

	public void run() {
		Variable temp;
		ListIterator<Variable> it = variables.listIterator();
		while ( it.hasNext() ) {
			temp = it.next();
			temp.register(); // Registramos las variables en la TablaSimbolos
		}
	}

}
