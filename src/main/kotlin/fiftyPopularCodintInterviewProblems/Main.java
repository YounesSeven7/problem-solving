package fiftyPopularCodintInterviewProblems;

public class Main {
    public static void main(String[] args) {
        PathInMatrix pathInMatrix = new PathInMatrix();
        int[][] matrix = {{3, 12, 4, 7, 10}, {6, 8, 15, 11, 4}, {19, 5, 14, 32, 21}, {1, 20, 2, 9, 7}};
        System.out.println(pathInMatrix.minimumCostPath(matrix));
    }
}