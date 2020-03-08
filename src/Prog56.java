import java.util.HashSet;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/path-with-maximum-gold/
 */
public class Prog56 extends BaseTestClass {

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String input = scanner.nextLine();
            int numOfPlates = Integer.parseInt(input.split(" ")[0]);
            int moveNumber = Integer.parseInt(input.split(" ")[1]);
            towerOfHanoi(numOfPlates, moveNumber);
        }
    }

    static int printed = 0;

    public static void towerOfHanoi(int numOfPlates, int moveNumber) {
        printed = 0;

        recTowerOfHanoi(numOfPlates, "1", "3", "2", moveNumber);

    }

    public static void recTowerOfHanoi(int numOfPlates, String fromBox, String toBox, String auxBox, int moveNumber) {

        if (numOfPlates == 1) {
            if(++printed == moveNumber) {
                System.out.println(fromBox + " " + toBox);
            }
        } else if (numOfPlates > 1) {
            recTowerOfHanoi(numOfPlates - 1, fromBox, auxBox, toBox, moveNumber);
            if(++printed == moveNumber) {
                System.out.println(fromBox + " " + toBox);
            }
            recTowerOfHanoi(numOfPlates - 1, auxBox, toBox, fromBox, moveNumber);
        }

    }

    public int getMaximumGold(int[][] grid) {

        if (grid == null || grid.length <= 0) return 0;
        int ans = 0;
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    ans = Math.max(ans, dfs(grid, i, j, new boolean[grid.length][grid[i].length]));
                }
            }
        }
        return ans;

    }

    private int dfs(int[][] grid, int i, int j, boolean[][] booleans) {
        if (i < 0 || i >= grid.length || j >= grid[0].length || j < 0 || grid[i][j] == 0) return 0;

        if (booleans[i][j]) return 0;

        booleans[i][j] = true;

        int left = dfs(grid, i, j - 1, booleans);
        int right = dfs(grid, i, j + 1, booleans);
        int top = dfs(grid, i - 1, j, booleans);
        int bottom = dfs(grid, i + 1, j, booleans);

        booleans[i][j] = false;

        return Math.max(left, Math.max(right, Math.max(top, bottom))) + grid[i][j];


    }

//    public int uniquePaths(int m, int n) {
//
//
//    }


}
