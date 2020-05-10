import java.util.*;

public class Prog98 extends BaseTestClass {

    public static void main(String... args) {

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode parent = null;
        map.put(root, parent);

        while (!stack.isEmpty()) {
            parent = stack.pop();
            if (parent.left != null) {
                stack.push(parent.left);
                map.put(parent.left, parent);
            }
            if (parent.right != null) {
                stack.push(parent.right);
                map.put(parent.right, parent);
            }
        }

        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> hashSet = new HashSet<>();

        queue.offer(target);
        int level = 0;
        while (!queue.isEmpty() && level != K) {

            Queue<TreeNode> cloneQ = new LinkedList<>(queue);
            queue.clear();
            while (!cloneQ.isEmpty()) {
                TreeNode current = cloneQ.poll();
                hashSet.add(current);


                if (current.left != null && !hashSet.contains(current.left)) {
                    queue.offer(current.left);
                    hashSet.add(current.left);
                }

                if (current.right != null && !hashSet.contains(current.right)) {
                    queue.offer(current.right);
                    hashSet.add(current.right);
                }

                if (map.get(current) != null && !hashSet.contains(map.get(current))) {
                    queue.offer(map.get(current));
                    hashSet.add(map.get(current));
                }
            }

            level++;
            if (level == K) break;

        }

        List<Integer> ans = new ArrayList<>();
        for (TreeNode node :
                queue) {
            ans.add(node.val);
        }

        return ans;


    }

}
