package sib.models.nonterminal;


public class Variable extends OperandoAritmetico {

	String name;
	String tipo;
	ValorAsignacion valor;

	public Variable(String n ) {
		name = n;
		tipo = "";
		valor = null;
	}

	public void setTipo( String t ) {
		tipo = t;
	}

	public void setValue( ValorAsignacion v ) {
		if ( v != null ) {
			ValorAsignacion newV = v.clone();
			if ( v.getClass() == Variable.class ) {
				valor = ( (Variable)newV ).valor;
			} else {
				valor = newV;
			}
		}
	}

	public void aplicarOperador( String op ) {
		if ( this.esAplicable( op ) ) {
			String v = "";
			if ( valor != null ) {
				v = valor.toString();
			}
			valor = new ValorCadena( v + "_" + op );
		}
	}

	public ValorAsignacion evalua( TablaSimbolos ts ) {
		Variable temp = ts.getVariable( name );
		if ( temp != null ) {
			valor = temp.valor;
		}
		return valor;
	}

	public String toString() {
		String v = "";
		if ( valor != null ) {
			v = valor.toString();
		}
		return tipo + ":" + name + "->" + v;
	}

	/**
	 * Checkea si es aplicable o no un operador nota.
	 * @param op String
	 * @return boolean
	 */
	private boolean esAplicable( String op ) {
		boolean result = false;
		switch ( tipo ) {
			case "note":
				switch ( op ) {
					case "_#":
					case "_##":
					case "_b":
					case "_bb":
					case "_@":
					case "_.":
					case "_..":
					case "_...":
						result = true;
						break;
					default:
						result = false;
						break;
				}
				break;
			default:
				result = false;
				break;
		}
		return result;
	}

	public void trans( Float float1 ) {
		valor.trans( float1 );
		
	}

	protected Variable clone() {
		Variable v = new Variable( this.name );
		v.setTipo( this.tipo );
		if ( this.valor != null ) {
			v.setValue( this.valor.clone() );
		}
		return v;
	}

}
