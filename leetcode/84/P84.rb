# Largest Rectangle in Histogram

# @param {Integer[]} height
# @return {Integer}
def largest_rectangle_area(height)
	stack = []
	max = 0
	height.push 0
	height.each_index do |i|
		if stack.empty? || height[i] >= stack.last
			stack.push height[i]
		else
			count = 0
			while !stack.empty? && stack.last > height[i]
				h = stack.pop
				count += 1
				s = h * count
				max = s if s > max
			end
			(0..count).each do
				stack.push height[i]
			end
		end
	end
	max
end

p largest_rectangle_area [2, 1, 2]

