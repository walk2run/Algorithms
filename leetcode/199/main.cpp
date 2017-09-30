// 199. Binary Tree Right Side View
#include <iostream>
#include <vector>
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  vector<int> rightSideView(TreeNode* root) {
    vector<int> ans;
    if (root == NULL) return ans;
    vector<TreeNode*> *vec = new vector<TreeNode*>;
    vec->push_back(root);
    while (!vec->empty()) {
      vector<TreeNode*> *newVec = new vector<TreeNode*>;
      for (int i = 0; i < vec->size(); i++) {
        if (i == vec->size() - 1) ans.push_back(vec->at(i)->val);
        if (vec->at(i)->left != NULL) newVec->push_back(vec->at(i)->left);
        if (vec->at(i)->right != NULL) newVec->push_back(vec->at(i)->right);
      }
      delete vec;
      vec = newVec;
    }
    return ans;
  }
};

int main() {
  std::cout << "Hello, World!" << std::endl;
  return 0;
}