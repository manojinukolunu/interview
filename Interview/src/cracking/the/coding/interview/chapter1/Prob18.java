package cracking.the.coding.interview.chapter1;

public class Prob18 {

	public static void main(String args[]) {
		String s1 = "wa";
		String s2 = "aw";
		System.out.println(isRotation(s1, s2));
	}

	private static String isRotation(String s1, String s2) {
		String s3 = s1 + s1;
		if (s3.indexOf(s2) > 0) {
			return s1;
		}
		return null;
	}

}
