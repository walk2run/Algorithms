# Largest Rectangle in Histogram

# @param {Integer[]} height
# @return {Integer}
def largest_rectangle_area(height)
	stack = []
	max = 0
	height.push 0
	height.each do |value|
		if stack.empty? || value >= stack.last
			stack.push value
		else
			count = 0
			while !stack.empty? && stack.last > value
				s = stack.pop * count += 1
				max = s if s > max
			end
			(0..count).each do
				stack.push value
			end
		end
	end
	max
end

# Better
def largest_rectangle_area2(height)
	stack = []
	max = i = 0
	height << 0
	while i < height.size
		if stack.empty? || height[i] >= height[stack.last]
			stack << i
			i += 1
		else
			p = stack.pop
			s = height[p] * (stack.empty? ? i : i - stack.last - 1)
			max = s if s > max
		end
	end
	max
end

p largest_rectangle_area2 [2,1,5,6,2,3]

