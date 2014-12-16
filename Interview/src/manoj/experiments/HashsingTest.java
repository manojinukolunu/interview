package manoj.experiments;

public class HashsingTest {
	@SuppressWarnings("restriction")
	public static void main(String args[]) {
		String str = "Java Programming Language";
		System.out.println(str + " hashCode(): " + str.hashCode()
				+ " new Java 7 hashCode used by collections: "
				+ sun.misc.Hashing.stringHash32(str));
	}
}
