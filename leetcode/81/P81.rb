# Search in Rotated Sorted Array II

# @param {Integer[]} nums
# @param {Integer} target
# @return {Boolean}
def search(nums, target)
	l = 0
	r = nums.length - 1
	while l < r
		mid = (l + r) / 2
		v0 = nums[l]
		if v0 == target
			return true
		end
		v1 = nums[mid]
		v2 = nums[r]
		if v0 < v1
			if v0 <= target && target <= v1
				r = mid
			else
				l = mid + 1
			end
		elsif v0 > v1
			if v1 <= target && target <= v2
				l = mid
			else
				r = mid - 1
			end
		else
			l += 1
		end
	end
	nums[l] == target
end

