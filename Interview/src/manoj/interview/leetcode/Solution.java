package manoj.interview.leetcode;

public class Solution {
	public int lengthOfLastWord(String s) {
		s = s.trim();
		if (s.equals("")) {
			return 0;
		}
		int spaceIndex = s.lastIndexOf(" ");
		if (spaceIndex == -1) {
			return 1;
		} else {
			return s.length() - 1 - spaceIndex;
		}
	}

	public boolean isPalindrome(String s) {
		return false;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		System.out.println(s.lengthOfLastWord("    day"));
	}
}