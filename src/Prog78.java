import java.util.*;

/**
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 * <p>
 * The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
 * <p>
 * Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.
 * <p>
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 */

public class Prog78 extends BaseTestClass {
    public static void main(String... args) {

    }

    boolean pickFirst;
    boolean pickSecond;
    boolean breakAll = true;
    Map<Integer, String> map;

    public boolean stoneGame(int[] piles) {
        map = new HashMap<>();
        return recursion(piles, 0, piles.length - 1, 0, 0, true);
    }


    private boolean recursion(int[] piles, int p1, int p2, int aValue, int bValue, boolean aTurn) {

        if (!breakAll) return false;

        if (map.containsKey(p1)) return true;

        if (p1 > p2) {
            breakAll = aValue > bValue;
            if (breakAll) map.put(p1, "A");
            return breakAll;
        }

        if (aTurn) {
            boolean pickFirst = recursion(piles, p1 + 1, p2, aValue + piles[p1], bValue, false);
            boolean pickSecond = recursion(piles, p1, p2 - 1, aValue + piles[p2], bValue, false);
        } else {
            recursion(piles, p1 + 1, p2, aValue, bValue + piles[p1], true);
            recursion(piles, p1, p2 - 1, aValue, bValue + piles[p2], true);
        }
        if (pickFirst == pickSecond == true) return true;
        return false;
    }


//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> ans = new ArrayList<>();
//        if (root == null) return ans;
//        Stack<TreeNode> stack = new Stack<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        stack.add(root);
//        boolean addToQueue = true;
//        while (!stack.isEmpty() || !queue.isEmpty()) {
//            List<Integer> elements = new ArrayList<>();
//
//            if (addToQueue) {
//                while (!stack.isEmpty()) {
//                    TreeNode c = stack.pop();
//                    if (c.right != null) {
//                        queue.add(c.right);
//                    }
//                    if (c.left != null) {
//                        queue.add(c.left);
//                    }
//                    elements.add(c.val);
//                    addToQueue = false;
//                }
//            } else {
//                while (!queue.isEmpty()) {
//                    TreeNode c = queue.poll();
//                    if (c.right != null) {
//                        stack.add(c.right);
//                    }
//                    if (c.left != null) {
//                        stack.add(c.left);
//                    }
//                    elements.add(c.val);
//                    addToQueue = true;
//                }
//            }
//
//            ans.add(elements);
//
//        }
//
//        return ans;
//    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.add(root);
        boolean addToQueue = true;
        while (!stack.isEmpty() || !stack2.isEmpty()) {
            List<Integer> elements = new ArrayList<>();

            if (addToQueue) {
                while (!stack.isEmpty()) {
                    TreeNode c = stack.pop();
                    if (c.left != null) {
                        stack2.add(c.left);
                    }
                    if (c.right != null) {
                        stack2.add(c.right);
                    }

                    elements.add(c.val);
                    addToQueue = false;
                }
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode c = stack2.pop();
                    if (c.right != null) {
                        stack.add(c.right);
                    }
                    if (c.left != null) {
                        stack.add(c.left);
                    }
                    elements.add(c.val);
                    addToQueue = true;
                }
            }

            ans.add(elements);

        }

        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
