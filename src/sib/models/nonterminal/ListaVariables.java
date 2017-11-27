package sib.models.nonterminal;

import java.util.ArrayList;
import java.util.HashMap;
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

	public void setTipo( String tipo ) {
		Variable temp;
		ListIterator<Variable> it = variables.listIterator();
		while ( it.hasNext() ) {
			temp = it.next();
			temp.setTipo( tipo );
		}
	}

	public void run( TablaSimbolos ts ) {
		Variable temp;
		ListIterator<Variable> it = variables.listIterator();
		while ( it.hasNext() ) {
			temp = it.next();
			ts.addVariable( temp );
		}
	}

}
