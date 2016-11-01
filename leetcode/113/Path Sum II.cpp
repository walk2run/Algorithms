/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int> > pathSum(TreeNode *root, int sum) {
        expSum = sum;
		if (root) search(root, 0);
		return paths;
    }
	
	void search(TreeNode *root, int sum) {
		sum += root->val;
		path.push_back(root->val);
		if (!root->left && !root->right && sum == expSum && path.size() > 0)
			paths.push_back(path);
		else {
			if (root->left)
				search(root->left, sum);
			if (root->right)
				search(root->right, sum);
		}
		path.pop_back();
	}
	
	int expSum;
	vector<int> path;
	vector<vector<int> > paths;
};