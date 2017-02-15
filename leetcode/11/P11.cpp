class Solution {
public:
    int maxArea(vector<int>& height) {
        int i = 0;
        int j = height.size() - 1;
        int max = 0;
        while (i < j) {
            max = std::max(max, std::min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) i++; else j--;
        }
        return max;
    }
};
