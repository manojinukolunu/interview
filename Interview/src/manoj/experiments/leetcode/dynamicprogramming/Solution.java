package manoj.experiments.leetcode.dynamicprogramming;

import java.util.Arrays;

public class Solution {

	public static int climbStairsDynamic(int n, int[] arr) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		} else if (arr[n] > 0) {
			return arr[n];
		} else {
			arr[n] = climbStairsDynamic(n - 1, arr)
					+ climbStairsDynamic(n - 2, arr);
			return arr[n];
		}
	}

	public int minPathSum(int[][] grid) {
		int numRows = grid.length;
		int numColumns = grid[0].length;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if (i == 0) {
					grid[i][j] += grid[0][j - 1];
				} else if (j == 0) {
					grid[i][j] += grid[i - 1][0];
				} else
					grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1])
							+ grid[i][j];
			}
		}
		return grid[numRows - 1][numColumns - 1];
	}

	public int uniquePaths(int m, int n) {
		int[][] grid = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = 0;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					grid[i][j] = 1;
				}
				if (i == 0) {
					grid[i][j] = 1;
				} else if (j == 0) {
					grid[i][j] = 1;
				} else
					grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
			}
		}
		return grid[m - 1][n - 1];
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] grid = obstacleGrid;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					obstacleGrid[i][j] = -1;
				}
			}
		}
		return obstacleGrid[m - 1][n - 1];
	}

	public static int climbStairs(int n) {
		int[] arr = new int[n + 1];
		return climbStairsDynamic(n, arr);
	}

	public static void main(String args[]) {
		Solution sol = new Solution();
		int arr[][] = { { 0 } };

		System.out.println(sol.uniquePaths(1, 2));
		int obstacleGrid[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println(sol.uniquePathsWithObstacles(obstacleGrid));
	}
}
