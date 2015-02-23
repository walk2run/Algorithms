import sys

class Solution:
	# @return an integer
	def threeSumClosest(self, num, target):
		num.sort()
		n = len(num)
		minDiff = sys.maxint
		for i in range(n - 2):
			if i > 0 and num[i] == num[i - 1]:
				continue
			a = num[i]
			j = i + 1
			k = n - 1
			while j < k:
				print i, j, k
				b = num[j]
				c = num[k]
				s = a + b + c
				if abs(s - target) < abs(minDiff):
					minDiff = s - target
				if s == target:
					return s
				elif s < target:
					while j < n and num[j] == b:
						j += 1
				else:
					while k >= 0 and num[k] == c:
						k -= 1
		return target + minDiff

print Solution().threeSumClosest([1, 1, 1, 0], 100)