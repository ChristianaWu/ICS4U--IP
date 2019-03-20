/*
 * Christiana 
 * Tut 6
 * 20767703 
 * input nothing output if it is or is not all vowels 
 */
package msci121;

public class VowelChek {

	public static void main(String[] args) {
		
		System.out.println(notAllVowel ("eieie"));
	}
	public static boolean isAllVowel (String s) {
		int length = 0;
		String t = s.toLowerCase();
		char chr;
		for (int i = 0; i <= s.length()-1; i++) {
			chr = t.charAt(i);
			if (chr == 'e' || chr == 'i' || chr == 'o' || chr == 'u'||chr == 'a' ) {
				length++;
			}
		}
		return (length == t.length());
	}
	
	public static boolean notAllVowel (String s) {
		int length = 0;
		String t = s.toLowerCase();
		char chr;
		for (int i = 0; i <= s.length()-1; i++) {
			chr = t.charAt(i);
			if (chr != 'e' && chr != 'i' && chr != 'o' && chr != 'u'&& chr != 'a' ) {
				length++;
			}
		}
		return (length == t.length());
	}

}
