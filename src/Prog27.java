import java.util.HashMap;

/**
 * https://leetcode.com/problems/fruit-into-baskets/
 */


public class Prog27 extends BaseTestClass {
    public static void main(String[] args) {
        print(totalFruit(new int[]{5,9,0,9,6,9,6,9,9,9}));
    }


    public static int totalFruit(int[] tree) {
        int maxLength = -1;
        int i=0;
        int j=0;
        int len =0;
        boolean newI = true;

        HashMap<Integer,Integer> map = new HashMap<>();

        while(i<tree.length && j<tree.length){
            int current = tree[i];
//            print("i : " +i +":" +tree[i] +" , j : " +j+ ":" +tree[j] +" max : " +maxLength +"\n");
            if(newI) {
                if (map.containsKey(current)) {
                    map.put(current, map.get(current) + 1);
                } else {
                    map.put(current, 1);
                }
            }
//            print(map.keySet() +"\n");
            if(map.size()<=2){
//                print("updating length \n");
                len = i-j;
                if(len>maxLength){
                    maxLength = len;
                }
                i++;
                newI =true;
            }else if(map.size()>2){
                if(map.containsKey(tree[j])) {
                    if (map.get(tree[j]) > 1) {
                        map.put(tree[j], map.get(tree[j]) - 1);
                    } else {
                        map.remove(tree[j]);
                    }
                }
//                print(map.keySet() +"\n");
                j++;
                newI = false;
//                if(!map.containsKey(tree[j])){
//                    map.put(tree[j],true);
//                }
            }else{
                i++;
                newI =true;
            }

//            print("\n");
        }

        return maxLength+1;

    }
}
