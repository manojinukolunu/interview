// $ANTLR 3.5.1 /home/manoj/Desktop/Expr.g 2014-11-30 22:21:28

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExprParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "NEWLINE", "WS", 
		"'('", "')'", "'*'", "'='", "'and'", "'or'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int ID=4;
	public static final int INT=5;
	public static final int NEWLINE=6;
	public static final int WS=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ExprParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ExprParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ExprParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/manoj/Desktop/Expr.g"; }



	// $ANTLR start "prog"
	// /home/manoj/Desktop/Expr.g:3:1: prog : ( stat )+ ;
	public final void prog() throws RecognitionException {
		try {
			// /home/manoj/Desktop/Expr.g:3:7: ( ( stat )+ )
			// /home/manoj/Desktop/Expr.g:3:9: ( stat )+
			{
			// /home/manoj/Desktop/Expr.g:3:9: ( stat )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= ID && LA1_0 <= NEWLINE)||LA1_0==8) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/manoj/Desktop/Expr.g:3:9: stat
					{
					pushFollow(FOLLOW_stat_in_prog11);
					stat();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "prog"



	// $ANTLR start "stat"
	// /home/manoj/Desktop/Expr.g:5:1: stat : ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE );
	public final void stat() throws RecognitionException {
		try {
			// /home/manoj/Desktop/Expr.g:5:6: ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE )
			int alt2=3;
			switch ( input.LA(1) ) {
			case INT:
			case 8:
				{
				alt2=1;
				}
				break;
			case ID:
				{
				int LA2_2 = input.LA(2);
				if ( (LA2_2==11) ) {
					alt2=2;
				}
				else if ( (LA2_2==NEWLINE||LA2_2==10||(LA2_2 >= 12 && LA2_2 <= 13)) ) {
					alt2=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case NEWLINE:
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// /home/manoj/Desktop/Expr.g:5:8: expr NEWLINE
					{
					pushFollow(FOLLOW_expr_in_stat20);
					expr();
					state._fsp--;

					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat22); 
					}
					break;
				case 2 :
					// /home/manoj/Desktop/Expr.g:6:4: ID '=' expr NEWLINE
					{
					match(input,ID,FOLLOW_ID_in_stat27); 
					match(input,11,FOLLOW_11_in_stat29); 
					pushFollow(FOLLOW_expr_in_stat31);
					expr();
					state._fsp--;

					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat33); 
					}
					break;
				case 3 :
					// /home/manoj/Desktop/Expr.g:7:4: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat38); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "stat"



	// $ANTLR start "expr"
	// /home/manoj/Desktop/Expr.g:10:1: expr : multExpr ( ( 'and' | 'or' ) multExpr )* ;
	public final void expr() throws RecognitionException {
		try {
			// /home/manoj/Desktop/Expr.g:10:7: ( multExpr ( ( 'and' | 'or' ) multExpr )* )
			// /home/manoj/Desktop/Expr.g:10:9: multExpr ( ( 'and' | 'or' ) multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_expr49);
			multExpr();
			state._fsp--;

			// /home/manoj/Desktop/Expr.g:10:18: ( ( 'and' | 'or' ) multExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= 12 && LA3_0 <= 13)) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/manoj/Desktop/Expr.g:10:19: ( 'and' | 'or' ) multExpr
					{
					if ( (input.LA(1) >= 12 && input.LA(1) <= 13) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multExpr_in_expr58);
					multExpr();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expr"



	// $ANTLR start "multExpr"
	// /home/manoj/Desktop/Expr.g:13:1: multExpr : atom ( '*' atom )* ;
	public final void multExpr() throws RecognitionException {
		try {
			// /home/manoj/Desktop/Expr.g:13:9: ( atom ( '*' atom )* )
			// /home/manoj/Desktop/Expr.g:13:11: atom ( '*' atom )*
			{
			pushFollow(FOLLOW_atom_in_multExpr70);
			atom();
			state._fsp--;

			// /home/manoj/Desktop/Expr.g:13:16: ( '*' atom )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==10) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /home/manoj/Desktop/Expr.g:13:17: '*' atom
					{
					match(input,10,FOLLOW_10_in_multExpr73); 
					pushFollow(FOLLOW_atom_in_multExpr75);
					atom();
					state._fsp--;

					}
					break;

				default :
					break loop4;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "multExpr"



	// $ANTLR start "atom"
	// /home/manoj/Desktop/Expr.g:16:1: atom : ( INT | ID | '(' expr ')' );
	public final void atom() throws RecognitionException {
		try {
			// /home/manoj/Desktop/Expr.g:16:6: ( INT | ID | '(' expr ')' )
			int alt5=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt5=1;
				}
				break;
			case ID:
				{
				alt5=2;
				}
				break;
			case 8:
				{
				alt5=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// /home/manoj/Desktop/Expr.g:16:8: INT
					{
					match(input,INT,FOLLOW_INT_in_atom87); 
					}
					break;
				case 2 :
					// /home/manoj/Desktop/Expr.g:17:4: ID
					{
					match(input,ID,FOLLOW_ID_in_atom92); 
					}
					break;
				case 3 :
					// /home/manoj/Desktop/Expr.g:18:4: '(' expr ')'
					{
					match(input,8,FOLLOW_8_in_atom97); 
					pushFollow(FOLLOW_expr_in_atom99);
					expr();
					state._fsp--;

					match(input,9,FOLLOW_9_in_atom101); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "atom"

	// Delegated rules



	public static final BitSet FOLLOW_stat_in_prog11 = new BitSet(new long[]{0x0000000000000172L});
	public static final BitSet FOLLOW_expr_in_stat20 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NEWLINE_in_stat22 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat27 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_stat29 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_expr_in_stat31 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NEWLINE_in_stat33 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_stat38 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr49 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_set_in_expr52 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_multExpr_in_expr58 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_atom_in_multExpr70 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_multExpr73 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_atom_in_multExpr75 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_INT_in_atom87 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_atom97 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_expr_in_atom99 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_atom101 = new BitSet(new long[]{0x0000000000000002L});
}
