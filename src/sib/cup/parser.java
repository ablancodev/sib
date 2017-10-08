
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package sib.cup;

import java_cup.runtime.*;
import java.io.*;
import sib.flex.*;
import sib.controllers.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\012\000\002\002\004\000\002\002\004\000\002\003" +
    "\005\000\002\006\005\000\002\006\003\000\002\004\005" +
    "\000\002\004\002\000\002\005\005\000\002\007\005\000" +
    "\002\007\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\024\000\004\005\005\001\002\000\004\002\026\001" +
    "\002\000\004\007\020\001\002\000\006\002\ufffb\006\ufffb" +
    "\001\002\000\006\002\001\006\010\001\002\000\004\007" +
    "\013\001\002\000\004\011\012\001\002\000\006\002\ufffc" +
    "\006\ufffc\001\002\000\006\010\014\011\ufff8\001\002\000" +
    "\004\007\016\001\002\000\004\011\ufffa\001\002\000\006" +
    "\010\014\011\ufff8\001\002\000\004\011\ufff9\001\002\000" +
    "\006\010\021\011\023\001\002\000\004\007\024\001\002" +
    "\000\006\002\uffff\006\uffff\001\002\000\006\002\ufffd\006" +
    "\ufffd\001\002\000\006\010\021\011\023\001\002\000\006" +
    "\002\ufffe\006\ufffe\001\002\000\004\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\024\000\006\002\003\003\005\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\004\006\001\001\000\004" +
    "\005\010\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\007\014\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\007\016\001\001\000\002\001" +
    "\001\000\004\006\021\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\006\024\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




	public ViewsControllerFase1 viewsController;

	public void setViewController( ViewsControllerFase1 vc ) {
		this.viewsController = vc;
	}

	/*
	private Lexico lexico;

	public static void main(String[] arg){
		parser parserObj = new parser();
		lexico = new Lexico(new InputStreamReader(System.in));
		parserObj.setScanner(lexico);
		try{
			parserObj.parse();
		} catch(Exception x){
			System.out.println("Error fatal.");
		}
	}
	*/
	/* Este es el que estaba usando y funcionaba
	public static void main(String args[]) throws Exception {
		new parser( new AnalizadorLexicoFase2( new InputStreamReader( System.in ) ) ).parse();
	}
	*/


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // programa ::= paquete imports 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("programa",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= programa EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // paquete ::= PACKAGE IDENTIFICADOR mas_paquete 
            {
              Object RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object id = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int mpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int mpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String mp = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 viewsController.printOutput( "\nPACKAGE:" + id.toString() + mp ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("paquete",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // mas_paquete ::= PUNTO IDENTIFICADOR mas_paquete 
            {
              String RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object p = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object id = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int mpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int mpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String mp = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new String( "" + p.toString() + id.toString() + mp.toString() ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("mas_paquete",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // mas_paquete ::= PUNTO_Y_COMA 
            {
              String RESULT =null;
		 RESULT = ";"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("mas_paquete",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // imports ::= imports un_import PUNTO_Y_COMA 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("imports",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // imports ::= 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("imports",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // un_import ::= IMPORT IDENTIFICADOR mas_import 
            {
              Object RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object id = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int mpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int mpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String mp = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 viewsController.printOutput( "\nIMPORT:" + id.toString() + mp ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("un_import",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // mas_import ::= PUNTO IDENTIFICADOR mas_import 
            {
              String RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object p = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object id = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int mpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int mpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String mp = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new String( "" + p.toString() + id.toString() + mp.toString() ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("mas_import",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // mas_import ::= 
            {
              String RESULT =null;
		 RESULT = ""; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("mas_import",5, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
