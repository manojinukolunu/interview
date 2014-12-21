package manoj.experiments;

public interface StringST<Value> {
	
	
	/**
	 *  put key-value pair into the table 
	 *  remove key if value is null
	 * @param key
	 * @param val
	 */
	public void put(String key, Value val);

	
	/**
	 * value paired with key
	 * null if key is absent
	 * @param key
	 * @return
	 */
	public Value get(String key);
	
	/**
	 * remove key and its value
	 * @param key
	 */
	public void delete(String key);

	/**
	 * is there a value paired with key?
	 * @param key
	 * @return
	 */
	public boolean contains(String key);
	
	
	/**
	 * is the table empty?
	 * @return
	 */
	public boolean isEmpty();
	
	
	/**
	 * The longest key that is a prefix of s
	 * @param s
	 * @return
	 */
	public String longestPrefixOf(String s);
	
	
	/**
	 * all the keys having s as a prefix
	 * @param s
	 * @return
	 */
	public Iterable<String> keysWithPrefix(String s);
	
	/**
	 * all the keys that match s 
	 * where . matches any character
	 * @param s
	 * @return
	 */
	public Iterable<String> keysThatMatch(String s);
	
	
	/**
	 * number of key-value pairs
	 * @return
	 */
	public int size();
	
	
	/**
	 * All the keys in the table
	 * @return
	 */
	public Iterable<String> keys();

}
