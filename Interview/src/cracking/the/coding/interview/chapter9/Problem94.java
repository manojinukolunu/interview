package cracking.the.coding.interview.chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Problem94 {
	public static void main(String args[]) {
		int array[] = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(genSubsets(array).toArray()));
	}

	private static ArrayList<HashSet<Integer>> genSubsets(int[] array) {
		ArrayList<HashSet<Integer>> subsets = new ArrayList<HashSet<Integer>>();
		for (int i = 0; i < array.length; i++) {
			addToSubsets(subsets, array[i]);
		}
		return subsets;
	}

	private static void addToSubsets(ArrayList<HashSet<Integer>> subsets,
			int integer) {
		HashSet<Integer> newSet = new HashSet<Integer>();
		newSet.add(integer);
		HashSet<Integer> __newSet = new HashSet<Integer>();
		if (subsets.contains(newSet)) {
			// dont do anything
		} else {
			// add i to every element in the set
			for (int j = 0; j < subsets.size(); j++) {
				HashSet<Integer> _newSet = new HashSet<Integer>(subsets.get(j));
				_newSet.add(integer);
				__newSet.addAll(_newSet);
			}
			// add integer to the set
			subsets.add(newSet);
			subsets.add(__newSet);
		}
	}

}
