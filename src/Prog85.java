import java.util.*;


/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */
public class Prog85 extends BaseTestClass {

    public static void main(String... args) {

//        println(Arrays.toString(reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
        println(Arrays.toString(reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"})));
//        reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"});

    }

    public static String[] reorderLogFiles(String[] logs) {
        String[] ans = new String[logs.length];

        PriorityQueue<String> letterLogs = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ", 2);
                String[] s2 = o2.split(" ", 2);
                if(s1[1].compareTo(s2[1]) == 0){
                    return s1[0].compareTo(s2[0]);
                }
                else{
                    return s1[1].compareTo(s2[1]);
                }
            }
        });

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, 1);
        }


        int count = 0;
        for (String log :
                logs) {
            String[] splitedString = log.split(" ");
            if (!map.containsKey(splitedString[1].charAt(0) - '0')) {
                letterLogs.add(log);
            }
        }

        while (!letterLogs.isEmpty()){
            String rest = letterLogs.poll().trim();
            ans[count++] = rest;
        }

        for (String log :
                logs) {
            String[] splitedString = log.split(" ");
            if (map.containsKey(splitedString[1].charAt(0) - '0')) {
                ans[count++] = log;
            }
        }

        return ans;
    }
}
