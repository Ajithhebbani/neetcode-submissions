class WordDictionary {

   class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index) {
        if (node == null) {
            return false;
        }

        // All characters matched
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        if (c == '.') {
            // Try every possible letter
            for (TrieNode child : node.children) {
                if (child != null && dfs(child, word, index + 1)) {
                    return true;
                }
            }

            return false;
        } else {
            // Follow the matching character
            return dfs(node.children[c - 'a'], word, index + 1);
        }
    }
}
