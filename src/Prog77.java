/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 */

public class Prog77 extends BaseTestClass {
    public static void main(String... args) {

        countSquares(new int[][]
                {
                        {0, 1, 1, 1},
                        {1, 1, 1, 1},
                        {0, 1, 1, 1}

                });

    }


    public static int countSquares(int[][] matrix) {
        int totalCount = 0;
        if (matrix.length == 0) return 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==0) continue;
                int l = 0;
                int t = 0;
                int d = 0;
                int val  = 0;
                if (i - 1 >= 0) {
                    t = matrix[i - 1][j];
                    val++;
                }

                if (j - 1 >= 0) {
                    l = matrix[i][j - 1];
                    val++;
                }

                if (val == 2) {
                    d = matrix[i - 1][j - 1];
                }

                matrix[i][j] = Math.min(Math.min(l, t), d) + 1;
                totalCount = totalCount + matrix[i][j];

            }
        }

        return totalCount;

    }
}
