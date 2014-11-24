package hackerrank.dynamicprogramming;

public class Solution {

	public static int[] stack;

	private static int pickSum(int numberOfElements, int numberOfBricks) {
		return stack[stack.length - numberOfElements]
				+ Math.max(pickSum(numberOfElements - numberOfBricks, 1), Math
						.max(pickSum(numberOfElements - numberOfBricks, 2),
								pickSum(numberOfElements - numberOfBricks, 3)));
	}
	public static void main(String[] args) {
		int numEle = 0;
		int sumMax = Math.max(pickSum(numEle, 1),
				Math.max(pickSum(numEle, 2), pickSum(numEle, 3)));
	}
}