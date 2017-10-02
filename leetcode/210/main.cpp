// 210. Course Schedule II
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Solution {
public:
  vector<int> findOrder(int numCourses, vector<pair<int, int>>& prerequisites) {
    vector<int> *es = new vector<int>[numCourses];
    int in[numCourses];
    fill(in, in + numCourses, 0);
    for (auto &pair : prerequisites) {
      es[pair.second].push_back(pair.first);
      in[pair.first]++;
    }
    queue<int> queue;
    for (int i = 0; i < numCourses; i++)
      if (in[i] == 0) queue.push(i);
    vector<int> ans;
    while (!queue.empty()) {
      int v = queue.front();
      queue.pop();
      ans.push_back(v);
      for (int v2 : es[v])
        if (--in[v2] == 0) queue.push(v2);
    }
    return ans.size() == numCourses ? ans : vector<int>();
  }
};

int main() {
  vector<pair<int, int>> vec = {{1, 0}};
  Solution().findOrder(2, vec);
  std::cout << "Hello, World!" << std::endl;
  return 0;
}