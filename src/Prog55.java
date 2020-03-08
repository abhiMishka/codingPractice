import java.util.HashSet;

public class Prog55 extends BaseTestClass {

    public static void main(String... args) {

        String message = " ";
        print(pangrams(message));

    }

    static String pangrams(String s) {

        HashSet<Character> hashSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            hashSet.add(Character.toLowerCase(s.charAt(i)));
        }

        if (hashSet.size() == 26) return "pangram";

        return "not pangram";

    }
}
