package sib.models.datatype;

import sib.models.nonterminal.ValorAsignacion;
import java.lang.Exception;

public class ClefType extends DataType {

	private String value;

	public ClefType( String str ) {
		value = str;
	}

	public String getType() {
		return "clef";
	}

	public ValorAsignacion getValue() {
		return this;
	}

	public String getStringValue() {
		return value;
	}

	public ValorAsignacion evalua() {
		return this;
	}

	protected ValorAsignacion clone() {
		ClefType st = new ClefType( this.value );
		return st;
	}

	@Override
	public void trans(Float float1) {
		// TODO Auto-generated method stub
		
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

	private boolean comparaValido(ValorAsignacion op2) {
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
