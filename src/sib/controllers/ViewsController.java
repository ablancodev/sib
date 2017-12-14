/**
 * Proyecto Sib - SI BEMOL, LENGUAJE DE PROGRAMACION MUSICAL
 * 
 * @author Antonio Blanco Oliva
 * @class ViewsController
 * @version 1.0
 * 
 */
package sib.controllers;

import java.io.StringReader;

import sib.cup.parser;
import sib.flex.*;
import sib.flex.Token;
import sib.inout.SibInputController;
import sib.inout.SibMusicXMLInput;
import sib.inout.SibMusicXMLOutput;
import sib.inout.SibOutputController;
import sib.models.datatype.DataType;
import sib.models.datatype.PartitureType;
import sib.models.nonterminal.TablaSimbolos;
import sib.models.nonterminal.Variable;
import sib.views.SibIDE;

public class ViewsController {

	private SibIDE view;

	TablaSimbolos tablaSimbolos;

	SibOutputController output;
	SibInputController input;

	/**
	 * Variable global que contiene el 'estado' de la partitura.
	 */
	public PartitureType partiture;

	public ViewsController ( SibIDE view ) {
		this.view = view;
	}

	/**
	 * Run Sib button action.
	 */
	public void actionRunButton() {
		view.cleanOutput(); // Limpiamos el Output
		
		view.printLog( "Running Sib..." );

		AnalizadorLexico analizadorJFlex = null;
		try {

			analizadorJFlex = new AnalizadorLexico(  new StringReader( view.getInputString() ) );

			@SuppressWarnings("deprecation")
			parser p = new parser( analizadorJFlex );
			p.setViewController( this );

			// Inicializamos partiture
			partiture = new PartitureType();

			// Tabla simbolos
			tablaSimbolos = new TablaSimbolos();
			// Metemos la variable global partiture
			Variable part = new Variable( "$partiture", tablaSimbolos );
			part.setType( DataType.TYPE_PARTITURE );
			part.setValue( partiture );
			tablaSimbolos.addVariable( part );

			// input / output controllers
			output = new SibMusicXMLOutput( tablaSimbolos, view );
			input = new SibMusicXMLInput( tablaSimbolos );
			p.setOutputController( output );
			p.setInputController( input );

			p.setTablaSimbolos( tablaSimbolos );
			p.parse();

			output.print();

		} catch ( Exception t) { // capture errors
			view.printLog( "ERROR en línea " + analizadorJFlex.getLine() + "[" + analizadorJFlex.getColumn() + "]" );
			System.out.println(t.toString());
		}

	}

	/**
	 * Run Sid button action.
	 */
	/*
	public void actionRunSidButton() {
		view.printLog( "Running Sid..." );
		AnalizadorLexicoSid analizadorJFlex = null;
		try {
			analizadorJFlex = new AnalizadorLexicoSid( new StringReader( view.getInputString() ) );

			while (true) {

				// Obtener el token analizado y mostrar su información
				Token token = analizadorJFlex.yylex();

				if (!analizadorJFlex.existenTokens()) {
					break;
				}

				view.printLog( "Línea " + analizadorJFlex.linea + ":");
				view.printLog(token.toString());
			}
		} catch (Exception e) {
			view.printLog( "ERROR en línea " + analizadorJFlex.linea );
			System.out.println(e.toString());
		}
	}
	*/

	public void printOutput( String s ) {
		view.printOutput( s );
	}

	public void printLog( String s ) {
		view.printLog( s );
	}

}
