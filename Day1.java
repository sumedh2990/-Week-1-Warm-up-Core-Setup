package Practice.Code.Daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {
//DAY1
//DSA: Reverse a string without using built-in reverse methods
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world");
		
		//way 1
		String reverseString = "sumedh";
		char reverseChar;
		for (int i = reverseString.length()-1; i >= 0; i--) {
			reverseChar = reverseString.charAt(i);
			
			System.out.println("reverse CHAR "+reverseChar);
		}
		
		//way 2
		String reverse = new StringBuilder("sumedh").reverse().toString();
		System.out.println(reverse);

		//way 3
		String str = "sumedh";
		String reversed = "";

		for (int i = str.length() - 1; i >= 0; i--) {
		    reversed += str.charAt(i);
		}

		System.out.println("simple = "+reversed); // hdemus

		//way4
		String str1 = "sumedh";
		char[] chars = str1.toCharArray();

		for (int i = chars.length - 1; i >= 0; i--) {
		    System.out.println("using char array = "+chars[i]);
		}
		// Output: hdemus

		//way5
		//using recursion
		 System.out.println("recursive way : = "+reverseRec("sumedh"));
		 
		 //way6
		 //streams
		 String reversed1 = str.chars() // IntStream of chars
		         .mapToObj(c -> (char) c)
		         .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);

		 System.out.println("Stream :-"+reversed1); // hdemus
		 
		 //way7
		 List<Character> chars1 = new ArrayList<>();

		 for (char c : str.toCharArray()) {
		     chars1.add(c);
		 }
		 Collections.reverse(chars1);

		 for (char c : chars1) {
		     System.out.println("using collection = "+c);
		 }
		 // Output: hdemus


	}
	public static String reverseRec(String str) {
	    if (str.isEmpty()) {
	        return str;
	    }
	    return reverseRec(str.substring(1)) + str.charAt(0);
	}

}
