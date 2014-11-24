package cracking.the.coding.interview.chapter9;

public class Prob92 {
	public static int solution(int x, int y) {
		int[][] grid = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				grid[i][j] = -1;
			}
		}
		return numPaths(x, y, grid);
	}
	private static int numPaths(int x, int y, int[][] grid) {
		if (x == 0) {
			return 1;
		}
		if (y == 0) {
			return 1;
		}
		if (grid[x][y] > -1) {
			return grid[x][y];
		} else {
			grid[x][y] = numPaths(x - 1, y, grid) + numPaths(x, y - 1, grid);
			return grid[x][y];
		}

	}
}
