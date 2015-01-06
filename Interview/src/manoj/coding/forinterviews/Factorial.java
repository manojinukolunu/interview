package manoj.coding.forinterviews;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Factorial {

	public static void main(String[] args) throws Exception{
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigInteger big = BigInteger.valueOf(1);
		for (int i = 1; i <= n; i++) {
			big = big.multiply(BigInteger.valueOf(i));
		}
		System.out.println(big.toString());
	}
}