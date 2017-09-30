class Solution {
public:
  int numIslands(vector<vector<char>>& grid) {
    n = grid.size();
    if (n == 0) return 0;
    m = grid[0].size();
    if (m == 0) return 0;
    int count = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (grid[i][j] == '1') count++, dfs(i, j, grid);
    return count;
  }
  
  int n, m;
  
  void dfs(int i, int j, vector<vector<char>> &g) {
    if (g[i][j] == '0') return;
    g[i][j] = '0';
    if (i > 0) dfs(i - 1, j, g);
    if (i < n - 1) dfs(i + 1, j, g);
    if (j > 0) dfs(i, j - 1, g);
    if (j < m - 1) dfs(i, j + 1, g);
  }
};
