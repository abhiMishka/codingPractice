//package codejam.pascalWalk;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Solution {
//
//    public static void println(String message) {
//        System.out.println(message);
//    }
//
//    public static void print2D(int mat[][]) {
//        // Loop through all rows
//        for (int[] row : mat)
//
//            // converting each row as string
//            // and then printing in a separate line
//            println(Arrays.toString(row));
//    }
//
//
//    public static void main(String... args) {
//        int[][] pascalMat = createPascal();
//
////        Scanner in = new Scanner(System.in);
////        int t = in.nextInt();
////        in.nextLine();
////        for (int i = 1; i <= t; ++i) {
////            int size = Integer.parseInt(in.nextLine());
////            String[] allStrings = new String[size];
////            int k=0;
////            int longestLength = 0;
////            while (size-- >0){
////                StringBuilder a = new StringBuilder(in.nextLine());
////                allStrings[k] = a.reverse().toString();
////                int len = allStrings[k].length();
////                if(len>longestLength) longestLength = len;
////                k++;
////            }
////        }
//    }
//
//    int[][] possibleDirections = new int[][]{
//            {-1, 0},
//            {-1, -1},
//            {0, -1},
//            {1, -1},
//            {1, 0},
//            {0, 1}
//    };
//
//    int requiredSum  = 4;
//    private Node dfs(int[][] grid, int i, int j, boolean[][] booleans,int sum) {
//        if (i < 0 || i >= grid.length || j >= grid[0].length || j < 0 || sum > requiredSum || grid[i][j] == 0) return null;
//
//        if (booleans[i][j]) return new Node(i,j);
//
//        booleans[i][j] = true;
//
//        for (int k = 0; k < possibleDirections.length; k++) {
//            int posI = i+possibleDirections[i][0];
//            int posJ = i+possibleDirections[i][1];
//            dfs()
//
//        }
//
////        int left = dfs(grid, i, j - 1, booleans);
////        int right = dfs(grid, i, j + 1, booleans);
////        int top = dfs(grid, i - 1, j, booleans);
////        int bottom = dfs(grid, i + 1, j, booleans);
//
//        booleans[i][j] = false;
//
//        return Math.max(left, Math.max(right, Math.max(top, bottom))) + grid[i][j];
//
//
//    }
//
//    static class Node {
//        int i, j;
//
//        public Node(int i, int j) {
//            this.i = i;
//            this.j = j;
//        }
//
//        public int getI() {
//            return i;
//        }
//
//        public int getJ() {
//            return j;
//        }
//
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "i=" + i +
//                    ", j=" + j +
//                    '}';
//        }
//
//    }
//
//
//    public static int[][] createPascal() {
//        int n = 21;
//        int[][] mat = new int[21][21];
//        for (int line = 0; line < n; line++) {
//
//            int C = 1;// used to represent C(line, i)
//            for (int i = 1; i <= line; i++) {
//                // The first value in a line is always 1
////                System.out.print(C+" ");
//                mat[line][i - 1] = C;
//                C = C * (line - i) / i;
//            }
////            System.out.println();
//        }
//
//        print2D(mat);
//    }
//}
