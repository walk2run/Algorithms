class Solution:
	# @return an integer
	def reverse(self, x):
		sig = -1 if x < 0 else 1
		x = abs(x)
		y = 0
		while x:
			y = y * 10 + x % 10
			x = x / 10
		y = sig * y
		if y < - 2 ** 31 or y > 2 ** 31 - 1:
			y = 0
		return y

print Solution().reverse(1000000003)