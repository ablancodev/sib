package sib.models.nonterminal;

import sib.inout.SibOutputController;
import sib.models.datatype.NoteType;

public class FuncionPlay extends InstFuncion {

	SibOutputController outputController;
	Variable variable;

	public FuncionPlay( SibOutputController out ) {
		outputController = out;
	}

	/**
	 * Establece la variable sobre la que posteriormente la clase trabajará.
	 *
	 * @param v Variable
	 */
	public void play( Variable v ) {
		this.variable = v.clone();
	}

	@Override
	public void run() {
		variable.evalua();
		outputController.playNote( this.toNote( variable ) );
	}

	private NoteType toNote(Variable v ) {
		NoteType n = null;
		try {
			n = new NoteType();
			TipoNumero tn = (TipoNumero) v.valor;
			n.value = tn.toString();
		} catch ( Exception e ) {
			System.err.println( "Error al aplicar toNote en FunctionPlay.");
			e.printStackTrace();
		}
		return n;
	}
}
