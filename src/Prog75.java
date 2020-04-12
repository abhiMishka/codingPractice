
import java.util.*;

/**
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3293/
 */
public class Prog75 extends BaseTestClass {


    public static void main(String... args) {

    }


    Map<TreeNode,Integer> heightMap = new HashMap<>();
    TreeNode originalNode;
    int maxPath = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        heightMap = new HashMap<>();
        originalNode = root;

        recursionCall(root);
        return maxPath;

    }



    private int recursionCall(TreeNode root) {

        if (root == null) return 0;

        int leftHeight  = recursionCall(root.left);
        int rightHeight = recursionCall(root.right);

        int height = Math.max(leftHeight,rightHeight) + 1;
        int path = leftHeight + rightHeight;
        if(path>maxPath) maxPath = path;
        // System.out.println("Node : " +root.val +" , leftHeight  " +leftHeight +" , rightHeight : " +rightHeight +" , height = " +height);

        return height;

    }
}
