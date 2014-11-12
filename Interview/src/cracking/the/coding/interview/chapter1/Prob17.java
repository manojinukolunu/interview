package cracking.the.coding.interview.chapter1;

import java.util.Arrays;

public class Prob17 {

	public int[][] setZero(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0)
					setToZero(arr, i, j);
			}
		}
		return arr;
	}

	private void setToZero(int[][] arr, int row, int column) {
		for (int i = 0; i < arr[row].length; i++) {
			arr[row][i] = 0;
		}
		for (int i = 0; i < arr.length; i++) {
			try {
				arr[i][column] = 0;
			} catch (ArrayIndexOutOfBoundsException e) {
				continue;
			}
		}
	}
	public static void main(String args[]) {
		int[][] arr = new int[][]{new int[]{1, 0, 3}, new int[]{1, 2, 3,4}};
		System.out.println(Arrays.deepToString(arr));
		Prob17 p = new Prob17();
		arr = p.setZero(arr);
		System.out.println(Arrays.deepToString(arr));
	}

}
