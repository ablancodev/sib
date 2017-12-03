package sib.models.datatype;

import sib.models.nonterminal.ValorAsignacion;

/**
 * Representa el tipo de datos note
 *
 * @author Antonio Blanco
 *
 */
public class NoteType extends DataType {

	public String value = "C"; // @todo cambiar tipo a step

	public int duration = 4; // @todo cambiar tipo a nfrac

	public int octave = 4;

	public int dots = 0;

	public String accent = "";

	@Override
	public String getType() {
		return "note";
	}

	@Override
	public ValorAsignacion getValue() {
		return this;
	}

	public String getStringValue() {
		return value;
	}

	@Override
	public ValorAsignacion evalua() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void trans(Float float1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ValorAsignacion clone() {
		NoteType n = new NoteType();
		n.value = value;
		n.accent = accent;
		n.dots = dots;
		n.duration = duration;
		n.octave = octave;
		return n;
	}

	@Override
	public boolean igualQue(ValorAsignacion op2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean distintoQue(ValorAsignacion op2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean menorQue(ValorAsignacion op2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean menorIgualQue(ValorAsignacion op2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mayorQue(ValorAsignacion op2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mayorIgualQue(ValorAsignacion op2) {
		// TODO Auto-generated method stub
		return false;
	}

}