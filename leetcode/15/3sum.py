import bisect

class Solution:
	# @return a list of lists of length 3, [[val1,val2,val3]]
	def threeSum(self, num):
		num.sort()
		n = len(num)
		lists = []
		s = set()
		for i in range(n - 2):
			for j in range(i + 1, n - 1):
				if (num[i], num[j]) in s:
					continue
				s.add((num[i], num[j]))
				exp = - num[i] - num[j]
				if exp < num[j]:
					break
				pos = bisect.bisect_left(num, exp, j + 1, n)
				if pos < n and num[pos] == exp:
					lists.append([num[i], num[j], exp])
		return lists

print Solution().threeSum([-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6])