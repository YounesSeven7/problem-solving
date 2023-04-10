package fiftyPopularCodintInterviewProblems;

import java.util.HashSet;
import java.util.Set;

public class FindPairThatSumsUpToK {
    public boolean findPair(int[] arr, int k){
        Set<Integer> s = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            int f = k - arr[i];
            if (s.contains(f)) {
                return true;
            } else {
                s.add(arr[i]);
            }
        }
        return false;
    }
}
