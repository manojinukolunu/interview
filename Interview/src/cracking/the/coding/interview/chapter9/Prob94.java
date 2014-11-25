package cracking.the.coding.interview.chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Prob94 {

	public static ArrayList<HashSet<Integer>> generateAllSubSets(int[] arr) {
		ArrayList<HashSet<Integer>> subsets = new ArrayList<HashSet<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			addToSubSet(arr[i], subsets);
		}
		return subsets;
	}
	private static void addToSubSet(int integer,
			ArrayList<HashSet<Integer>> subsets) {
		HashSet<Integer> newSet = new HashSet<Integer>();
		newSet.add(integer);
		if (subsets.contains(newSet)) {
			// dont do anything
		} else {
			// add i to every element in the set
			for (int j = 0; j < subsets.size(); j++) {
				subsets.get(j).add(integer);
			}
			// add integer to the set
			subsets.add(newSet);
		}

	}
	public static void main(String args[]) {
		int arr[] = {1, 2, 3, 4};
		System.out.println(Arrays.toString(generateAllSubSets(arr).toArray()));
	}
}
