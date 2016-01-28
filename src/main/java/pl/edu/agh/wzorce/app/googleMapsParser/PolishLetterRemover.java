package pl.edu.agh.wzorce.app.googleMapsParser;

import java.util.HashMap;
import java.util.Map;

public class PolishLetterRemover {
    /* 
     *       UZYWAMY TYLKO METODY: substitutePolishLettersWithNormal(String input)
     * 		 main mozna odkomentowac do testow;
     *   	 pozdro
     */
    static Map<Character, Character> polishLettersMap;
    static {
        polishLettersMap = new HashMap<Character, Character>();
        polishLettersMap.put('�', 'a');
        polishLettersMap.put('�', 'a');
        polishLettersMap.put('�', 'o');
        polishLettersMap.put('�', 's');
        polishLettersMap.put('�', 'l');
        polishLettersMap.put('�', 'z');
        polishLettersMap.put('�', 'z');
        polishLettersMap.put('�', 'c');
        polishLettersMap.put('�', 'n');
        
    }
    
    public static boolean isNormalLetter(int chVal) {
        return (chVal >= 65 && chVal <= 90) || (chVal >= 97 && chVal <= 122);
    }
    
    public static String substitutePolishLettersWithNormal(String org) {
        StringBuilder sb = new StringBuilder();
        for (char ch: org.toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(isNormalLetter(ch)? ch : polishLettersMap.get(ch));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
    /*
    public static void main(String[] args) {
        String testSentence = "W K�dzie�ynie-ko�le nast�pi�o wy��czenie �wiat�a";
        testSentence = testSentence.toLowerCase();
        for (char c: testSentence.toCharArray()) {
            System.out.println(""+c+"\t"+isNormalLetter(c));
        }
        System.out.println();
        System.out.println(testSentence);
        System.out.println(substitutePolishLettersWithNormal(testSentence));
    }*/
}
