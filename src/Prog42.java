import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Prog42 extends BaseTestClass {

    public static void main(String... args) {
//        solve(new char[][]{
//                        {'O', 'X', 'X', 'X', 'X', 'X', 'O', 'O'},
//                        {'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O'},
//                        {'X', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
//                        {'X', 'O', 'X', 'O', 'O', 'X', 'X', 'X'},
//                        {'O', 'X', 'O', 'X', 'X', 'X', 'O', 'O'},
//                        {'O', 'X', 'X', 'O', 'O', 'X', 'X', 'O'},
//                        {'O', 'X', 'O', 'X', 'X', 'X', 'O', 'O'},
//                        {'O', 'X', 'X', 'X', 'X', 'O', 'X', 'X'}
//                }
//        );

//        solve(new char[][]{
//                        {'X', 'O', 'X', 'X'},
//                        {'X', 'X', 'O', 'O'},
//                        {'X', 'X', 'O', 'X'},
//                        {'X', 'O', 'X', 'X'}
//                }
//        );

        stringMatching(new String[]{"mass","as","hero","superhero"});


//        {'X', 'O', 'X', 'X','O'},
//        {'O', 'O', 'X', 'X','O'},
//        {'X', 'X', 'O', 'X','O'},
//        {'X', 'O', 'X', 'X','O'},
//        {'X', 'X', 'X', 'X','O'}
    }

    static int[][] directions = new int[][]{
            {0, -1},
            {0, 1},
            {1, 0},
            {-1, 0}
    };

    static int R;
    static int C;

    static boolean isValid(int i, int j) {
        return i >= 0 && i < R && j >= 0 && j < C;
    }


    public static void solve(char[][] board) {
        if (board.length == 0) return;
        R = board.length;
        C = board[0].length;
        boolean[][] visited = new boolean[R][C];
        for (int i = 0; i < C; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, visited);
            }
        }

        for (int i = 0; i < C; i++) {
            if (board[R - 1][i] == 'O') {
                dfs(board, R - 1, i, visited);
            }
        }

        for (int i = 0; i < R; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, visited);
            }
        }

        for (int i = 0; i < R; i++) {
            if (board[i][C - 1] == 'O') {
                dfs(board, i, C - 1, visited);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(board[i][j]=='M'){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
        }

//        print2DArray(board);
    }

    public static void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (grid[i][j] == 'X' || visited[i][j]) return;

        grid[i][j] = 'M';
        visited[i][j] = true;

        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (isValid(newI, newJ)) {
                dfs(grid, newI, newJ, visited);
            }
        }

    }

    public static void dfs2(char[][] grid, int i, int j, boolean[][] visited) {
        if (grid[i][j] == 'X' || visited[i][j]) return;

        grid[i][j] = 'O';
        visited[i][j] = true;


        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (isValid(newI, newJ)) {
                dfs2(grid, newI, newJ, visited);
            }
        }

    }


    private static void print2DArray(char[][] board) {
        print("\n");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                print(board[i][j] + " ");
            }
            print("\n");
        }
    }

    public static List<String> stringMatching(String[] words) {
        HashSet<String> ans = new HashSet<>();
        List<String> ans1 = new ArrayList<>();

        for (String word :
                words) {
            for (int i = 0; i < words.length; i++) {
                if(words[i]!=word && words[i].contains(word)){
                    ans.add(words[i]);
                }
            }
            }

        for (String a :
                ans) {
            ans1.add(a);
        }

        println(ans1.toString());

        return ans1;
    }
}
