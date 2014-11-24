package cracking.the.coding.interview.chapter9;

public class Prob91 {

	public int numSteps(int numSteps) {
		int[] numMap = new int[numSteps + 1];
		for (int i = 0; i < numMap.length; i++) {
			numMap[i] = -1;
		}
		return numStepsDP(numSteps, numMap);
	}

	private int numStepsDP(int num, int[] map) {
		if (num == 0) {
			return 1;
		}
		if (num < 0) {
			return 0;

		} else if (map[num] > -1) {
			return map[num];
		} else {
			map[num] = numStepsDP(num - 1, map) + numStepsDP(num - 2, map)
					+ numStepsDP(num - 3, map);
			return map[num];
		}
	}
	public static void main(String args[]) {
		Prob91 prob = new Prob91();
		assert (prob.numSteps(29) == 29249425);
		System.out.println(prob.numSteps(29));

	}
}
