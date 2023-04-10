package fiftyPopularCodintInterviewProblems;

public class MaximumSubarray {
    public int maximumSubarray(int[] arr){
        int oldmax = arr[0];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = 0;
            for (int j = i; j < arr.length; j++) {
                max += arr[j];
                if (max > oldmax)
                    oldmax = max;
            }
        }
        System.out.println(max);
        return oldmax;
    }
}
