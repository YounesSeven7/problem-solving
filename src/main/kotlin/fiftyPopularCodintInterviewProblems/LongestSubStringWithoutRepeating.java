package fiftyPopularCodintInterviewProblems;

import java.util.HashMap;

public class LongestSubStringWithoutRepeating {
    public int longestSubstringWithoutRepeating(String str){
        int max = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (map.get(chars[i]) != null) {
                start = map.get(chars[i]) + 1;
            }
            map.put(chars[i], i);
            max = Math.max(max, i-start+1);
        }
        return max;
    }
}
