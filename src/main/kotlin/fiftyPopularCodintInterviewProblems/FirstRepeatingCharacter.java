package fiftyPopularCodintInterviewProblems;

import java.util.HashSet;
import java.util.Set;


public class FirstRepeatingCharacter {
    public char firstRepeatingCharacter(String str){
        Set<Character> set = new HashSet<>();
        char[] charArr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(charArr[i])) {
                return charArr[i];
            } else {
                set.add(charArr[i]);
            }
        }
        return '\0';
    }
}
