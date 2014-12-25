package hackerrank.strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindrome {

	public static boolean isPalindrome(String s) {
		int n = s.length();
		for (int i = 0; i < (n / 2) + 1; ++i) {
			if (s.charAt(i) != s.charAt(n - i - 1)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTestCases = Integer.parseInt(br.readLine());

		while (numTestCases-- > 0) {
			String line = br.readLine();
			if (line != null) {
				if (isPalindrome(line)) {
					System.out.println(-1);
				} else {
					StringBuilder builder = new StringBuilder(line);
					for (int i = 0; i < line.length(); i++) {
						if (isPalindrome(builder.substring(0, i)
								+ builder.substring(i + 1, builder.length()))) {
							System.out.println(i);
							break;
						}
					}
				}
			}

		}
	}
}
