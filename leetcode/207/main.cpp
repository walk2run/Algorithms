// 207. Course Schedule
#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>
using namespace std;

class Solution {
public:
  bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
    unordered_map<int, vector<int>> g;
    unordered_map<int, int> in;
    for (int i = 0; i < numCourses; i++)
      in[i] = 0;
    for (auto &pair : prerequisites) {
      int e1 = pair.first, e2 = pair.second;
      g[e2].push_back(e1);
      in[e1]++;
    }
    queue<int> queue;
    for (auto &pair : in)
      if (pair.second == 0) queue.push(pair.first);
    int count = 0;
    while (!queue.empty()) {
      int v = queue.front();
      queue.pop();
      count++;
      for (int v2 : g[v])
        if (--in[v2] == 0) queue.push(v2);
    }
    return count == numCourses;
  }
};

int main() {
  vector<pair<int, int>> pre = {{1, 0}, {0, 1}};
  cout << Solution().canFinish(2, pre);
  return 0;
}