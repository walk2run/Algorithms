class Solution {
public:
    vector<string> generateParenthesis(int n) {
		this->n = n;
        search(0, 0);
		return answer;
    }
	
	void search(int n1, int n2) {
		if (n2 == n) {
			stdStr.clear();
			stdStr.assign(str.begin(), str.end());
			answer.push_back(stdStr);
			return;
		}	
		if (n1 < n) {
			str.push_back('(');
			search(n1 + 1, n2);
			str.pop_back();
		}
		if (n2 < n1) {
			str.push_back(')');
			search(n1, n2 + 1);
			str.pop_back();
		}
	}
	
	vector<string> answer;
	vector<char> str;
	string stdStr;
	int n1, n2, n;	// num of left, right
};