import java.util.*;

public class Prog16 extends BaseTestClass {


    public static void main(String... args) {

        String que = "vk)ln(vnjk(vefhk)vebvi437((974g)))))fiv3(fbu(";


        char[] ans = validArray(que.toCharArray());
        print("ans : " + Arrays.toString(ans));
    }

    public static char[] validArray(char[] arr){

        int[] copy= new int[arr.length];


        List<Character> characterList = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();
        List<Integer> validIndex = new ArrayList<>();

//        Stack<Character> braceList = new Stack<>();

        int braceCount = 0;


        for(int i =0 ;i<arr.length;i++){

            if(arr[i]=='('){
//                braceList.push(arr[i]);
                braceCount++;
                indexList.add(i);
            }else if(arr[i] == ')'){
                if(braceCount > 0){
                    braceCount--;
                    validIndex.add(i);
                    validIndex.add(indexList.remove(indexList.size()-1));
//                    for(int j=0;j<copy.length;j++){
//                        if(copy[j]==1){
//                            copy[j]=-1;
//                            break;
//                        }
//                    }
                }
            }

        }

//        for(int j=0;j<copy.length;j++){
//            if(copy[j]=='('){
//                copy[j]=-1;
//            }
//        }

        for(int i=0;i<arr.length;i++){

            if(arr[i] == '(' || arr[i] == ')'){
                if(validIndex.contains(i)){
                    characterList.add(arr[i]);
                }
            }else{
                characterList.add(arr[i]);
            }

        }

        char[] finalArray = new char[characterList.size()];

        int x = 0;
        for (Character c :
                characterList) {
            finalArray[x] = c;
            x++;
        }


        return finalArray;


    }


}
