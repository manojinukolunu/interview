package hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Panagrams {

	public static void main(String args[]) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			boolean notpanagram = false;
			String str = null;
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			if (str == null || str.equals(""))
				break;
			for (int i = 0; i < str.length(); i++) {
				map.put(Character.toLowerCase(str.charAt(i)), 1);
			}

			for (int i = 0; i < alphabet.length(); i++) {
				if (!map.containsKey(alphabet.charAt(i))) {
					System.out.println("not pangram");
					notpanagram = true;
					break;
				}
			}
			if (!notpanagram)
				System.out.println("pangram");
		}
	}
}
