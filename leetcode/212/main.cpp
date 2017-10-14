// 212. Word Search II
#include <iostream>
#include <string>
#include <vector>
#include <unordered_set>
using namespace std;

class Solution {
public:
  vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
    root = new Node();
    for (string &word : words)
      add(word);
    n = board.size();
    m = board[0].size();
    vector<vector<bool>> use(n, vector<bool>(m));
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        dfs(board, use, i, j, root);
    vector<string> vec;
    for (const string &str : set)
      vec.push_back(str);
    return vec;
  }

private:
  struct Node {
    bool word = false;
    Node *list[26];
    Node() {
      fill(list, list + 26, nullptr);
    }
  };

  Node *root;
  unordered_set<string> set;
  string ans;
  int n, m;

  void add(string &str) {
    Node *node = root;
    for (char ch : str) {
      if (ch < 'a' || ch > 'z') throw new exception;
      Node *child = node->list[ch - 'a'];
      if (child == nullptr) {
        child = new Node();
        node->list[ch - 'a'] = child;
      }
      node = child;
    }
    node->word = true;
  }

  void dfs(vector<vector<char>>& board, vector<vector<bool>> &use,
           int i, int j, Node *node) {
    if (use[i][j]) return;
    char ch = board[i][j];
    if (ch < 'a' || ch > 'z') throw new exception;
    Node *child = node->list[ch - 'a'];
    if (child != nullptr) {
      ans.push_back(ch);
      use[i][j] = true;

      if (child->word)
        set.insert(ans);

      if (i > 0)
        dfs(board, use, i - 1, j, child);
      if (i < n - 1)
        dfs(board, use, i + 1, j, child);
      if (j > 0)
        dfs(board, use, i, j - 1, child);
      if (j < m - 1)
        dfs(board, use, i, j + 1, child);

      ans.pop_back();
      use[i][j] = false;
    }
  }

  void release(Node *node) {
    if (node == nullptr) return;
    for (Node *child : node->list)
      release(child);
    delete node;
  }
};

int main() {
  unordered_set<string> set;

  Solution sol;
  vector<vector<char>> board = {{'b'}, {'a'}, {'b'}, {'b'}, {'a'}};
  vector<string> words = {"baa", "abba", "baab", "aba"};
  sol.findWords(board, words);

  set.insert("aa");
  set.insert("aa");
  set.insert("b");
  cout << set.size();

  vector<vector<bool>> a(5, vector<bool>(5));
  a[0][0] = 1;
  cout << a[0][0];
  cout << a[2][0];

  std::cout << "Hello, World!" << std::endl;
  return 0;
}