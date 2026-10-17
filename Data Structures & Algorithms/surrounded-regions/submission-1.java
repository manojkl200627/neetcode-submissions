class DSU {
    int[] Parent, Size;

    public DSU(int n) {
        Parent = new int[n + 1];
        Size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            Parent[i] = i;
            Size[i] = 1;
        }
    }

    public int find(int node) {
        if (Parent[node] != node) {
            Parent[node] = find(Parent[node]);
        }
        return Parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);
        if (pu == pv) return false;
        if (Size[pu] >= Size[pv]) {
            Size[pu] += Size[pv];
            Parent[pv] = pu;
        } else {
            Size[pv] += Size[pu];
            Parent[pu] = pv;
        }
        return true;
    }

    public boolean connected(int u, int v) {
        return find(u) == find(v);
    }
}

public class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;
        DSU dsu = new DSU(ROWS * COLS + 1);
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] != 'O') continue;
                if (r == 0 || c == 0 ||
                    r == ROWS - 1 || c == COLS - 1) {
                    dsu.union(ROWS * COLS, r * COLS + c);
                } else {
                    for (int[] dir : directions) {
                        int nr = r + dir[0], nc = c + dir[1];
                        if (board[nr][nc] == 'O') {
                            dsu.union(r * COLS + c, nr * COLS + nc);
                        }
                    }
                }
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (!dsu.connected(ROWS * COLS, r * COLS + c)) {
                    board[r][c] = 'X';
                }
            }
        }
    }
}