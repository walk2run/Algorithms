# Remove Duplicates from Sorted Array II

# @param {Integer[]} nums
# @return {Integer}
def remove_duplicates(nums)
	count = sum = 0
	current = nil
	newNums = []
	nums.each do |value|
		if value == current
			if count < 2
				newNums << current
				count += 1
			end
		else
			sum += count
			current = value
			newNums << current
			count = 1
		end
	end
	nums.replace newNums
	sum + count
end

p remove_duplicates([1,1,1,2,2,5])

