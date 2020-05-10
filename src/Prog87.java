import java.util.*;

public class Prog87 extends BaseTestClass {
    public static void main(String... args){

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Trie trie = new Trie(new TrieNode());

        Arrays.sort(products);

        for (String product :
                products) {
            trie.addWord(product);
        }

        StringBuilder searchQuery = new StringBuilder();
        for (int i = 0; i < searchWord.length(); i++) {
            searchQuery.append(searchWord.charAt(i));
            ans.add(trie.getAllChildren(searchQuery.toString()));
        }


        return ans;


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
        private TreeMap<Character, TrieNode> map;
        private boolean isEnd;

        public TreeMap<Character, TrieNode> getMap() {
            return map;
        }

        public void setMap(TreeMap<Character, TrieNode> map) {
            this.map = map;
        }

        boolean isEnd() {
            return isEnd;
        }

        void setEnd(boolean end) {
            isEnd = end;
        }

        TrieNode() {
            this.map = new TreeMap<>();
            this.isEnd = false;
        }

    }

    static class Trie {
        private TrieNode root;

        Trie(TrieNode root) {
            this.root = root;
        }

        TrieNode getRoot() {
            return root;
        }

        void addWord(String word) {
            if (getRoot() == null) {
                return;
            }
            TrieNode currentNode = getRoot();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode childNode = currentNode.getMap().get(c);
                if (childNode == null) {
                    childNode = new TrieNode();
                    currentNode.getMap().put(c, childNode);
                }
                currentNode = childNode;
            }
            currentNode.setEnd(true);
        }

        List<String> getAllChildren(String query) {
            List<String> wordList = new ArrayList<>();
            if(query.length()==0) return wordList;

            TrieNode currentNode = getRoot();
            for (int i = 0; i < query.length(); i++) {
                char c = query.charAt(i);
                TrieNode node = currentNode.getMap().get(c);

                if(node == null){
//                    wordList.add("No match found");
                    return wordList;
                }

                currentNode = node;
            }

            visitRecursively(currentNode,wordList,new StringBuilder(String.valueOf((query))));
            return wordList;
        }

        public void visitRecursively(TrieNode node, List<String> listWords, StringBuilder foundStrings) {

            if (node.isEnd()){
                listWords.add(foundStrings.toString());
            }

            TreeMap<Character, TrieNode> map = node.getMap();

            Set<Character> set = map.keySet();

            for (Character c : set) {
                TrieNode childNode = map.get(c);
                foundStrings.append(c);

                if(listWords.size()==3) return;
                visitRecursively(childNode,listWords,foundStrings);
                foundStrings.setLength(foundStrings.length()-1);

            }


        }


    }
}
