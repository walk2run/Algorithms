#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

struct Point {
    int x;
    int y;
    Point() : x(0), y(0) {}
    Point(int a, int b) : x(a), y(b) {}
};

class Solution {
public:
  int maxPoints(std::vector<Point>& points) {
    int i, j, count, max;
    double ratio;
    std::unordered_map<double, int> map;
    max = points.empty() ? 0 : 1;
    for (i = 0; i < points.size(); i++) {
      count = 1;
      map.clear();
      for (j = 0; j < points.size(); j++) {
        if (i == j) continue;
        if (points[i].x == points[j].x && points[i].y == points[j].y)
          count++;
        else {
          if (points[i].x == points[j].x)
            ratio = 1e37;
          else
            ratio = (points[i].y - points[j].y) / double(points[i].x - points[j].x);
          auto iter = map.find(ratio);
          if (iter == map.end())
            map.insert({ratio, 1});
          else
            iter->second++;
        }
        max = std::max(count, max);
        for (auto &p : map)
          max = std::max(p.second + count, max);
      }
    }
    return max;
  }
};

int main() {
  std::vector<Point> v{Point(1, 2)};
  std::cout << Solution().maxPoints(v);
  return 0;
}

