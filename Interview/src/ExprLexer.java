// $ANTLR 3.5.1 /home/manoj/Desktop/Expr.g 2014-11-30 22:21:28

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExprLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ExprLexer() {} 
	public ExprLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ExprLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/home/manoj/Desktop/Expr.g"; }

	// $ANTLR start "T__8"
	public final void mT__8() throws RecognitionException {
		try {
			int _type = T__8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/manoj/Desktop/Expr.g:2:6: ( '(' )
			// /home/manoj/Desktop/Expr.g:2:8: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__8"

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/manoj/Desktop/Expr.g:3:6: ( ')' )
			// /home/manoj/Desktop/Expr.g:3:8: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/manoj/Desktop/Expr.g:4:7: ( '*' )
			// /home/manoj/Desktop/Expr.g:4:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/manoj/Desktop/Expr.g:5:7: ( '=' )
			// /home/manoj/Desktop/Expr.g:5:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/manoj/Desktop/Expr.g:6:7: ( 'and' )
			// /home/manoj/Desktop/Expr.g:6:9: 'and'
			{
			match("and"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/manoj/Desktop/Expr.g:7:7: ( 'or' )
			// /home/manoj/Desktop/Expr.g:7:9: 'or'
			{
			match("or"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__13"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/manoj/Desktop/Expr.g:21:4: ( ( 'NOT' | 'not' ) ( 'a' .. 'z' | 'A' .. 'Z' )+ )
			// /home/manoj/Desktop/Expr.g:21:6: ( 'NOT' | 'not' ) ( 'a' .. 'z' | 'A' .. 'Z' )+
			{
			// /home/manoj/Desktop/Expr.g:21:6: ( 'NOT' | 'not' )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='N') ) {
				alt1=1;
			}
			else if ( (LA1_0=='n') ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// /home/manoj/Desktop/Expr.g:21:7: 'NOT'
					{
					match("NOT"); 

					}
					break;
				case 2 :
					// /home/manoj/Desktop/Expr.g:21:13: 'not'
					{
					match("not"); 

					}
					break;

			}

			// /home/manoj/Desktop/Expr.g:21:19: ( 'a' .. 'z' | 'A' .. 'Z' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= 'A' && LA2_0 <= 'Z')||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /home/manoj/Desktop/Expr.g:
					{
					if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/manoj/Desktop/Expr.g:22:5: ( ( 'NOT' | 'not' ) ( '0' .. '9' )+ )
			// /home/manoj/Desktop/Expr.g:22:7: ( 'NOT' | 'not' ) ( '0' .. '9' )+
			{
			// /home/manoj/Desktop/Expr.g:22:7: ( 'NOT' | 'not' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='N') ) {
				alt3=1;
			}
			else if ( (LA3_0=='n') ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /home/manoj/Desktop/Expr.g:22:8: 'NOT'
					{
					match("NOT"); 

					}
					break;
				case 2 :
					// /home/manoj/Desktop/Expr.g:22:14: 'not'
					{
					match("not"); 

					}
					break;

			}

			// /home/manoj/Desktop/Expr.g:22:20: ( '0' .. '9' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /home/manoj/Desktop/Expr.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/manoj/Desktop/Expr.g:23:9: ( ( '\\r' )? '\\n' )
			// /home/manoj/Desktop/Expr.g:23:11: ( '\\r' )? '\\n'
			{
			// /home/manoj/Desktop/Expr.g:23:11: ( '\\r' )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='\r') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /home/manoj/Desktop/Expr.g:23:11: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/manoj/Desktop/Expr.g:24:4: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// /home/manoj/Desktop/Expr.g:24:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// /home/manoj/Desktop/Expr.g:24:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '\t' && LA6_0 <= '\n')||LA6_0=='\r'||LA6_0==' ') ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /home/manoj/Desktop/Expr.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// /home/manoj/Desktop/Expr.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | ID | INT | NEWLINE | WS )
		int alt7=10;
		switch ( input.LA(1) ) {
		case '(':
			{
			alt7=1;
			}
			break;
		case ')':
			{
			alt7=2;
			}
			break;
		case '*':
			{
			alt7=3;
			}
			break;
		case '=':
			{
			alt7=4;
			}
			break;
		case 'a':
			{
			alt7=5;
			}
			break;
		case 'o':
			{
			alt7=6;
			}
			break;
		case 'N':
			{
			int LA7_7 = input.LA(2);
			if ( (LA7_7=='O') ) {
				int LA7_12 = input.LA(3);
				if ( (LA7_12=='T') ) {
					int LA7_15 = input.LA(4);
					if ( ((LA7_15 >= 'A' && LA7_15 <= 'Z')||(LA7_15 >= 'a' && LA7_15 <= 'z')) ) {
						alt7=7;
					}
					else if ( ((LA7_15 >= '0' && LA7_15 <= '9')) ) {
						alt7=8;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 7, 15, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
							input.consume();
						}
						NoViableAltException nvae =
							new NoViableAltException("", 7, 12, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 7, 7, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case 'n':
			{
			int LA7_8 = input.LA(2);
			if ( (LA7_8=='o') ) {
				int LA7_13 = input.LA(3);
				if ( (LA7_13=='t') ) {
					int LA7_16 = input.LA(4);
					if ( ((LA7_16 >= 'A' && LA7_16 <= 'Z')||(LA7_16 >= 'a' && LA7_16 <= 'z')) ) {
						alt7=7;
					}
					else if ( ((LA7_16 >= '0' && LA7_16 <= '9')) ) {
						alt7=8;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 7, 16, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
							input.consume();
						}
						NoViableAltException nvae =
							new NoViableAltException("", 7, 13, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 7, 8, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case '\r':
			{
			int LA7_9 = input.LA(2);
			if ( (LA7_9=='\n') ) {
				int LA7_10 = input.LA(3);
				if ( ((LA7_10 >= '\t' && LA7_10 <= '\n')||LA7_10=='\r'||LA7_10==' ') ) {
					alt7=10;
				}

				else {
					alt7=9;
				}

			}

			else {
				alt7=10;
			}

			}
			break;
		case '\n':
			{
			int LA7_10 = input.LA(2);
			if ( ((LA7_10 >= '\t' && LA7_10 <= '\n')||LA7_10=='\r'||LA7_10==' ') ) {
				alt7=10;
			}

			else {
				alt7=9;
			}

			}
			break;
		case '\t':
		case ' ':
			{
			alt7=10;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 7, 0, input);
			throw nvae;
		}
		switch (alt7) {
			case 1 :
				// /home/manoj/Desktop/Expr.g:1:10: T__8
				{
				mT__8(); 

				}
				break;
			case 2 :
				// /home/manoj/Desktop/Expr.g:1:15: T__9
				{
				mT__9(); 

				}
				break;
			case 3 :
				// /home/manoj/Desktop/Expr.g:1:20: T__10
				{
				mT__10(); 

				}
				break;
			case 4 :
				// /home/manoj/Desktop/Expr.g:1:26: T__11
				{
				mT__11(); 

				}
				break;
			case 5 :
				// /home/manoj/Desktop/Expr.g:1:32: T__12
				{
				mT__12(); 

				}
				break;
			case 6 :
				// /home/manoj/Desktop/Expr.g:1:38: T__13
				{
				mT__13(); 

				}
				break;
			case 7 :
				// /home/manoj/Desktop/Expr.g:1:44: ID
				{
				mID(); 

				}
				break;
			case 8 :
				// /home/manoj/Desktop/Expr.g:1:47: INT
				{
				mINT(); 

				}
				break;
			case 9 :
				// /home/manoj/Desktop/Expr.g:1:51: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 10 :
				// /home/manoj/Desktop/Expr.g:1:59: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
