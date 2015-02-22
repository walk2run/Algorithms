class Solution:
	# @return an integer
	def romanToInt(self, s):
		m = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
		n = len(s)
		num = 0
		for i in range(n - 1):
			if m[s[i]] < m[s[i + 1]]:
				num -= m[s[i]]
			else:
				num += m[s[i]]
		num += m[s[n - 1]]
		return num