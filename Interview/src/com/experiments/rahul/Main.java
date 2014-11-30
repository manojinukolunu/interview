package com.experiments.rahul;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNextLine()) {
			String numApples = scan.nextLine();
			BigInteger apples = new BigInteger(numApples);
			String klaudia = scan.nextLine();
			BigInteger applesKlaudia = new BigInteger(klaudia);
			BigInteger natalia = apples.subtract(applesKlaudia).divide(
					BigInteger.valueOf(2));
			BigInteger klaudiaApples = natalia.add(applesKlaudia);
			
			System.out.println(natalia);
			System.out.println(klaudiaApples);

		}

	}

}
