/**
 * Proyecto Sib - SI BEMOL, LENGUAJE DE PROGRAMACION MUSICAL
 * 
 * @author Antonio Blanco Oliva
 * @interface SibOutputController
 * @version 1.0
 * 
 */
package sib.inout;

import sib.models.datatype.NoteType;

public interface SibOutputController {

	public void playNote( NoteType note );

	public void print();

}
