# 91. Decode Ways
# @param {String} s
# @return {Integer}
def num_decodings(s)
	n = s.size
	return 0 if n == 0
	d = Array.new n + 1, 0
	d[-1] = 1
	for i in 0...n
		if s[i] != '0'
			d[i] = d[i - 1]
		end
		num = s[i - 1..i].to_i
		if num >= 10 && num <= 26
			d[i] += d[i - 2]
		end

	end
	return d[n - 1]
end

p num_decodings '12'

