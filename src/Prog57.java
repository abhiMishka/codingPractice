/**
 * https://leetcode.com/problems/unique-paths/
 */
public class Prog57 extends BaseTestClass {

    public static void main(String... args){
        println(String.valueOf(uniquePaths(3,2)));
    }

    public static int uniquePaths(int m, int n) {
        return uniquePathsRec(m,n,0,0,new int[m][n]);
    }

    private static int uniquePathsRec(int m, int n, int i, int j, int[][] possiblePaths) {
        if(i>=m || j>=n) return 0;
        if(i==(m-1) && j==(n-1)) return 1;
        if(possiblePaths[i][j]>0) return possiblePaths[i][j];

        int right = uniquePathsRec(m,n,i,j+1, possiblePaths);
        int down = uniquePathsRec(m,n,i+1,j, possiblePaths);
        possiblePaths[i][j] = right+down;
        return possiblePaths[i][j];
    }
}
