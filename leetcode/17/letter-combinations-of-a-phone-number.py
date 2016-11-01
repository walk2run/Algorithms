f = ['', '', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']

class Solution:
	# @return a list of strings, [s1, s2]
	def letterCombinations(self, digits):
		if digits == '':
			return []
		self.strs = []
		self.search(digits, 0, '')
		return self.strs

	def search(self, digits, i, st):
		if i == len(digits):
			self.strs.append(st)
			return
		for ch in f[ord(digits[i]) - ord('0')]:
			self.search(digits, i + 1, st + ch)

print Solution().letterCombinations('23')