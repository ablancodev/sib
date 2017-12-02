package sib.models.nonterminal;

public abstract class ValorAsignacion {

	public abstract String getType();
	public abstract ValorAsignacion getValue();

	//public abstract ValorAsignacion evalua( TablaSimbolos ts );

	public abstract ValorAsignacion evalua( );

	/**
	 * TRansporta el valor
	 * @param float1 float
	 */
	public abstract void trans( Float float1 );

	protected abstract ValorAsignacion clone();

	// Comparaciones
	public abstract boolean igualQue( ValorAsignacion op2 );
	public abstract boolean distintoQue( ValorAsignacion op2 );
	public abstract boolean menorQue( ValorAsignacion op2 );
	public abstract boolean menorIgualQue( ValorAsignacion op2 );
	public abstract boolean mayorQue( ValorAsignacion op2 );
	public abstract boolean mayorIgualQue( ValorAsignacion op2 );
	public abstract String getStringValue();

}
