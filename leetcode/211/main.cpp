#include <iostream>
#include <string>
using namespace std;

struct Node {
  char ch;
  bool word = false;
  Node *list[26];
  Node() {
    fill(list, list + 26, nullptr);
  }
};

class WordDictionary {
private:
  Node *root;

public:
  /** Initialize your data structure here. */
  WordDictionary() {
    root = new Node();
  }

  /** Adds a word into the data structure. */
  void addWord(string word) {
    Node *node = root;
    for (char ch : word) {
      Node *child = node->list[ch - 'a'];
      if (child == nullptr) {
        child = new Node();
        child->ch = ch;
        node->list[ch - 'a'] = child;
      }
      node = child;
    }
    node->word = true;
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  bool search(string word) {
    return dfs(word, 0, root);
  }

  bool dfs(string &word, int i, Node *node) {
    if (i == word.length()) return node->word;
    char ch = word[i];
    if (ch != '.') {
      Node *child = node->list[ch - 'a'];
      if (child == nullptr) return false;
      return dfs(word, i + 1, child);
    } else {
      for (Node *child : node->list) {
        if (child != nullptr && dfs(word, i + 1, child)) return true;
      }
      return false;
    }
  }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * bool param_2 = obj.search(word);
 */

int main() {
  WordDictionary wd;
  wd.addWord("at");
  wd.addWord("and");
  wd.addWord("an");
  wd.addWord("add");
  cout << wd.search("a");
  cout << wd.search(".at");
  wd.addWord("bat");
  cout << wd.search(".at");
  cout << wd.search("an.");
  cout << wd.search("a.d.");
  cout << wd.search("b.");
  cout << wd.search("a.d");
  cout << wd.search(".");
  std::cout << "Hello, World!" << std::endl;
  return 0;
}