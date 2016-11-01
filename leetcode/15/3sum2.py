class Solution:
	# @return a list of lists of length 3, [[val1,val2,val3]]
	def threeSum(self, num):
		num.sort()
		n = len(num)
		lists = []
		for i in range(n - 2):
			if i > 0 and num[i] == num[i - 1]:
				continue
			j = i + 1
			k = n - 1
			a = num[i]
			while j < k:
				b = num[j]
				c = num[k]
				s = a + b + c
				if s == 0:
					lists.append([a, b, c])
					while j < n and num[j] == b:
						j += 1
				elif s < 0:
					j += 1
				else:
					k -= 1
		return lists

print Solution().threeSum([-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6])