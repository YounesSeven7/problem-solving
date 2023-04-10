package fiftyPopularCodintInterviewProblems;

public class PathInMatrix {
    public int minimumCostPath(int[][] matrix){
        int [][] second = new int[matrix.length][matrix[0].length];
        second[0][0] = matrix[0][0];
        for (int i = 1; i < matrix[0].length; i++) {
            second[0][i] = second[0][i-1] + matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            second[i][0] = second[i-1][0] + matrix[i][0];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                second[i][j] = second[i-1][j] < second[i][j-1] ?
                        second[i-1][j] + matrix[i][j]:
                        second[i][j-1] + matrix[i][j];
            }
        }
        return second[matrix.length-1][matrix[0].length-1];
    }


}
