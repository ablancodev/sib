package sib.models.nonterminal;

public class Condicion {

	ValorAsignacion operador1;
	ValorAsignacion operador2;
	String condicion;

	public Condicion( ValorAsignacion op1, String cc, ValorAsignacion op2 ) {
		operador1 = op1;
		operador2 = op2;
		condicion = cc;
	}

	public boolean evalua( TablaSimbolos ts ) {
		boolean result = false;
		operador1.evalua( ts );
		operador2.evalua( ts );
		if ( operador1.getTipo().equals( operador2.getTipo() ) ) {
			switch ( condicion ) {
			case "==":
				operador1.evalua( ts );
				result = operador1.igualQue( operador2 );
				break;
			case "!=":
				operador1.evalua( ts );
				result = operador1.distintoQue( operador2 );
				break;
			case "<":
				operador1.evalua( ts );
				result = operador1.menorQue( operador2 );
				break;
			case "<=":
				operador1.evalua( ts );
				result = operador1.menorIgualQue( operador2 );
				break;
			case ">":
				operador1.evalua( ts );
				result = operador1.mayorQue( operador2 );
				break;
			case ">=":
				operador1.evalua( ts );
				result = operador1.mayorIgualQue( operador2 );
				break;
			default:
				result = false;
				try {
					throw new Exception( "Comparador no válido." );
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		} else {
			try {
				throw new Exception( "Para comparar dos elementos, deben ser del mismo tipo:" + operador1.getTipo() + "-" + operador2.getTipo() );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
