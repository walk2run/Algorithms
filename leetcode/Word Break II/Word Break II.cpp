#include <vector>
#include <unordered_set>
#include <map>
#include <string>
#include <iostream>
using namespace std;

struct Pair {
	Pair(int a, int b) : a(a), b(b) {}
	int a, b;
};

bool operator<(const Pair &a, const Pair &b) {
	return a.a < b.a || a.a == b.a && a.b < b.b;
}

class Solution {
public:
	vector<string> wordBreak(string s, unordered_set<string> &dict) {
		this->s = s;
		this->dict = dict;
		answer = "";
		search(0);
		return answers;
	}
	
	// start from s[i]
	void search(int i) {
		//cout << i << endl;
		//cout << answer << endl;
		if (i == s.size()) {
			answer.pop_back();
			answers.push_back(answer);
			answer += " ";
			return;
		}
		if (i == 0) answer.clear();
		int wordIndex = 0;
		for (auto word : dict) {
			//cout << i << ' ' << word << endl;
			if (compare(i, word, wordIndex)) {
				answer += word + " ";
				search(i + word.size());
				answer.resize(answer.size() - word.size() - 1);
				//answer.erase(answer.size() - word.size() - 1, word.size() + 1);
			}
			wordIndex++;
		}
	}
	
	bool compare(int start, string &word, int wordIndex) {
		bool equal = true;
		int i = start;
		auto iter = cmpMap.find(Pair(i, wordIndex));
		if (iter != cmpMap.end()) return iter->second;
		for (char ch : word) {
			if (i == s.size()) {
				equal = false;
				break;
			}
			if (s[i] != ch) {
				equal = false;
				break;
			}
			i++;
		}
		//cout << "map " << start << ends << wordIndex << ends << equal << endl;
		cmpMap.insert(make_pair(Pair(start, wordIndex), equal));
		return equal;
	}
	
	vector<string> answers;
	string s, answer;
	unordered_set<string> dict;
	map<Pair, bool> cmpMap;
};

int main() {
	string s = "catsanddog";
	unordered_set<string> dict{"cat", "cats", "and", "sand", "dog"};
	for (auto str : dict)
		cout << str << ' ';
	cout << endl;
	auto answers = Solution().wordBreak(s, dict);
	for (auto &str : answers)
		cout << "\"" << str << "\"" << endl;
	return 0;
}
