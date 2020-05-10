import java.util.*;

public class BaseTestClass {

    public static void print(String message) {
        System.out.print(message);
    }

    public static void print(int message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);

    }

    public static void printSeparation() {
        println("\n ------------------------------------------ \n");
    }

    public static void print2D(int mat[][]) {
        // Loop through all rows
        for (int[] row : mat)

            // converting each row as string
            // and then printing in a separate line
            println(Arrays.toString(row));
    }

    public static void print2D(char mat[][]) {
        // Loop through all rows
        for (char[] row : mat)

            // converting each row as string
            // and then printing in a separate line
            println(Arrays.toString(row));
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static <K, V> String printMap(Map<K, V> map) {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            str.append(entry.getKey() + " : " + entry.getValue() + "\n");
        }

        return str.toString();
    }

    static class TrieNode {
        private HashMap<Character, TrieNode> map;
        private boolean isEnd;
        private List<String> suggestions;

        public HashMap<Character, TrieNode> getMap() {
            return map;
        }

        public void setMap(HashMap<Character, TrieNode> map) {
            this.map = map;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public TrieNode() {
            this.map = new HashMap<>();
            this.isEnd = false;
            this.suggestions = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "map=" + (map.keySet().toString()) +
                    ", isEnd=" + isEnd +
                    '}';
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie(TrieNode root) {
            this.root = root;
        }

        public TrieNode getRoot() {
            return root;
        }

        public void addWord(String word) {
            if (getRoot() == null) {
                println("NOT INITIALIZED");
                return;
            }
            TrieNode currentNode = getRoot();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode childNode = currentNode.getMap().get(c);
                if (childNode == null) {
                    childNode = new TrieNode();
                    currentNode.getMap().put(c, childNode);
                    currentNode.suggestions.add(word);
                }
                currentNode = childNode;
            }
            currentNode.setEnd(true);
        }

        public boolean search(String word){
            TrieNode currentNode = getRoot();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = currentNode.getMap().get(c);

                if(node == null){
                    return false;
                }

                currentNode = node;
            }

            return currentNode.isEnd;

        }

        public StringBuilder printTree(TrieNode node, StringBuilder word) {
            if (root == null) {
                println("NOT INITIALIZED");
                return new StringBuilder();
            }


            if (node.isEnd) return new StringBuilder();

            Set<Character> set = node.getMap().keySet();

            StringBuilder str = new StringBuilder();
            for (char c :
                    set) {
//                str = printTree(node.getMap().get(c), word).append(c);
//                println("map at " + c + " :  " + node.getMap().get(c).toString());
                printTree(node.getMap().get(c), word);
//                println("char  : " + c +" suggestions : " +node.getMap().get(c).suggestions.toString());

            }

            printSeparation();

            return str;

        }


        public List<String> getAllChildren(String query) {
            List<String> wordList = new ArrayList<>();
            if(query.length()==0) return wordList;

            TrieNode currentNode = getRoot();
            for (int i = 0; i < query.length(); i++) {
                char c = query.charAt(i);
                TrieNode node = currentNode.getMap().get(c);

                if(node == null){
                    wordList.add("No match found");
                    return wordList;
                }

                currentNode = node;
            }

            if(currentNode == null){
                wordList.add("No match found");
                return wordList;
            }
            visitRecursively(currentNode,wordList,new StringBuilder(query));
            return wordList;
        }

        public void visitRecursively(TrieNode node,List<String> listWords, StringBuilder foundStrings) {

            if (node.isEnd){
//                println("word : " +foundStrings.toString());
                listWords.add(foundStrings.toString());
            }

            HashMap<Character, TrieNode> map = node.map;

            Set<Character> set = map.keySet();

            for (Character c : set) {
                TrieNode childNode = map.get(c);
                foundStrings.append(c);

                visitRecursively(childNode,listWords,foundStrings);
                foundStrings.setLength(foundStrings.length()-1);

            }


        }


    }

}
