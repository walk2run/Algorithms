class Solution:
	# @return a string
	def longestCommonPrefix(self, strs):
		if strs == []:
			return ''
		j = 0
		prefix = ''
		while True:
			if j < len(strs[0]):
				ch = strs[0][j]
			for st in strs:
				if j == len(st):
					return prefix
				if st[j] != ch:
					return prefix
			prefix += ch
			j += 1