// 188. Best Time to Buy and Sell Stock IV
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
  int maxProfit(int k, vector<int>& prices) {
    if (k >= (int) (prices.size() / 2)) {
      int sum = 0;
      for (int i = 1; i < prices.size(); i++)
        sum += max(prices[i] - prices[i - 1], 0);
      return sum;
    }
    int *buy = new int[k];
    int *sell = new int[k]();
    fill(buy, buy + k, INT32_MIN);
    for (int price : prices) {
      for (int i = k - 1; i >= 0; i--) {
        sell[i] = max(sell[i], buy[i] + price);
        buy[i] = max(buy[i], (i == 0 ? 0 : sell[i - 1]) - price);
      }
    }
    return sell[k - 1];
  }
};

int main() {
  vector<int> vec = {1, 2};
  Solution().maxProfit(1, vec);
  return 0;
}