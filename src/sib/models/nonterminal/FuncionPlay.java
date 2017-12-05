package sib.models.nonterminal;

import sib.inout.SibOutputController;
import sib.models.datatype.DataType;
import sib.models.datatype.NoteType;
import sib.models.datatype.StepType;

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
		this.variable = v; //.clone();
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
			case DataType.TYPE_STEP:
				n.value = new StepType( v.getStringValue() );
				break;
			case DataType.TYPE_NOTE:
				n = (NoteType)v.getValue();
				break;
			default:
				throw new Exception();
			}
		} catch ( Exception e ) {
			System.err.println( "Error al aplicar toNote en FunctionPlay:" + v.name );
			e.printStackTrace();
		}
		return n;
	}
}
