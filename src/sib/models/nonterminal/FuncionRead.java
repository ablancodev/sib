/**
 * Proyecto Sib - SI BEMOL, LENGUAJE DE PROGRAMACION MUSICAL
 * 
 * @author Antonio Blanco Oliva
 * @class FuncionRead
 * @version 1.0
 * 
 */

package sib.models.nonterminal;

import sib.inout.SibInputController;
import sib.models.datatype.DataType;
import sib.models.datatype.NoteType;

public class FuncionRead extends InstFuncion {

	SibInputController inputController;
	Variable variable;

	public FuncionRead( SibInputController input ) {
		inputController = input;
	}

	public void setDestinationVariable( Variable v ) {
		variable = v.clone();
	}

	@Override
	public void run() {
		if ( variable.getType().equalsIgnoreCase( DataType.TYPE_NOTE ) ) {
			NoteType n = inputController.readNote();
			if ( n != null ) {
				variable.setValue( n );
			}
		}
	}
}
