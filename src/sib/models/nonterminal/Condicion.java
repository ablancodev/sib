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

	public boolean evalua() {
		boolean result = false;
		operador1.evalua();
		operador2.evalua();
		if ( operador1.getType().equals( operador2.getType() ) ) {
			switch ( condicion ) {
			case "==":
				result = operador1.igualQue( operador2 );
				break;
			case "!=":
				result = operador1.distintoQue( operador2 );
				break;
			case "<":
				result = operador1.menorQue( operador2 );
				break;
			case "<=":
				result = operador1.menorIgualQue( operador2 );
				break;
			case ">":
				result = operador1.mayorQue( operador2 );
				break;
			case ">=":
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
				throw new Exception( "Para comparar dos elementos, deben ser del mismo tipo:" + operador1.getType() + "-" + operador2.getType() );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
