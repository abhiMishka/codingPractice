import java.util.Arrays;

public class BaseTestClass {





    public static void print(String message){
        System.out.print(message);
    }

    public static void print(int message){
        System.out.print(message);
    }

    public static void println(String message){
        System.out.println(message);
    }

    public static void printSeparation(){
        println("\n ------------------------------------------ \n");
    }

    public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int[] row : mat)

            // converting each row as string
            // and then printing in a separate line
            println(Arrays.toString(row));
    }

    public static void print2D(char mat[][])
    {
        // Loop through all rows
        for (char[] row : mat)

            // converting each row as string
            // and then printing in a separate line
            println(Arrays.toString(row));
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
