package sib.models.datatype;

import sib.models.nonterminal.ValorAsignacion;

public class ClefType extends DataType {

	private String string;

	public ClefType( String str ) {
		string = str;
	}

	public String getType() {
		return "clef";
	}

	public String getValue() {
		return string;
	}

	public ValorAsignacion evalua() {
		return this;
	}

	protected ValorAsignacion clone() {
		ClefType st = new ClefType( this.string );
		return st;
	}

	@Override
	public void trans(Float float1) {
		// TODO Auto-generated method stub
		
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
