// 212. Word Search II
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
  vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
    root = new Node();
    for (string &word : words)
      add(word);
  }

private:
  struct Node {
    char ch;
    bool word = false;
    Node *child[26];
    Node() {
      fill(child, child + 26, nullptr);
    }
  };

  Node *root;

  void add(string &string) {
    Node *node = root;
  }
};

int main() {
  std::cout << "Hello, World!" << std::endl;
  return 0;
}