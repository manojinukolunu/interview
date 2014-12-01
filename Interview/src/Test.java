import java.util.ArrayList;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

public class Test {
	public void test() throws Exception {
		while (true) {
			ANTLRInputStream input = new ANTLRInputStream(System.in);
			// Create an ExprLexer that feeds from that stream
			slaLexer lexer = new slaLexer(input);
			// Create a stream of tokens fed by the lexer
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			// Create a parser that feeds off the token stream
			slaParser parser = new slaParser(tokens);
			// Begin parsing at rule prog
			parser.prog();
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO : Wrap the entire Block in try catch
		String validate = "( 2 and 3 ) or not ( 6 )";
		int parenCounter = 0;
		ArrayList<Integer> validIntegers = new ArrayList<Integer>();
		for (int i = 1; i < 100; i++) {
			validIntegers.add(i);
		}
		// String must Definately end with right paren or number
		for (int i = 0; i < validate.length(); i++) {
			char currentChar = validate.charAt(i);
			char nextChar;
			switch (currentChar) {
				case '(' :
					parenCounter++;
					if (validate.charAt(i + 1) == (' ')) {
						i = i + 1;
						nextChar = validate.charAt(i + 1);
					} else {
						nextChar = validate.charAt(i + 1);
					}
					switch (nextChar) {
						case 'n' :
							// Check if the next 2 chars combined form a
							// 'not'
							if (!"not".equals(validate.substring(i + 1,
									i + 1 + 3))) {
								throw new Exception("Invalid String");
							}
							continue;
						case '(' :
							continue;
						default :
							if (Character.isDigit(nextChar)
									&& validIntegers.contains(Character
											.getNumericValue(nextChar))) {
								continue;
							} else {
								throw new Exception("Invalid String");
							}
					}
				case ')' :
					if (parenCounter > 0) {
						parenCounter--;
						if ((i + 1) == validate.length()) {
							// End of String reached
							// check if parenCounter = 0 and return;
							if (parenCounter == 0) {
								continue;
							}
						}
						if (parenCounter == 0) {
							continue;
						}
						if (((i + 1) < validate.length())
								&& (validate.charAt(i + 1) == (' '))) {
							i = i + 1;
							nextChar = validate.charAt(i);
						} else {
							nextChar = validate.charAt(i + 1);
						}
						switch (nextChar) {
							case 'a' :
								// Check if the next 2 chars combined form a
								// 'not'
								if (!"and".equals(validate.substring(i + 1,
										i + 3))) {
									throw new Exception("Invalid String");
								}
								continue;
							case '(' :
								continue;
							case 'o' :
								if (!"or".equals(validate.substring(i + 1,
										i + 2))) {
									throw new Exception("Invalid String");
								}
								continue;
							case ')' :
								continue;
							default :
								throw new Exception("Invalid String");
						}

					} else if (parenCounter == 0) {
						if (i == (validate.length() - 1)) {
							continue;
						} else {
							throw new Exception("Invalid String");
						}
					}
					continue;
				case 'a' :
					// get the next 3 characters and check if it is and
					if (!"and".equals(validate.substring(i, i + 3))) {
						throw new Exception("Invalid String");
					} else {
						// skip the next 2 characters
						i = i + 3;
						if (validate.charAt(i + 1) == (' ')) {
							i = i + 1;
							nextChar = validate.charAt(i + 1);
						} else {
							nextChar = validate.charAt(i + 1);
						}
						switch (nextChar) {
							case 'n' :
								if (!"not".equals(validate.substring(i, i + 3))) {
									throw new Exception("Invalid String");
								} else {
									continue;
								}
							case '(' :
								continue;
							default :
								if (Character.isDigit(nextChar)
										&& validIntegers.contains(Character
												.getNumericValue(nextChar))) {
									continue;
								} else {
									throw new Exception("Invalid String");
								}
						}
					}
				case 'n' :
					if (!"not".equals(validate.substring(i, i + 3))) {
						throw new Exception("Invalid String");
					} else {
						// skip the next 2 characters
						i = i + 3;
						if (validate.charAt(i + 1) == (' ')) {
							i = i + 1;
							nextChar = validate.charAt(i + 1);
						} else {
							nextChar = validate.charAt(i + 1);
						}
						switch (nextChar) {
							case '(' :
								continue;
							default :
								if (Character.isDigit(nextChar)
										&& validIntegers.contains(Character
												.getNumericValue(nextChar))) {
									continue;
								} else {
									throw new Exception("Invalid String");
								}
						}
					}
				case 'o' :
					if (!"or".equals(validate.substring(i, i + 2))) {
						throw new Exception("Invalid String");
					} else {
						// skip the next 1 character
						i = i + 2;
						if (validate.charAt(i + 1) == (' ')) {
							i = i + 1;
							nextChar = validate.charAt(i + 1);
						} else {
							nextChar = validate.charAt(i + 1);
						}
						switch (nextChar) {
							case '(' :
								continue;
							case 'n' :
								if (!"not".equals(validate.substring(i + 1,
										i + 1 + 3))) {
									throw new Exception("Invalid String");
								} else {
									continue;
								}
							default :
								if (Character.isDigit(nextChar)
										&& validIntegers.contains(Character
												.getNumericValue(nextChar))) {
									continue;
								} else {
									throw new Exception("Invalid String");
								}
						}
					}
				case ' ' :
					continue;
				default :
					if (Character.isDigit(currentChar)
							&& validIntegers.contains(Character
									.getNumericValue(currentChar))) {
						continue;
					}
			}
		}
		if (parenCounter == 0) {
			System.out.println("Valid String ...");
		}
	}
}
