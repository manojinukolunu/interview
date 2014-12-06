import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO : Wrap the entire Block in try catch
		String validate = "( 2 and 3 ) or not ( 6 )";
		String[] testCases = {"( 2 and 3 ) or not ( 6 )", "2 or 3", "2 or (3)",
				"2 and not(3)", "2 and (3 or (not 4 and 5))", "2 not and 3"

		};

		ArrayList<Integer> validIntegers = new ArrayList<Integer>();
		for (int i = 1; i < 100; i++) {
			validIntegers.add(i);
		}
		for (int j = 0; j < testCases.length; j++) {
			int parenCounter = 0;
			validate = testCases[j];
			// String must Definately end with right paren or number
			for (int i = 0; i < validate.length(); i++) {
				char currentChar = validate.charAt(i);
				char nextChar;
				switch (currentChar) {
					case '(' :
						parenCounter++;
						while (validate.charAt(i) == ' ') {
							i = i + 1;
						}
						nextChar = validate.charAt(i);
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
								} else {
									throw new Exception("Invalid String");
								}
							}
							if (parenCounter == 0) {
								i = i + 1;
								continue;
							}

							while (((i + 1) < validate.length())
									&& (validate.charAt(i) == ' ')) {
								i = i + 1;
							}
							nextChar = validate.charAt(i);
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
									parenCounter++;
									continue;
								case 'o' :
									if (!"or".equals(validate.substring(i + 1,
											i + 2))) {
										throw new Exception("Invalid String");
									}
									continue;
								case ')' :
									parenCounter--;
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
							while (validate.charAt(i) == ' ') {
								i = i + 1;
							}
							nextChar = validate.charAt(i);
							switch (nextChar) {
								case 'n' :
									if (!"not".equals(validate.substring(i,
											i + 3))) {
										throw new Exception("Invalid String");
									} else {
										// skip 3 chars
										i = i + 3;
										continue;
									}
								case '(' :
									parenCounter++;
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
							while (validate.charAt(i) == ' ') {
								i = i + 1;
							}
							nextChar = validate.charAt(i);
							switch (nextChar) {
								case '(' :
									parenCounter++;
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
							while (validate.charAt(i) == ' ') {
								i = i + 1;
							}
							nextChar = validate.charAt(i);
							switch (nextChar) {
								case '(' :
									parenCounter++;
									continue;
								case 'n' :
									if (!"not".equals(validate.substring(i,
											i + 3))) {
										throw new Exception("Invalid String");
									} else {
										i = i + 3;
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
}
