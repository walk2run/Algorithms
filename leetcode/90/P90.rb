# 90. Subsets II
# @param {Integer[]} nums
# @return {Integer[][]}
def subsets_with_dup(nums)
	nums.sort!
	$nums = nums
	$lists = []
	$list = []
	$n = nums.size
	search(0)
	return $lists
end

def search i
	if i == $n
		$lists << Array.new($list)
		return
	end
	if i == 0 || $nums[i] == $nums[i - 1] && $use || $nums[i] != $nums[i - 1]
		$list << $nums[i]
		$use = true
		search i + 1
		$list.pop
	end
	$use = false
	search i + 1
end

p subsets_with_dup([1, 2, 2])

