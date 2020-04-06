import java.util.ArrayList;
import java.util.Scanner;

public class GoogleKickstart1 {


    static int maxLength = 0;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String ab = in.nextLine();
            String[] input = ab.split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            String[] wordList = new String[a];
            String word = "";
            for(int k =0 ;k<a;k++){
                word = in.nextLine();
                wordList[k] = (word.toLowerCase().trim());
            }

            subset(wordList,b,0,0,new boolean[a]);

            System.out.println("Case #" + i + ": " + maxLength);
            maxLength = 0;
        }
    }


    // Trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[26];

        // isLeaf is true if the node represents
        // end of a word
        boolean isLeaf;

        // constructor
        public TrieNode() {
            isLeaf = false;
            for (int i = 0; i < 26; i++)
                children[i] = null;
        }
    };

    static TrieNode root;
    static int indexs;

    static void insert(String key)
    {
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (int level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        pCrawl.isLeaf = true;
    }

    public static void subset(String[] A, int k, int start, int currLen, boolean[] used) {

        if (currLen == k) {
            ArrayList<String> sub = new ArrayList<>();
            for (int i = 0; i < A.length; i++) {
                if (used[i]) {
                    sub.add(A[i]);
                }
            }
            String ans = commonPrefix(sub.toArray(new String[0]), sub.size());
            if(maxLength<ans.length()){
                maxLength = ans.length();
            }

            return;
        }
        if (start == A.length) {
            return;
        }
        used[start] = true;
        subset(A, k, start + 1, currLen + 1, used);
        used[start] = false;
        subset(A, k, start + 1, currLen, used);
    }

    static int countChildren(TrieNode node)
    {
        int count = 0;
        for (int i=0; i<26; i++)
        {
            if (node.children[i] != null)
            {
                count++;
                indexs = i;
            }
        }
        return (count);
    }

    static String walkTrie()
    {
        TrieNode pCrawl = root;
        indexs = 0;
        String prefix = "";

        while (countChildren(pCrawl) == 1 &&
                pCrawl.isLeaf == false)
        {
            pCrawl = pCrawl.children[indexs];
            prefix += (char)('a' + indexs);
        }
        return prefix;
    }

    static void constructTrie(String arr[], int n)
    {
        for (int i = 0; i < n; i++)
            insert (arr[i]);
        return;
    }

    static String commonPrefix(String arr[], int n)
    {
        indexs = 0;
        root = new TrieNode();
        constructTrie(arr, n);

        return walkTrie();
    }

}
