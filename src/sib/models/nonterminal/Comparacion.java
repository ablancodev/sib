package sib.models.nonterminal;

public class Comparacion {

	ValorAsignacion operador1;
	ValorAsignacion operador2;
	String condicion;

	public Comparacion( ValorAsignacion op1, String cc, ValorAsignacion op2 ) {
		operador1 = op1;
		operador2 = op2;
		condicion = cc;
	}

	public boolean evalua() {
		boolean result;
		switch ( condicion ) {
		case "==":
			result = this.igualQue( operador1.run(), operador2.run() ); 
			break;
		case "!=":
			result = this.distintoQue( operador1.run(), operador2.run() ); 
			break;
		case "<":
			result = this.menorQue( operador1.run(), operador2.run() );
			break;
		case "<=":
			result = this.menorIgualQue( operador1.run(), operador2.run() ); 
			break;
		case ">":
			result = this.mayorQue( operador1.run(), operador2.run() ); 
			break;
		case ">=":
			result = this.mayorIgualQue( operador1.run(), operador2.run() ); 
			break;
		default:
			result = false;
			break;
		}
		return result;
	}

	private boolean mayorIgualQue(ValorAsignacion run, ValorAsignacion run2) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean mayorQue(ValorAsignacion run, ValorAsignacion run2) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean menorIgualQue(ValorAsignacion run, ValorAsignacion run2) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean menorQue(ValorAsignacion run, ValorAsignacion run2) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean distintoQue(ValorAsignacion run, ValorAsignacion run2) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean igualQue(ValorAsignacion run, ValorAsignacion run2) {
		// TODO Auto-generated method stub
		return true;
	}
}
