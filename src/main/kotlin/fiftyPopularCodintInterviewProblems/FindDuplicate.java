package fiftyPopularCodintInterviewProblems;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    public int findDuplicate(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i]))
                return arr[i];
            else
                set.add(arr[i]);
        }
        return 0;
    }
}
