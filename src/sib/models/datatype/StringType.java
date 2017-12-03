package sib.models.datatype;

import sib.models.nonterminal.ValorAsignacion;

public class StringType extends DataType {

	private String value;

	public StringType( String str ) {
		value = str;
	}

	public void setValue( String str ) {
		value = str;
	}

	public ValorAsignacion getValue() {
		return this;
	}

	public String getStringValue() {
		return value;
	}

	@Override
	public String getType() {
		return "string";
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
	public ValorAsignacion clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean igualQue(ValorAsignacion op2) {
		boolean result = false;
		try {
			switch (op2.getType() ) {
				case "string":
				case "clef":
				case "step":
					result = this.value.compareTo( op2.getStringValue() ) == 0;
					break;
				default:
					throw new Exception();
			}
		} catch (Exception e) {
			System.err.println(  "ERROR ClefType: Comparación igualQue entre elementos incompatibles." );
			e.printStackTrace();
		}
		return result;
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
