import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prog54 extends BaseTestClass {
    public static void main(){

    }

    public List<String> binaryTreePaths(Prog44.TreeNode root) {
        Queue<String> queue = new LinkedList<>();
        ArrayList<String> answer = new ArrayList<>();
        preOrder(root,queue,new ArrayList<>());
        return answer;
    }

    public static void preOrder(Prog44.TreeNode node,Queue<String> rootsVisited,List<String> answer){

        if(node==null){
            StringBuilder stringBuilder = new StringBuilder();
            for (String a :
                    rootsVisited) {
                stringBuilder.append(a);
            }
            answer.add(stringBuilder.toString());
            rootsVisited.poll();
            return;
        }

        rootsVisited.add(String.valueOf(node.val));

        preOrder(node.left,rootsVisited,answer);
        preOrder(node.right,rootsVisited,answer);

    }


}
