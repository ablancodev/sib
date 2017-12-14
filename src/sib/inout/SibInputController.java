/**
 * Proyecto Sib - SI BEMOL, LENGUAJE DE PROGRAMACION MUSICAL
 * 
 * @author Antonio Blanco Oliva
 * @interface SibInputController
 * @version 1.0
 * 
 */
package sib.inout;

import sib.models.datatype.NoteType;

public interface SibInputController {

	public void readPartiture();

	public NoteType readNote();

}
