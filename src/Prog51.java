/**
 * https://leetcode.com/problems/maximal-square/
 */
public class Prog51 extends BaseTestClass {

    public static void main(String... args) {
        println(String.valueOf(maximalSquare(new char[][]{
                {'0','1','1','1'},
                {'0','1','0','1'},
                {'0','1','1','1'},
                {'0','1','1','1'}
        }))
        );
    }

    public static int maximalSquare(char[][] matrix) {
        int maxTillNow = 0;
        int localMax = 0;
        if(matrix.length == 0) return 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i - 1 < 0 || j - 1 < 0 || matrix[i][j]=='0') {
                    if(matrix[i][j]=='1' && maxTillNow == 0){
                        maxTillNow = 1;
                    }
                    continue;
                }

                localMax = Math.min(Math.min((matrix[i - 1][j] - '0')
                        , (matrix[i][j - 1]) - '0')
                        , (matrix[i - 1][j - 1]) - '0')
                        + 1;
                if(localMax>maxTillNow){
                    maxTillNow = localMax;
                }
                matrix[i][j] = (char)(localMax+'0');
            }
        }

        return maxTillNow*maxTillNow;

    }

    private static void print2DArray(char[][] board) {
        print("\n");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                print(board[i][j] + " ");
            }
            print("\n");
        }
        print("\n");

    }
}
