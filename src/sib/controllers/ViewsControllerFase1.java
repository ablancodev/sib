package sib.controllers;

import java.io.StringReader;

import sib.cup.parser;
import sib.flex.AnalizadorLexicoFase2;
import sib.flex.AnalizadorLexicoSid;
import sib.flex.Token;
import sib.views.SibIDE;

public class ViewsControllerFase1 {

	private SibIDE view;
	
	public ViewsControllerFase1 ( SibIDE view ) {
		this.view = view;
	}

	/**
	 * Run Sib button action.
	 */
	public void actionRunButton() {
		view.cleanOutput(); // Limpiamos el Output
		
		view.printLog( "Running Sib..." );

		// Fase 1
		view.printLog( "Empezamos fase 1: limpieza de comentarios y salto de línea." );

		AnalizadorLexicoFase2 analizadorJFlex = null;
		try {

			analizadorJFlex = new AnalizadorLexicoFase2(  new StringReader( view.getInputString() ) );

			parser p = new parser( analizadorJFlex );
			p.setViewController( this );
			p.setOutputController( this.view.getOutputController() );
			p.setInputController( this.view.getInputController() );
			p.setTablaSimbolos( this.view.getTablaSimbolos() );
			p.parse();

			this.view.printMusicXML();

			//new parser( analizadorJFlex ).parse();

			/*
			view.cleanOutput();
			while (true) {
				// Obtener el token analizado y mostrar su información
				String cadena = analizadorJFlex.yylex();

				if (!analizadorJFlex.existenTokens()) {
					break;
				}

				view.printOutput( cadena );
			}
			*/
		} catch ( Exception t) { // capture errors
			view.printLog( "ERROR en línea " + analizadorJFlex.getLine() + "[" + analizadorJFlex.getColumn() + "]" );
			System.out.println(t.toString());
		}
		/*
		view.printLog( "Finalizada fase 1." );

		// Fase 2
		view.cleanInput();
		view.printInput( view.getOutputString() );
		view.cleanOutput();

		view.printLog( "Empezamos Fase 2: Análisis lexicográfico." );

		AnalizadorLexicoFase2 analizadorJFlex2 = null;
		try {
			analizadorJFlex2 = new AnalizadorLexicoFase2( new StringReader( view.getInputString() ) );

			view.cleanOutput();
			while (true) {
				// Obtener el token analizado y mostrar su información
				Token token = analizadorJFlex2.yylex();

				if (!analizadorJFlex2.existenTokens()) {
					break;
				}

				view.printOutput( token.toString() + "\n" );
			}
		} catch ( Exception t) { // capture errors
			view.printLog( "ERROR en línea " + analizadorJFlex2.getLine() + "[" + analizadorJFlex2.getColumn() + "]" );
			System.out.println(t.toString());
		}
		view.printLog( "Finalizada fase 2." );

		*/
	}

	/**
	 * Run Sid button action.
	 */
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

	public void printOutput( String s ) {
		view.printOutput( s );
	}
}
