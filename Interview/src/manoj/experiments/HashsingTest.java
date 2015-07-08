package manoj.experiments;

import java.util.HashMap;

public class HashsingTest {

	public void HashTest() {
		HashMap<String, String> hash1 = new HashMap<String, String>();
		
		hash1.put("asdf","asdf");
		hash1.get("asdf");
	}

	@SuppressWarnings("restriction")
	public static void main(String args[]) {
		String str = "Java Programming Language";
		System.out.println(str + " hashCode(): " + str.hashCode()
				+ " new Java 7 hashCode used by collections: "
				+ sun.misc.Hashing.stringHash32(str));
	}
}
