package sib.models.nonterminal;

public class FuncionRead extends InstFuncion {

	Variable variable;

	public FuncionRead( Variable v ) {
		variable = v;
	}

	public Variable readNote() {
		// @todo implementar readNote
		return variable;
	}
}
