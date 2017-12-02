package sib.models.datatype;

import sib.models.nonterminal.ValorAsignacion;

public class StringType extends DataType {

	private String string;

	public StringType( String str ) {
		string = str;
	}

	public void setValue( String str ) {
		string = str;
	}

	public String getValue() {
		return string;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValorAsignacion evalua() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void trans(Float float1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ValorAsignacion clone() {
		// TODO Auto-generated method stub
		return null;
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
