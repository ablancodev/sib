package sib.models.datatype;

import sib.models.nonterminal.ValorAsignacion;
import sib.models.nonterminal.Variable;

public class StringType extends DataType {

	public static final String DEFAULT_VALUE = "";
	private String value;

	public StringType( String str ) {
		value = str;
	}

	public StringType() {
		value = StringType.DEFAULT_VALUE;
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
		return this;
	}

	@Override
	public void trans(Float float1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ValorAsignacion clone() {
		StringType newSt = new StringType( this.value );
		return newSt;
	}

	@Override
	public boolean igualQue(ValorAsignacion oper2) {
		ValorAsignacion op2 = oper2;
		if ( op2.getClass() == Variable.class ) {
			op2 = oper2.getValue();
		}
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
		return !igualQue( op2 );
	}

	@Override
	public boolean menorQue(ValorAsignacion oper2) {
		ValorAsignacion op2 = oper2;
		if ( op2.getClass() == Variable.class ) {
			op2 = oper2.getValue();
		}
		return value.compareTo( op2.getStringValue() ) < 0;
	}

	@Override
	public boolean menorIgualQue(ValorAsignacion op2) {
		return menorQue( op2 ) || igualQue( op2 );
	}

	@Override
	public boolean mayorQue(ValorAsignacion op2) {
		return !menorQue( op2 ) && !igualQue( op2 );
	}

	@Override
	public boolean mayorIgualQue(ValorAsignacion op2) {
		return !menorQue( op2 );
	}

}
