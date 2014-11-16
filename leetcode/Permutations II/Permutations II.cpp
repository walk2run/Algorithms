#include <vector>
#include <stdio.h>
using namespace std;

struct Pair {
	Pair(int v, int c) : value(v), count(c) {}
	int value, count;
};

class Solution {
public:	
    vector<vector<int> > permuteUnique(vector<int> &num) {
		bool find;
		for (int i : num) {
			find = false;
			for (auto &pair : pairs) {
				if (pair.value == i) {
					pair.count++;
					find = true;
					break;
				}
			}
			if (!find) pairs.push_back(Pair(i, 1));
		}
		search();
		return answers;
    }
	
	void search() {
		//printf("search\n");
		bool find = false;
		for (auto &pair : pairs) {
			//printf("%d %d\n", pair.value, pair.count);
			if (pair.count > 0) {
				find = true;
				answer.push_back(pair.value);
				pair.count--;
				search();
				pair.count++;
				answer.pop_back();
			}
		}
		if (!find) answers.push_back(answer);
	}

	vector<Pair> pairs;
	vector<vector<int> > answers;
	vector<int> answer;
};

int main() {
	vector<int> num = {1};
	auto sol = Solution();
	vector<vector<int> > answers = sol.permuteUnique(num);
	
	return 0;
}
