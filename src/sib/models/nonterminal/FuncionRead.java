package sib.models.nonterminal;

import sib.inout.SibInputController;

public class FuncionRead extends InstFuncion {

	SibInputController inputController;
	Variable variable;

	public FuncionRead( SibInputController input ) {
		inputController = input;
	}

	public void read( Variable v ) {
		variable = v.clone();
	}
	/*
	public Variable readNote() {
		// @todo implementar readNote
		return variable;
	}
	*/

	@Override
	public void run() {
		// @todo implementarlo
		this.variable.tipo = "int";
		this.variable.setValue( new TipoNumero( "999", "int" ) );
	}
}
