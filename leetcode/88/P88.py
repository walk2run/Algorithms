# 88. Merge Sorted Array
class Solution(object):
	def merge(self, nums1, m, nums2, n):
		i = j = 0
		nums3 = []
		while i < m and j < n:
			if nums1[i] < nums2[j]:
				nums3.append(nums1[i])
				i += 1
			else:
				nums3.append(nums2[j])
				j += 1
		nums3.extend(nums1[i:m])
		nums3.extend(nums2[j:n])
		del nums1[:]
		nums1.extend(nums3)

l = [1]
Solution().merge(l, 1, [], 0)
print l

