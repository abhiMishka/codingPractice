public class Prog44 extends BaseTestClass {

    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {


        inOrderTraversal(root);

        return isValid;
    }

    public void inOrderTraversal(TreeNode root){

        if(root == null){
            return;
        }

        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
        if(root.right!=null){
            if(root.val>root.right.val)
                isValid = false;
        }
        if(root.left!=null){
            if(root.val<root.left.val)
                isValid = false;
        }

    }

    public static boolean isValid(int currentValue,int lastValue){
        return currentValue>=lastValue;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
