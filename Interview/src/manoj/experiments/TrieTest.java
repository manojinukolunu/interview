package manoj.experiments;

public class TrieTest {

	public static void main(String args[]) {
		TrieST<Integer> trie = new TrieST<Integer>();
		trie.put("abcdef",25);
		trie.put("abc", 10);
		trie.put("abcd",15);
		trie.put("def", 15);
		trie.put("hig", 15);
	}

}
