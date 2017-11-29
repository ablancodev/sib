package sib.models.nonterminal;

public class OperacionTrans extends ValorAsignacion {

	Variable variable;

	TipoNumero valor;

	public OperacionTrans( Variable v, TipoNumero tn ) {
		variable = v;
		valor = tn;
	}

	public Variable evalua( TablaSimbolos ts ) {
		if ( variable != null ) {
			variable = ts.getVariable( variable.name );
			if ( variable != null ) {
				variable.trans( valor.toFloat() );
			}
		}
		return variable;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
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
