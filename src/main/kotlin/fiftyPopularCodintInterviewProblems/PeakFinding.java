package fiftyPopularCodintInterviewProblems;

public class PeakFinding {
    public int findPeak(int[] arr){
        if (arr.length == 1)
            return 0;
        int start = arr[0] - 1;
        int end = arr[1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] >= end) {
                return i;
            }
            start = arr[i];
            end = i == (arr.length - 2) ? arr[i + 1] - 1 : arr[i + 2];
        }
        return 0;
    }

    public int findPeakSecondSolution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if ((i == 0 || arr[i] >= arr[i-1]) && (i == (arr.length -1) || arr[i] >= arr[i+1]))
                return i;
        }
        return 0;
    }
}
