import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Prog83 extends BaseTestClass {

    public static void main(String... args) {

        println(partitionLabels("ababcbacadefegdehijhklij").toString());
        println(partitionLabels("aaaaaabb").toString());
        println(partitionLabels("abcdefa").toString());
        println(partitionLabels("eaaaabaaec").toString());
        println(partitionLabels("abcdefghij").toString());

    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();

        if (S == null || S.length() == 0) return ans;
        if (S.length() == 1) {
            ans.add(1);
            return ans;
        }

        int[] map = new int[26];

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            map[c-'a'] = i;
        }

        int prevEnd = map[S.charAt(0)-'a'];
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int currentEnd = map[c-'a'];
            if (i <= prevEnd) {
                count++;
                if (currentEnd > prevEnd) {
                    prevEnd = currentEnd;
                }
            } else {
                ans.add(count);
                count = 1;
                prevEnd = map[c-'a'];
            }
        }

        ans.add(count);

        return ans;
    }
}
