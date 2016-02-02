# 88. Merge Sorted Array
# @param {Integer[]} nums1
# @param {Integer} m
# @param {Integer[]} nums2
# @param {Integer} n
# @return {Void} Do not return anything, modify nums1 in-place instead.
def merge(nums1, m, nums2, n)
	i = j = 0
	nums3 = []
	while i < m && j < n
		if nums1[i] < nums2[j]
			nums3 << nums1[i]
			i += 1
		else
			nums3 << nums2[j]
			j += 1
		end
	end
	nums3.concat(nums1[i ... m])
	nums3.concat(nums2[j ... n])
	nums1.replace(nums3)
end

l = [1]
merge(l, 1, [], 0)
p l

