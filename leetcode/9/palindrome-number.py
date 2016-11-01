class Solution:
	# @return a boolean
	def isPalindrome(self, x):
		if x < 0:
			return False
		if x == 0:
			return True
		base = 1
		while base <= x:
			base *= 10
		base /= 10
		while x:
			left = x / base
			right = x % 10
			if left != right:
				return False
			x = x % base / 10
			base /= 100
		return True

x = raw_input()
print Solution().isPalindrome(int(x))