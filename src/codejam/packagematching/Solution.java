package codejam.packagematching;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int size = Integer.parseInt(in.nextLine());
            String[] allStrings = new String[size];
            int k=0;
            int longestLength = 0;
            while (size-- >0){
                StringBuilder a = new StringBuilder(in.nextLine());
                allStrings[k] = a.reverse().toString();
                int len = allStrings[k].length();
                if(len>longestLength) longestLength = len;
                k++;
            }
           findPattern(allStrings,i,longestLength);
        }
    }

    public static void findPattern(String[] patterns,int caseNumber,int longestLength){

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < longestLength; i++) {
            char c = 0;
            char lastC = 0;
            boolean added = false;
            Map<Integer,Character> characters = new HashMap<>();
            for (String pat :
                    patterns) {
                if(i<pat.length()){
                    if(pat.charAt(i)=='*'){
                        characters.put(1,'*');
                    }else{
                        if(characters.containsKey(0) && characters.get(0)!=pat.charAt(i)){
                            System.out.println("Case #" + caseNumber + ": " + "*");
                            return;
                        }else {
                            characters.put(0, pat.charAt(i));
                        }
                    }
                }
                if(lastC=='*'){
                    characters.put(1,'*');
                }
//                System.out.println("c : " + c + " lastC : " + lastC);

//                if (c==lastC || c=='*' || lastC=='*'){
//                    if(c!='*' && !added && c!=0){
//                        ans.append(c);
//                        added = true;
//                    }
//                }else {
//                    System.out.println("Case #" + caseNumber + ": " + "*");
//                    return;
//                }

            }

            if(characters.containsKey(0) || characters.containsKey(1)){
                if(characters.containsKey(0)) ans.append(characters.get(0));
            }else{
                System.out.println("Case #" + caseNumber + ": " + "*");
                return;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + ans.reverse());

    }
}
