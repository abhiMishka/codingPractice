import com.sun.source.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class Prog91 extends BaseTestClass {

    public static void main(String... args){

    }
//    public int makeConnected(int n, int[][] connections) {
//        int ans  = 0;
//
//
//
//        Integer.MIN_VALUE
//
//        return ans;
//    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root  = new TreeNode(preorder[0]);
        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        treeNodeDeque.offer(root);
        boolean[] visited = new boolean[preorder.length];

        int start = 1;
        while(!treeNodeDeque.isEmpty()){
            TreeNode visitingNode = treeNodeDeque.poll();
            start++;
            for (int i = start; i < preorder.length; i++) {
                if(preorder[i]<visitingNode.val && visitingNode.left == null){
                    TreeNode leftNode = new TreeNode(preorder[i]);
                    treeNodeDeque.offer(leftNode);
                    visitingNode.left = leftNode;
                }else if(preorder[i]>visitingNode.val && visitingNode.right == null){
                    TreeNode rightNode = new TreeNode(preorder[i]);
                    treeNodeDeque.offer(rightNode);
                    visitingNode.right = rightNode;
                }
            }
        }

        return root;
    }

    public static void addNode (TreeNode node, int val){

    }


}

class UnionFind {
    int[] parent;
    int[] size;
    int roots;

    UnionFind(int N) {
        parent = new int[N];
        size = new int[N];
        roots = N;
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
}
