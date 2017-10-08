package sib.controllers;

import java.awt.Color;
import java.io.StringReader;

import javax.swing.JFrame;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import sib.flex.AnalizadorLexico;
import sib.flex.AnalizadorLexicoSid;
import sib.flex.Token;
import sib.views.SibIDE;

public class ViewsController {

	private SibIDE view;
	
	public ViewsController ( SibIDE view ) {
		this.view = view;
	}

	/**
	 * Run Sib button action.
	 */
	public void actionRunButton() {
		view.printLog( "Running Sib..." );
		AnalizadorLexico analizadorJFlex = null;
		try {
			analizadorJFlex = new AnalizadorLexico( new StringReader( view.getInputString() ) );

			while (true) {

				// Obtener el token analizado y mostrar su información
				Token token = analizadorJFlex.yylex();

				if (!analizadorJFlex.existenTokens()) {
					break;
				}

				view.printLog(token.toString());
			}
		//} catch (Throwable t) { // capture errors
		} catch ( Exception t) { // capture errors
			view.printLog( "ERROR en línea " + analizadorJFlex.numLinea );
			System.out.println(t.toString());
		}
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

}
