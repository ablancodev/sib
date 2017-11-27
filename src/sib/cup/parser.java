
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package sib.cup;

import java_cup.runtime.*;
import java.io.*;
import sib.flex.*;
import sib.controllers.*;
import sib.inout.*;
import sib.models.nonterminal.*;
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
    "\000\037\000\002\002\006\000\002\002\004\000\002\003" +
    "\004\000\002\003\003\000\002\004\005\000\002\004\004" +
    "\000\002\004\004\000\002\007\005\000\002\007\003\000" +
    "\002\005\004\000\002\005\004\000\002\006\005\000\002" +
    "\010\003\000\002\010\003\000\002\010\003\000\002\010" +
    "\003\000\002\010\003\000\002\010\003\000\002\010\003" +
    "\000\002\010\003\000\002\011\003\000\002\011\003\000" +
    "\002\011\003\000\002\012\010\000\002\013\005\000\002" +
    "\013\005\000\002\013\005\000\002\013\005\000\002\013" +
    "\005\000\002\014\003\000\002\014\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\066\000\004\004\005\001\002\000\004\002\070\001" +
    "\002\000\004\005\006\001\002\000\006\007\014\010\012" +
    "\001\002\000\006\011\067\014\066\001\002\000\010\006" +
    "\065\007\014\010\012\001\002\000\010\006\ufffe\007\ufffe" +
    "\010\ufffe\001\002\000\004\007\060\001\002\000\004\011" +
    "\056\001\002\000\006\013\016\014\015\001\002\000\006" +
    "\011\ufff8\014\ufff8\001\002\000\024\007\026\015\021\016" +
    "\033\017\027\020\017\023\032\024\025\025\031\026\022" +
    "\001\002\000\004\011\ufff1\001\002\000\016\011\ufff0\027" +
    "\uffe4\030\uffe4\031\uffe4\032\uffe4\033\uffe4\001\002\000\004" +
    "\011\ufff4\001\002\000\020\011\uffeb\022\uffeb\027\uffeb\030" +
    "\uffeb\031\uffeb\032\uffeb\033\uffeb\001\002\000\004\011\uffee" +
    "\001\002\000\004\011\ufff6\001\002\000\020\011\uffed\022" +
    "\uffed\027\uffed\030\uffed\031\uffed\032\uffed\033\uffed\001\002" +
    "\000\016\011\ufff5\027\uffe3\030\uffe3\031\uffe3\032\uffe3\033" +
    "\uffe3\001\002\000\004\011\ufff2\001\002\000\004\011\uffef" +
    "\001\002\000\020\011\uffec\022\uffec\027\uffec\030\uffec\031" +
    "\uffec\032\uffec\033\uffec\001\002\000\004\021\051\001\002" +
    "\000\004\011\ufff3\001\002\000\014\027\036\030\040\031" +
    "\041\032\037\033\035\001\002\000\012\007\044\024\025" +
    "\025\031\026\022\001\002\000\012\007\044\024\025\025" +
    "\031\026\022\001\002\000\012\007\044\024\025\025\031" +
    "\026\022\001\002\000\012\007\044\024\025\025\031\026" +
    "\022\001\002\000\012\007\044\024\025\025\031\026\022" +
    "\001\002\000\004\011\uffe4\001\002\000\004\011\uffe7\001" +
    "\002\000\004\011\uffe3\001\002\000\004\011\uffe8\001\002" +
    "\000\004\011\uffe6\001\002\000\004\011\uffe9\001\002\000" +
    "\004\011\uffe5\001\002\000\004\007\052\001\002\000\004" +
    "\012\053\001\002\000\010\024\025\025\031\026\022\001" +
    "\002\000\004\022\055\001\002\000\004\011\uffea\001\002" +
    "\000\010\006\ufffb\007\ufffb\010\ufffb\001\002\000\006\011" +
    "\062\012\061\001\002\000\006\011\ufff9\012\ufff9\001\002" +
    "\000\004\007\063\001\002\000\010\006\ufffd\007\ufffd\010" +
    "\ufffd\001\002\000\006\011\ufffa\012\ufffa\001\002\000\010" +
    "\006\uffff\007\uffff\010\uffff\001\002\000\004\002\001\001" +
    "\002\000\006\011\ufff7\014\ufff7\001\002\000\010\006\ufffc" +
    "\007\ufffc\010\ufffc\001\002\000\004\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\066\000\004\002\003\001\001\000\002\001\001\000" +
    "\002\001\001\000\012\003\007\004\010\005\006\006\012" +
    "\001\001\000\002\001\001\000\010\004\063\005\006\006" +
    "\012\001\001\000\002\001\001\000\004\007\056\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\014\010\023\011\017\012\027\013\022\014\033\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\011\041\014\047\001\001\000" +
    "\006\011\041\014\046\001\001\000\006\011\041\014\045" +
    "\001\001\000\006\011\041\014\044\001\001\000\006\011" +
    "\041\014\042\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\011\053\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001" });

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
	public SibMusicXMLOutput output;
	public SibMusicXMLInput input;

	public TablaSimbolos tablaSimbolos;

	public void setViewController( ViewsControllerFase1 vc ) {
		this.viewsController = vc;
	}

	public void setOutputController( SibMusicXMLOutput output ) {
		this.output = output;
	}

	public void setInputController( SibMusicXMLInput input ) {
		this.input = input;
	}

	public void setTablaSimbolos( TablaSimbolos ts ) {
		this.tablaSimbolos = ts;
	}



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
          case 0: // programa ::= BEGIN IDENTIFICADOR instrucciones END 
            {
              Programa RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object id = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int instleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int instright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ListaInstrucciones inst = (ListaInstrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 
	Programa p = new Programa( tablaSimbolos );
	p.setInstrucciones( inst );
	p.exec();
	p.print( viewsController );

              CUP$parser$result = parser.getSymbolFactory().newSymbol("programa",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= programa EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Programa start_val = (Programa)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // instrucciones ::= instrucciones instruccion 
            {
              ListaInstrucciones RESULT =null;
		int instsleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int instsright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ListaInstrucciones insts = (ListaInstrucciones)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int insleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int insright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion ins = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 insts.add( ins ); RESULT = insts; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instrucciones",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // instrucciones ::= instruccion 
            {
              ListaInstrucciones RESULT =null;
		int insleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int insright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion ins = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new ListaInstrucciones( ins ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instrucciones",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // instruccion ::= TIPO lista_variables PUNTO_Y_COMA 
            {
              Instruccion RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object t = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int lvleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int lvright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ListaVariables lv = (ListaVariables)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
					RESULT = new InstDeclaracion( t.toString(), lv );
					
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruccion",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // instruccion ::= operador PUNTO_Y_COMA 
            {
              Instruccion RESULT =null;
		int opleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		InstOperador op = (InstOperador)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
					RESULT = op;  // InstOperador
					
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruccion",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // instruccion ::= asignacion PUNTO_Y_COMA 
            {
              Instruccion RESULT =null;
		int asleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int asright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		InstAsignacion as = (InstAsignacion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
					RESULT = as;  // InstAsignacion
					
              CUP$parser$result = parser.getSymbolFactory().newSymbol("instruccion",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // lista_variables ::= lista_variables COMA VARIABLE 
            {
              ListaVariables RESULT =null;
		int lvleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int lvright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		ListaVariables lv = (ListaVariables)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 lv.add( new Variable( v.toString() ) ); RESULT = lv; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("lista_variables",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // lista_variables ::= VARIABLE 
            {
              ListaVariables RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new ListaVariables( new Variable( v.toString() ) ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("lista_variables",5, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // operador ::= VARIABLE OPERADOR_NOTA 
            {
              InstOperador RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int onleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int onright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object on = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new InstOperador( new Variable( v.toString() ), on.toString() ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("operador",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // operador ::= operador OPERADOR_NOTA 
            {
              InstOperador RESULT =null;
		int opleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		InstOperador op = (InstOperador)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int onleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int onright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object on = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 op.addOperadorNota( on.toString() ); RESULT = op; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("operador",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // asignacion ::= VARIABLE IGUAL_SIMPLE valor_asignacion 
            {
              InstAsignacion RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ValorAsignacion valor = (ValorAsignacion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new InstAsignacion( new Variable( v.toString() ), valor ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("asignacion",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // valor_asignacion ::= VARIABLE 
            {
              ValorAsignacion RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Variable( v.toString() ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("valor_asignacion",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // valor_asignacion ::= STEP 
            {
              ValorAsignacion RESULT =null;
		int stleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int stright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object st = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new ValorCadena( st.toString() ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("valor_asignacion",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // valor_asignacion ::= CLEF_VALUE 
            {
              ValorAsignacion RESULT =null;
		int clleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int clright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object cl = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new ValorCadena( cl.toString() ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("valor_asignacion",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // valor_asignacion ::= ACCENT_VALUE 
            {
              ValorAsignacion RESULT =null;
		int acleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int acright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object ac = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new ValorCadena( ac.toString() ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("valor_asignacion",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // valor_asignacion ::= CADENA 
            {
              ValorAsignacion RESULT =null;
		int stleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int stright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object st = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new ValorCadena( st.toString() ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("valor_asignacion",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // valor_asignacion ::= tipo_numeros 
            {
              ValorAsignacion RESULT =null;
		int tnleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int tnright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		TipoNumero tn = (TipoNumero)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = tn; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("valor_asignacion",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // valor_asignacion ::= operacion_trans 
            {
              ValorAsignacion RESULT =null;
		int opleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int opright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		OperacionTrans op = (OperacionTrans)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = op; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("valor_asignacion",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // valor_asignacion ::= expresion_arit 
            {
              ValorAsignacion RESULT =null;
		int expleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int expright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ExpresionAritmetica exp = (ExpresionAritmetica)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = exp; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("valor_asignacion",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // tipo_numeros ::= NUMERO_ENTERO 
            {
              TipoNumero RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object n = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new TipoNumero( n.toString(), "int" ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("tipo_numeros",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // tipo_numeros ::= NUMERO_REAL 
            {
              TipoNumero RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object n = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new TipoNumero( n.toString(), "real" ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("tipo_numeros",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // tipo_numeros ::= NUMERO_INT_FRAC 
            {
              TipoNumero RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object n = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new TipoNumero( n.toString(), "int_frac" ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("tipo_numeros",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // operacion_trans ::= TRANS LPAREN VARIABLE COMA tipo_numeros RPAREN 
            {
              OperacionTrans RESULT =null;
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
		TipoNumero tn = (TipoNumero)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int rpleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rpright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object rp = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
				RESULT = new OperacionTrans( new Variable( v.toString() ), tn );
				
              CUP$parser$result = parser.getSymbolFactory().newSymbol("operacion_trans",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // expresion_arit ::= operando_arit MAS operando_arit 
            {
              ExpresionAritmetica RESULT =null;
		int oper1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int oper1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		OperandoAritmetico oper1 = (OperandoAritmetico)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int opleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object op = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int oper2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int oper2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		OperandoAritmetico oper2 = (OperandoAritmetico)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new ExpresionAritmetica( ExpresionAritmetica.MAS, oper1, oper2 ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion_arit",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // expresion_arit ::= operando_arit MENOS operando_arit 
            {
              ExpresionAritmetica RESULT =null;
		int oper1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int oper1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		OperandoAritmetico oper1 = (OperandoAritmetico)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int opleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object op = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int oper2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int oper2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		OperandoAritmetico oper2 = (OperandoAritmetico)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new ExpresionAritmetica( ExpresionAritmetica.MENOS, oper1, oper2 ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion_arit",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // expresion_arit ::= operando_arit DIV operando_arit 
            {
              ExpresionAritmetica RESULT =null;
		int oper1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int oper1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		OperandoAritmetico oper1 = (OperandoAritmetico)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int opleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object op = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int oper2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int oper2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		OperandoAritmetico oper2 = (OperandoAritmetico)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new ExpresionAritmetica( ExpresionAritmetica.DIV, oper1, oper2 ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion_arit",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // expresion_arit ::= operando_arit MULT operando_arit 
            {
              ExpresionAritmetica RESULT =null;
		int oper1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int oper1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		OperandoAritmetico oper1 = (OperandoAritmetico)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int opleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object op = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int oper2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int oper2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		OperandoAritmetico oper2 = (OperandoAritmetico)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new ExpresionAritmetica( ExpresionAritmetica.MULT, oper1, oper2 ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion_arit",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // expresion_arit ::= operando_arit MOD operando_arit 
            {
              ExpresionAritmetica RESULT =null;
		int oper1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int oper1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		OperandoAritmetico oper1 = (OperandoAritmetico)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int opleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int opright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object op = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int oper2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int oper2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		OperandoAritmetico oper2 = (OperandoAritmetico)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new ExpresionAritmetica( ExpresionAritmetica.MOD, oper1, oper2 ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("expresion_arit",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // operando_arit ::= tipo_numeros 
            {
              OperandoAritmetico RESULT =null;
		int numleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int numright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		TipoNumero num = (TipoNumero)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = num; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("operando_arit",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // operando_arit ::= VARIABLE 
            {
              OperandoAritmetico RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object v = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Variable( v.toString() ); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("operando_arit",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
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
