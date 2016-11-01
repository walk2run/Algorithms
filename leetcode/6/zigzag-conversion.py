class Solution:
	# @return a string
	def convert(self, s, nRows):
		n = len(s)
		str = ''
		step = (nRows - 1) * 2
		if not step:
			step = 1
		for i in range(nRows):
			j = i
			if i == 0 or i == nRows - 1:
				while j < n:
					str += s[j]
					j += step
			else:
				while j < n:
					str += s[j]
					j += step - i * 2
					if j < n:
						str += s[j]
					else:
						break
					j += i * 2
		return str

print Solution().convert('0123456789a', 2)