class Solution {
public:
    int trap(vector<int>& height) {
        int i = 0, j = height.size() - 1, sum = 0, h = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                h = std::max(height[i], h);
                sum += h - height[i];
                i++;
            } else {
                h = std::max(height[j], h);
                sum += h - height[j];
                j--;
            }
        }
        return sum;
    }
};
