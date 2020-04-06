import java.util.*;

public class Prog63 extends BaseTestClass {

    public static void main(String... args) {

        List<List<String>> anagramGroupList = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
//        List<List<String>> anagramGroupList = groupAnagrams(new String[]{"per","flu"});

        for (List<String> list :
                anagramGroupList) {
            println(list.toString());
        }
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {

        List<List<String>> anagramGroupList = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String word :
                strs) {

            char[] arr = word.toCharArray();
            Arrays.sort(arr);

            String key = String.valueOf(arr);
            if (map.containsKey(key)) {
                List<String> prevList = map.get(key);
                prevList.add(word);
                map.put(key, prevList);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(word);
                map.put(key, newList);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<Node, List<String>> map = new HashMap<>();
        for (String word : strs) {

            HashMap<Character, Integer> charCountMap = new HashMap<>();

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (charCountMap.containsKey(c)) {
                    charCountMap.put(c, charCountMap.get(c) + 1);
                } else {
                    charCountMap.put(c, 1);
                }

            }

            Node key = new Node(charCountMap);

            if (map.containsKey(key)) {
                List<String> prevList = map.get(key);
                prevList.add(word);
                map.put(key, prevList);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(word);
                map.put(key, newList);
            }
        }

        return new ArrayList<>(map.values());

    }

    static class Node {
        HashMap<Character, Integer> charCountMap;

        Node(HashMap<Character, Integer> charCountMap) {
            this.charCountMap = charCountMap;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return charCountMap.hashCode() == node.charCountMap.hashCode();
        }

        @Override
        public int hashCode() {
            return Objects.hash(charCountMap);
        }
    }

}
