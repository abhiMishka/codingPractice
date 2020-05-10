import java.util.HashMap;

public class TrieDemo extends BaseTestClass {
    public static void main(String... args) {

        Trie trie = new Trie(new TrieNode());

        trie.addWord("abhishek");
        trie.addWord("abkalam");
        trie.addWord("abhi");
        trie.addWord("second");
        trie.addWord("seculant");

//        trie.addWord("abhishek");
//        trie.addWord("abhiNotshake");
//        trie.addWord("abhiWHYshake");
//        trie.addWord("abhi");
//        trie.addWord("abhikalam");
//        trie.addWord("abhisss");
//        trie.addWord("second");
//        trie.addWord("seculant");
//        trie.addWord("seductive");
//        trie.addWord("sorry");

        println("a : " +trie.getAllChildren("a").toString());
        println("ab : " +trie.getAllChildren("ab").toString());
        println("abhis : " +trie.getAllChildren("abhis").toString());
        println("s : " +trie.getAllChildren("s").toString());
        println("se : " +trie.getAllChildren("se").toString());
        println("so : " +trie.getAllChildren("so").toString());
        println("secu : " +trie.getAllChildren("secu").toString());
        println("seco : " +trie.getAllChildren("seco").toString());

//        trie.addWord("abhi");
//        println(String.valueOf(trie.search("abhishek")));
//        println(String.valueOf(trie.search("abhi")));
//        trie.printTree(trie.getRoot(), new StringBuilder());
//        trie.addWord("abkalam");
//        trie.addWord("abhi");
//        trie.addWord("second");
//        trie.addWord("seculant");

//        println(trie.getAllChildren("ab").toString());


    }


}
