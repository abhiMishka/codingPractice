import java.util.*;

public class Prog94 extends BaseTestClass {
    public static void main(String... args) {
//        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
//        int ans = ladderLength("hit", "cog", Arrays.asList(words));
        println("ans1 : " + rangeBitwiseAnd(5, 7));

        Deque<Integer> deque = new LinkedList<>();
        ((LinkedList<Integer>) deque).remove(1);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> distanceMap = new HashMap<>(1);
        HashSet<String> wordSet = new HashSet<>(wordList);

        Deque<String> wordQueue = new LinkedList<>();
        wordQueue.offer(beginWord);
        wordSet.remove(beginWord);
        int level = 1;

        while (!wordQueue.isEmpty()) {
            String visitingWord = wordQueue.poll();
            Iterator<String> wordIterator = wordSet.iterator();
            println("set : " + wordSet);
            while (wordIterator.hasNext()) {
                String word = wordIterator.next();
                int i = 0;
                int diff = 0;
                for (char c :
                        word.toCharArray()) {
                    if (c != visitingWord.charAt(i)) {
                        diff++;
                        if (diff > 1) break;
                    }
                    i++;
                }
                if (diff == 1) {
                    if (word.equals(endWord)) return level;
                    wordQueue.offer(word);
                    wordIterator.remove();
                    println("removinng : \t" + word);
                }
            }
            level++;
        }


        return 0;


//        return ladderRecur(beginWord, endWord, wordList, distanceMap, 0);

    }

    private static int ladderRecur(String beginWord, String endWord, List<String> wordList, Map<String, Integer> distanceMap, int count) {

        if (distanceMap != null) printMap(distanceMap);
        printSeparation();
        if (beginWord.equals(endWord)) {
            println("FOUND MATCH  from " + beginWord + " to " + endWord + " in steps : " + count + 1);
            distanceMap.put(beginWord, count + 1);
            return count + 1;
        }
//        if (wordList.isEmpty()) return 0;

        if (distanceMap.containsKey(beginWord)) return distanceMap.get(beginWord) + 1;

        wordList.remove(beginWord);
        List<Integer> list = new ArrayList<>();
        for (String word :
                wordList) {
//            println("exploring : "+word +" beginWord : " +beginWord);
            List<String> clone = new ArrayList<>(wordList);
            int i = 0;
            int diff = 0;
            for (char c :
                    word.toCharArray()) {
                if (c != beginWord.charAt(i)) {
                    diff++;
                    if (diff > 1) break;
                }
                i++;
            }
//            println("diffi with  : "+beginWord +" = "+diff);

            if (diff == 1) {
//                println("word : " +word +" , beginWord : " +beginWord);
                clone.remove(word);
//                println("new list : " +clone.toString() +"  selected word : " +word);
                list.add(ladderRecur(word, endWord, clone, distanceMap, count));
            }

        }
        if (!list.isEmpty()) {
            distanceMap.put(beginWord, Collections.min(list));
        }


        return distanceMap.getOrDefault(beginWord, 0);

    }

    public String reorganizeString(String S) {
        StringBuilder ans = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character c :
                S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = S.length();
        char lastChar = '@';
        while (count>0) {
            Set<Character> keys = map.keySet();

            for (Character c : keys) {
                count--;
                if (map.get(c) == 0){
                    continue;
                }
                if(c==lastChar) return "";
                ans.append(c);
                map.put(c, map.get(c) - 1);
                lastChar = c;
            }
        }


        return ans.toString();
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int ans = m;

        for (int i = m + 1; i <= n; i++) {
            ans = ans & i;
        }

        return ans;

    }
}
