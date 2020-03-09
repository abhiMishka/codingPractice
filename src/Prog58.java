/**
 * https://leetcode.com/problems/unique-paths-ii/submissions/
 */

public class Prog58 extends BaseTestClass {

    public static void main(String... args){

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] possiblePaths = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++){
            for(int j=0;j<obstacleGrid[i].length;j++){
                possiblePaths[i][j] = -1;
            }
        }
        return uniquePathsRec(obstacleGrid,obstacleGrid.length,obstacleGrid[0].length,
                0,0,possiblePaths);
    }

    private static int uniquePathsRec(int[][] obstacleGrid,int m, int n, int i, int j, int[][] possiblePaths) {
        if(i>=m || j>=n){
            return 0;
        }
        if(obstacleGrid[i][j]==1){
            possiblePaths[i][j] = 0;
            return 0;
        }
        if(i==(m-1) && j==(n-1)) return 1;
        if(possiblePaths[i][j]>=0) return possiblePaths[i][j];

        int right = uniquePathsRec(obstacleGrid,m,n,i,j+1, possiblePaths);
        int down = uniquePathsRec(obstacleGrid,m,n,i+1,j, possiblePaths);
        possiblePaths[i][j] = right+down;
        return right+down;
    }
}
