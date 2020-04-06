/**
 * https://leetcode.com/problems/unique-paths-iii/
 */
public class Prog59 extends BaseTestClass {


    public static void main(String... args){

        print(uniquePathsIII(new int[][]{
                {1,0,0},
                {0,0,0},
                {0,0,2}
        }));


    }

    public static int uniquePathsIII(int[][] grid) {
        int[][] possiblePaths = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                possiblePaths[i][j] = -2;
            }
        }

        int findI = 0;
        int findJ = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    findI = i;
                    findJ = j;
                    break;
                }
            }
        }


        boolean[][] visitedNodes = new boolean[grid.length][grid[0].length];
//        visitedNodes[findI][findJ] = true;
        return uniquePathsRec(grid,grid.length,grid[0].length,
                findI,findJ,possiblePaths, visitedNodes);


    }

    private static int uniquePathsRec(int[][] obstacleGrid, int m, int n, int i, int j, int[][] possiblePaths, boolean[][] visited) {
        if(i>=m || j>=n || i<0 || j<0 || obstacleGrid[i][j]==-1){
            return 0;
        }


        if(visited[i][j]) return 0;

        if(obstacleGrid[i][j]==2){
            return 1;
        }
        if(possiblePaths[i][j]>=0){
            return possiblePaths[i][j];
        }

        visited[i][j] = true;

        int left = uniquePathsRec(obstacleGrid,m,n,i,j-1,possiblePaths, visited);
        int right = uniquePathsRec(obstacleGrid,m,n,i,j+1,possiblePaths, visited);
        int top = uniquePathsRec(obstacleGrid,m,n,i-1,j,possiblePaths, visited);
        int bottom = uniquePathsRec(obstacleGrid,m,n,i+1,j,possiblePaths, visited);

        visited[i][j] = false;
        possiblePaths[i][j] = top+bottom+left+right;

//        for(int k=0;k<possiblePaths.length;k++){
//            for(int l =0 ;l<possiblePaths[0].length;l++){
//                print(visited[k][l]+"  ");
//            }
//            println("");
//        }
//        println("\n-----------------------------------\n");


        return possiblePaths[i][j];

    }
}
