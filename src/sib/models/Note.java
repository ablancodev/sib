package sib.models;

/**
 * Representa el tipo de datos note
 *
 * @author Antonio Blanco
 *
 */
public class Note extends Object{

	public String value = "C"; // @todo cambiar tipo a step

	public int duration = 4; // @todo cambiar tipo a nfrac

	public int octave = 4;

	public int dots = 0;

	public String accent = "";

}
