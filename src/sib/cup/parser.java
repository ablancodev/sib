
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
    "\000\046\000\002\002\010\000\002\002\004\000\002\003" +
    "\005\000\002\023\005\000\002\023\003\000\002\004\005" +
    "\000\002\004\002\000\002\005\005\000\002\024\005\000" +
    "\002\024\002\000\002\006\004\000\002\006\002\000\002" +
    "\007\003\000\002\007\003\000\002\010\004\000\002\011" +
    "\004\000\002\012\005\000\002\012\003\000\002\013\004" +
    "\000\002\013\004\000\002\014\004\000\002\014\004\000" +
    "\002\015\005\000\002\016\003\000\002\016\003\000\002" +
    "\016\003\000\002\016\003\000\002\016\003\000\002\016" +
    "\003\000\002\016\003\000\002\016\003\000\002\022\010" +
    "\000\002\017\003\000\002\017\003\000\002\017\003\000" +
    "\002\020\005\000\002\021\003\000\002\021\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\102\000\004\005\005\001\002\000\004\002\104\001" +
    "\002\000\004\007\076\001\002\000\006\006\ufffb\014\ufffb" +
    "\001\002\000\006\006\010\014\011\001\002\000\004\007" +
    "\071\001\002\000\004\007\014\001\002\000\004\012\013" +
    "\001\002\000\006\006\ufffc\014\ufffc\001\002\000\010\015" +
    "\ufff6\021\ufff6\022\ufff6\001\002\000\010\015\022\021\023" +
    "\022\025\001\002\000\006\012\070\023\067\001\002\000" +
    "\010\015\ufff4\021\ufff4\022\ufff4\001\002\000\010\015\ufff5" +
    "\021\ufff5\022\ufff5\001\002\000\010\015\ufff7\021\ufff7\022" +
    "\ufff7\001\002\000\004\002\001\001\002\000\004\022\061" +
    "\001\002\000\004\012\057\001\002\000\006\013\027\023" +
    "\026\001\002\000\006\012\uffed\023\uffed\001\002\000\024" +
    "\020\041\022\037\024\032\025\042\026\036\027\030\030" +
    "\035\031\040\032\034\001\002\000\004\012\uffe6\001\002" +
    "\000\006\012\uffe5\033\uffdd\001\002\000\004\012\uffe9\001" +
    "\002\000\004\012\uffe4\001\002\000\006\012\uffdf\033\uffdf" +
    "\001\002\000\006\012\uffe1\033\uffe1\001\002\000\004\012" +
    "\uffe7\001\002\000\006\012\uffea\033\uffdc\001\002\000\006" +
    "\012\uffe0\033\uffe0\001\002\000\004\016\052\001\002\000" +
    "\004\012\uffe8\001\002\000\004\012\uffe3\001\002\000\004" +
    "\012\uffeb\001\002\000\004\033\046\001\002\000\012\022" +
    "\051\030\035\031\040\032\034\001\002\000\004\012\uffdd" +
    "\001\002\000\004\012\uffde\001\002\000\004\012\uffdc\001" +
    "\002\000\004\022\053\001\002\000\004\011\054\001\002" +
    "\000\004\032\055\001\002\000\004\017\056\001\002\000" +
    "\004\012\uffe2\001\002\000\010\015\uffee\021\uffee\022\uffee" +
    "\001\002\000\010\015\ufff3\021\ufff3\022\ufff3\001\002\000" +
    "\006\011\063\012\064\001\002\000\010\015\ufff2\021\ufff2" +
    "\022\ufff2\001\002\000\004\022\065\001\002\000\010\015" +
    "\ufff0\021\ufff0\022\ufff0\001\002\000\006\011\063\012\064" +
    "\001\002\000\010\015\ufff1\021\ufff1\022\ufff1\001\002\000" +
    "\006\012\uffec\023\uffec\001\002\000\010\015\uffef\021\uffef" +
    "\022\uffef\001\002\000\006\010\072\012\ufff8\001\002\000" +
    "\004\007\074\001\002\000\004\012\ufffa\001\002\000\006" +
    "\010\072\012\ufff8\001\002\000\004\012\ufff9\001\002\000" +
    "\006\010\077\012\101\001\002\000\004\007\102\001\002" +
    "\000\006\006\uffff\014\uffff\001\002\000\006\006\ufffd\014" +
    "\ufffd\001\002\000\006\010\077\012\101\001\002\000\006" +
    "\006\ufffe\014\ufffe\001\002\000\004\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\102\000\006\002\003\003\005\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\004\006\001\001\000\004" +
    "\005\011\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\006\014\001\001" +
    "\000\014\007\020\010\017\013\016\014\015\015\023\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\011\057\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\014\016\043\017\030\020\032\021\044\022\042\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\017\046\021\047\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\012\061\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\012\065\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\024\072\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\024\074\001\001\000\002\001\001\000\004\023\077" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\023\102\001\001\000\002\001\001\000\002" +
    "\001\001" });

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
          case 0: // programa ::= paquete imports BEGIN IDENTIFICADOR instrucciones END 
            {
              Object RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object id = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		 viewsController.printOutput( "\nEl programa se llama:" + id ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("programa",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
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
              CUP$parser$result = parser.getSymbolFactory().newSymbol("mas_paquete",17, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // mas_paquete ::= PUNTO_Y_COMA 
            {
              String RESULT =null;
		 RESULT = ";"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("mas_paquete",17, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
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
              CUP$parser$result = parser.getSymbolFactory().newSymbol("mas_import",18, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // mas_import ::= 
            {
              String RESULT =null;
		 RESULT = ""; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("mas_import",18, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // instrucciones ::= instrucciones instruccion 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("instrucciones",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // instrucciones ::= 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("instrucciones",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // instruccion ::= declaracion 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruccion",5, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // instruccion ::= orden 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruccion",5, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // declaracion ::= TIPO lista_variables 
            {
              Object RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object t = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int lvleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int lvright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object lv = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 viewsController.printOutput( "\nDefinido:" + t + " " + lv ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("declaracion",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // lista_variables ::= VARIABLE mas_lista_variables 
            {
              Object RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int mlvleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int mlvright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object mlv = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = v + " " + mlv;  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("lista_variables",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // mas_lista_variables ::= COMA VARIABLE mas_lista_variables 
            {
              Object RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int mlvleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int mlvright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object mlv = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = ", " + v + mlv;  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("mas_lista_variables",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // mas_lista_variables ::= PUNTO_Y_COMA 
            {
              Object RESULT =null;
		 RESULT = ";"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("mas_lista_variables",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // orden ::= operador PUNTO_Y_COMA 
            {
              Object RESULT =null;
		int opleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object op = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 viewsController.printOutput( "\nOrden->operador:" + op ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("orden",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // orden ::= asignacion PUNTO_Y_COMA 
            {
              Object RESULT =null;
		int asleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int asright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object as = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		  viewsController.printOutput( "\nAsignación:" + as ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("orden",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // operador ::= VARIABLE OPERADOR_NOTA 
            {
              Object RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int onleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int onright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object on = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = v + "<--" + on;  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("operador",10, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // operador ::= operador OPERADOR_NOTA 
            {
              Object RESULT =null;
		int opleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object op = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int onleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int onright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object on = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = op + "<--" + on;  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("operador",10, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // asignacion ::= VARIABLE IGUAL_SIMPLE origen_asignacion 
            {
              Object RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int oaleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int oaright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object oa = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = v + "<--" + oa; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("asignacion",11, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // origen_asignacion ::= VARIABLE 
            {
              Object RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = v; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("origen_asignacion",12, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // origen_asignacion ::= STEP 
            {
              Object RESULT =null;
		int stleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int stright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object st = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = st; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("origen_asignacion",12, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // origen_asignacion ::= CLEF_VALUE 
            {
              Object RESULT =null;
		int clleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int clright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object cl = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = cl; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("origen_asignacion",12, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // origen_asignacion ::= ACCENT_VALUE 
            {
              Object RESULT =null;
		int acleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int acright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object ac = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = ac; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("origen_asignacion",12, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // origen_asignacion ::= CADENA 
            {
              Object RESULT =null;
		int stleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int stright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object st = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = st; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("origen_asignacion",12, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // origen_asignacion ::= tipo_numeros 
            {
              Object RESULT =null;
		int tnleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int tnright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object tn = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = tn; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("origen_asignacion",12, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // origen_asignacion ::= expresion_arit 
            {
              Object RESULT =null;
		int expleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int expright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object exp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = exp; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("origen_asignacion",12, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // origen_asignacion ::= operacion 
            {
              Object RESULT =null;
		int opleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int opright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object op = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = op; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("origen_asignacion",12, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // operacion ::= TRANS LPAREN VARIABLE COMA NUMERO_INT_FRAC RPAREN 
            {
              Object RESULT =null;
		int trleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left;
		int trright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).right;
		Object tr = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-5)).value;
		int lpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int lpright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Object lp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int ccleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int ccright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object cc = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int tnleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int tnright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object tn = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int rpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object rp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = tr.toString() + lp + v + cc + tn + rp; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("operacion",16, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // tipo_numeros ::= NUMERO_ENTERO 
            {
              Object RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object n = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = n; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("tipo_numeros",13, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // tipo_numeros ::= NUMERO_REAL 
            {
              Object RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object n = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = n; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("tipo_numeros",13, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // tipo_numeros ::= NUMERO_INT_FRAC 
            {
              Object RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object n = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = n; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("tipo_numeros",13, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // expresion_arit ::= operando_arit OPERADOR_ARIT operando_arit 
            {
              Object RESULT =null;
		int oper1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int oper1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object oper1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int opleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object op = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int oper2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int oper2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object oper2 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = oper1.toString() + op + oper2.toString(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion_arit",14, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // operando_arit ::= tipo_numeros 
            {
              Object RESULT =null;
		int numleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int numright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object num = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = num; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("operando_arit",15, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // operando_arit ::= VARIABLE 
            {
              Object RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = v; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("operando_arit",15, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
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
