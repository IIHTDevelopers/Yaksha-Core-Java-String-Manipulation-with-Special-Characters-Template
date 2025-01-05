package com.yaksha.assignment;

public class StringWithSpecialCharactersAssignment {

	public static void main(String[] args) {

		// Step 1: Declare a string containing special characters
		String str1 = "Hello, World! How's everything?";

		// Step 2: Replace special characters
		String replaced = str1.replaceAll("[^a-zA-Z0-9]", "");

		// Step 3: Escape special characters (e.g., handling quotes or backslashes)
		String escaped = str1.replaceAll("[^a-zA-Z0-9]", "\\$0");

		// Step 4: Trim leading and trailing special characters
		String trimmed = str1.trim();

		// Step 5: Check if the string contains special characters
		boolean hasSpecialChars = str1.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

		// Print the results
		System.out.println("Replaced Special Characters: " + replaced);
		System.out.println("Escaped Special Characters: " + escaped);
		System.out.println("Trimmed String: '" + trimmed + "'");
		System.out.println("Contains Special Characters: " + hasSpecialChars);
	}
}
