package sib.inout;

import org.w3c.dom.Document;

import sib.models.datatype.NoteType;
import sib.models.datatype.PartitureType;
import sib.models.nonterminal.TablaSimbolos;

public class SibMusicXMLInput implements SibInputController {

	protected TablaSimbolos tablaSimbolos;
	public Document doc;

	public SibMusicXMLInput( TablaSimbolos ts ) {
		tablaSimbolos = ts;
	}

	public void readPartiture() {
		// @todo implementarlo - Devuelve void, porque escribirá sobre la variable global $partiture
	}

	public NoteType readNote() {
		// @todo implementarlo
		return null;
	}

}
