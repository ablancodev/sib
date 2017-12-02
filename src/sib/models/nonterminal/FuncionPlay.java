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

	/**
	 * Genera un NoteType apartir de un variable.
	 * Valores aceptados del tipo de variable: step, note
	 * @param v
	 * @return
	 */
	private NoteType toNote(Variable v ) {
		NoteType n = new NoteType();
		try {
			switch ( v.getType() ) {
			case "step":
				n.value = v.getStringValue();
				break;
			case "note":
				n = (NoteType)v.getValue().clone();
				break;
			default:
				throw new Exception();
			}
			outputController.playNote( n );
		} catch ( Exception e ) {
			System.err.println( "Error al aplicar toNote en FunctionPlay.");
			e.printStackTrace();
		}
		return n;
	}
}
