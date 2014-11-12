package cracking.the.coding.interview.chapter1;

public class Prob15 {

	public static String compress(String str) {
		int i = 0;
		int count = 1;
		char prev_char = str.charAt(0);
		StringBuffer buff = new StringBuffer();
		buff.append(prev_char);
		for (i = 1; i < str.length(); i++) {
			if (str.charAt(i) == prev_char) {
				count++;
			} else {
				buff.append(count);
				count = 1;
				prev_char = str.charAt(i);
				buff.append(str.charAt(i));
			}
			if (i == (str.length() - 1)) {
				buff.append(count);
			}
		}
		if (buff.length() >= str.length()) {
			return str;
		} else {
			return buff.toString();
		}
	}
	public static void main(String args[]) {
		System.out.println(compress("bbbccccd"));
	}
}
