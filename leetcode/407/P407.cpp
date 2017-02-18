#include <queue>
#include <vector>
#include <iostream>
using namespace std;

//vector<vector<int>> *heightMap

class Solution {
public:
  struct Cell {
    int x, y;
    Cell(int x, int y): x(x), y(y) {}
  };
  
  static vector<vector<int>> *heightMap;
  
  struct Cmp {
    bool operator()(const Cell &a, const Cell &b) {
      return (*Solution::heightMap)[a.x][a.y] > (*Solution::heightMap)[b.x][b.y];
    }
  };
  
  int trapRainWater(vector<vector<int>>& heightMap) {
    this->heightMap = &heightMap;
    int n = heightMap.size(), m = heightMap[0].size();
    priority_queue<Cell, vector<Cell>, Cmp> heap;
    for (int i = 0; i < n; i++) {
      heap.emplace(i, 0);
      heap.emplace(i, m - 1);
    }
    for (int j = 1; j < m - 1; j++) {
      heap.emplace(0, j);
      heap.emplace(n - 1, j);
    }
  }
};

vector<vector<int>> *Solution::heightMap = 0;

int main() {
  vector<vector<int>> v{{1, 2, 3},{4, 5, 6}};
  Solution().trapRainWater(v);
  cout << Solution::heightMap;
  Solution::Cmp cmp();
}
