// 208. Implement Trie (Prefix Tree)
#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

struct Node {
  char ch;
  bool word = false;
  unordered_map<char, Node *> map;
};

class Trie {
private:
  Node *root;

public:
  /** Initialize your data structure here. */
  Trie() {
    root = new Node();
  }

  /** Inserts a word into the trie. */
  void insert(string word) {
    Node *node = root;
    for (char ch : word) {
      auto it = node->map.find(ch);
      if (it == node->map.end()) {
        Node *child = new Node();
        child->ch = ch;
        node->map[ch] = child;
        node = child;
      } else {
        node = it->second;
      }
    }
    node->word = true;
  }

  /** Returns if the word is in the trie. */
  bool search(string word) {
    Node *node = root;
    for (char ch : word) {
      auto it = node->map.find(ch);
      if (it == node->map.end()) return false;
      node = it->second;
    }
    return node->word;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  bool startsWith(string prefix) {
    Node *node = root;
    for (char ch : prefix) {
      auto it = node->map.find(ch);
      if (it == node->map.end()) return false;
      node = it->second;
    }
    return true;
  }
};

int main() {
  Trie trie;
  trie.insert("abc");
  std::cout << "Hello, World!" << std::endl;
  return 0;
}