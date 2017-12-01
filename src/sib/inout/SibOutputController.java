package sib.inout;

import sib.models.Note;

public interface SibOutputController {

	public void playPartiture();

	public void playNote( Note note );

	public void print();

}
