class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int idx = -1;
    int refs = 0;

    public void addWord(String word, int i) {
        TrieNode cur = this;
        cur.refs++;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
            cur.refs++;
        }
        cur.idx = i;
    }
}

public class Solution {
    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            root.addWord(words[i], i);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                root.refs -= dfs(board, root, r, c, words);
            }
        }

        return res;
    }

    private int dfs(char[][] board, TrieNode node, int r, int c, String[] words) {
        if (r < 0 || c < 0 || r >= board.length ||
            c >= board[0].length || board[r][c] == '*' ||
            node.children[board[r][c] - 'a'] == null) {
            return 0;
        }

        char temp = board[r][c];
        board[r][c] = '*';
        TrieNode prev = node;
        node = node.children[temp - 'a'];
        int found = 0;
        if (node.idx != -1) {
            res.add(words[node.idx]);
            node.idx = -1;
            found++;
        }

        found += dfs(board, node, r + 1, c, words);
        found += dfs(board, node, r - 1, c, words);
        found += dfs(board, node, r, c + 1, words);
        found += dfs(board, node, r, c - 1, words);

        board[r][c] = temp;
        node.refs -= found;
        if (node.refs == 0) {
            prev.children[temp - 'a'] = null;
        }
        return found;
    }
}