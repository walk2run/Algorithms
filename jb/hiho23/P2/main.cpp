#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;

vector<string>* split(const string &s, const string &r) {
  vector<string>* vec = new vector<string>;
  string::size_type pos1, pos2;
  pos1 = 0;
  pos2 = s.find(r);
  while (pos2 != string::npos) {
    vec->push_back(s.substr(pos1, pos2 - pos1));
    pos1 = pos2 + r.size();
    pos2 = s.find(r, pos1);
  }
  if (pos1 != s.length())
    vec->push_back(s.substr(pos1));
  return vec;
}

struct Node {
  string name;
  vector<Node> vec;
};

int main() {
  int n;
  cin >> n;
  vector<vector<string>*> vecs;
  Node root;
  for (int i = 0; i < n; i++) {
    string str;
    cin >> str;
    cout << str << endl;
    vector<string>* vec = split(str, "/");
    vecs.push_back(vec);
    Node *cur = &root;
    for (auto s : *vec) {
      for (Node node : cur->vec) {

      }
      cout << s << ' ';
    }
    cout << endl;
  }
  return 0;
}