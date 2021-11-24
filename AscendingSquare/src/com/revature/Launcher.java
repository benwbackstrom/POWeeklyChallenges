package com.revature;

import java.util.Arrays;
import java.util.Scanner;

public class Launcher {
	
	//Problem 1
	public static boolean ascending(String str) {

        for(int i = 0; i < str.length()/2; i++) { //Loop through half the string
            String subStr = str.substring(0, i+1); //Gather substring of first i+1 characters
            int n = Integer.parseInt(subStr); //Record the integer value into an int variable
            
            //essentially, we build a "guessed" string based off what the string value should be if the numbers are consecutive
            //Then if the string is the same, that means the string is of consecutive ascending numbers
            //Ex: if n = 3 right now, and str.length() is 4, at the end of the loop it will give "3456" as the "guessed" string
            while(subStr.length() < str.length()) {
                n++;
                subStr += String.valueOf(n); //Concatenate string with next highest value
            }
            if(subStr.equals(str)) {
            	//Once while loop completes, check if "guessed" string is correct
                return true;
            }
        }
		
		return false;
	}
	
	//Problem 2
	public static void squarePatch(int n) {
		if(n == 0) {
			System.out.println("[]");
		} else {
			int[][] mat = new int[n][n]; //Create 2D array of size n x n
			
			//Fill this matrix
			for(int i = 0; i < n; i++) { //Loop through rows
				for(int j = 0; j < n; j++) { //Loop through columns
					mat[i][j] = n; //Fill specific index with n
				}
			}
			
			//Display to the console
			System.out.println("[");
			for(int i = 0; i < n; i++) {
				System.out.print(Arrays.toString(mat[i]));
				if(i != n-1) {
					System.out.print(", \n");
				}
			}
			System.out.println("\n]");
		}
	}

	public static void main(String[] args) {
		//Problem 1 examples
		System.out.println("Problem 1 -----------------------------");
		
		System.out.println(ascending("232425"));
		System.out.println(ascending("2324256"));
		System.out.println(ascending("444445"));
		
		//Problem 2 examples
		System.out.println("Problem 2 -----------------------------");
		
		squarePatch(3);
		squarePatch(5);
		squarePatch(1);
		
		//For if you wish to enter your own numbers or strings
		Scanner scan = new Scanner(System.in);
		System.out.println("Try for yourself!");
		System.out.println("1 - Ascending Test");
		System.out.println("2 - Square Patch");
		
		int choice = scan.nextInt();
		scan.nextLine();
		
		switch(choice) {
			case 1: {
				System.out.println("Please enter a string of numbers to test:");
				
				String str = scan.nextLine();
				
				System.out.println(str + " gives " + ascending(str));
				break;
			}
			case 2: {
				System.out.println("Please enter a number:");
				int n = scan.nextInt();
				scan.nextLine();
				
				squarePatch(n);
				break;
			}
			default: System.out.println("I don't know what you mean");
		}
		scan.close();

	}

}
