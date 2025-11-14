/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns the string without the character in the given index.
	public static String removeChar(String str, int index) {
		return str.substring(0, index) + str.substring(index + 1);
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		// If the strings' lengths do not match, they are not anagrams and returns false.
		if (str1.length() != str2.length()) {
			return false;
		}
		// Checks if every letter in the first string is in the second string.
		for (int i = 0; i < str1.length(); i++) {
			int index = str2.indexOf(str1.charAt(i));
			if (index == -1) {
				return false;
			}
			// Removes the letter in the given index from the string.
			str2 = removeChar(str2, index);
		}
		return true;
	}

	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted.
	// For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		return str.toLowerCase().replaceAll("[^a-zA-Z]", "");
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		String anagram = "";
		while (str.length() != 0) {
			int i = (int) (Math.random() * str.length());
			anagram += str.charAt(i);
			// Removes the character that was added to the anagram from the given string to
			// avoid duplication.
			str = removeChar(str, i);
		}
		return anagram;
	}
}
