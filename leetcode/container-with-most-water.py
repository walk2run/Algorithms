class Solution:
    # @return an integer
    def maxArea(self, height):
        i = 0
		j = len(height) - 1
		maxArea = 0
		while i <= j:
			area = min(height[i], height[j]) * (j - i)
			maxArea = max(area, maxArea)
			if height[i] < height[j]:
				i += 1
			else:
				j -= 1
		return maxArea

