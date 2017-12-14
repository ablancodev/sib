/**
 * Proyecto Sib - SI BEMOL, LENGUAJE DE PROGRAMACION MUSICAL
 * 
 * @author Antonio Blanco Oliva
 * @class FuncionReadPartiture
 * @version 1.0
 * 
 */

package sib.models.nonterminal;

import sib.inout.SibInputController;

public class FuncionReadPartiture extends InstFuncion {

	SibInputController inputController;

	public FuncionReadPartiture( SibInputController input ) {
		inputController = input;
	}


	@Override
	public void run() {
		inputController.readPartiture();
	}
}
