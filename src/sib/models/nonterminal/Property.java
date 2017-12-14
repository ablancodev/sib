/**
 * Proyecto Sib - SI BEMOL, LENGUAJE DE PROGRAMACION MUSICAL
 * 
 * @author Antonio Blanco Oliva
 * @class Property
 * @version 1.0
 * 
 */

package sib.models.nonterminal;

public class Property extends ValorAsignacion {

	public String variableName;
	public String name;
	private TablaSimbolos tablaSimbolos = null;

	public Property( String varName, String propName ) {
		this.variableName = varName;
		this.name = propName;
	}

	public void setTablaSimbolos ( TablaSimbolos ts ) {
		this.tablaSimbolos = ts;
	}

	@Override
	public String getType() {
		Variable v = tablaSimbolos.getVariable( this.variableName );
		ValorAsignacion p = v.getProperty( this.name );
		return p.getType();
	}

	@Override
	public ValorAsignacion getValue() {
		Variable v = tablaSimbolos.getVariable( this.variableName );
		ValorAsignacion p = v.getProperty( this.name );
		return p.getValue();
	}

	public ValorAsignacion getPropertyValue() {
		Variable v = tablaSimbolos.getVariable( this.variableName );
		return v.getProperty( this.name );
	}

	public String getPropertyName() {
		return this.name;
	}

	public String getVariableName() {
		return this.variableName;
	}

	@Override
	public ValorAsignacion evalua() {
		Variable v = tablaSimbolos.getVariable( this.variableName );
		ValorAsignacion p = v.getProperty( this.name );
		return p.evalua();
	}

	@Override
	public void trans(Float float1) {
		Variable v = tablaSimbolos.getVariable( this.variableName );
		ValorAsignacion p = v.getProperty( this.name );
		p.trans(float1);
	}

	@Override
	protected ValorAsignacion clone() {
		Property p = new Property( variableName, name );
		return p;
	}

	@Override
	public boolean igualQue(ValorAsignacion op2) {
		Variable v = tablaSimbolos.getVariable( this.variableName );
		ValorAsignacion p = v.getProperty( this.name );
		return p.igualQue(op2);
	}

	@Override
	public boolean distintoQue(ValorAsignacion op2) {
		return !igualQue(op2);
	}

	@Override
	public boolean menorQue(ValorAsignacion op2) {
		Variable v = tablaSimbolos.getVariable( this.variableName );
		ValorAsignacion p = v.getProperty( this.name );
		return p.menorQue(op2);
	}

	@Override
	public boolean menorIgualQue(ValorAsignacion op2) {
		Variable v = tablaSimbolos.getVariable( this.variableName );
		ValorAsignacion p = v.getProperty( this.name );
		return p.menorIgualQue(op2);
	}

	@Override
	public boolean mayorQue(ValorAsignacion op2) {
		Variable v = tablaSimbolos.getVariable( this.variableName );
		ValorAsignacion p = v.getProperty( this.name );
		return p.mayorQue(op2);
	}

	@Override
	public boolean mayorIgualQue(ValorAsignacion op2) {
		Variable v = tablaSimbolos.getVariable( this.variableName );
		ValorAsignacion p = v.getProperty( this.name );
		return p.mayorIgualQue(op2);
	}

	@Override
	public String getStringValue() {
		Variable v = tablaSimbolos.getVariable( this.variableName );
		ValorAsignacion p = v.getProperty( this.name );
		return p.getStringValue();
	}

	public void update() {
		Variable v = tablaSimbolos.getVariable( this.variableName );
		v.update();
	}

	public String toString() {
		return "Property:" + variableName + "->" + name;
	}

}
