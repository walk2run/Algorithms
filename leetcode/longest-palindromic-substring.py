class Solution:
	# @return a string
	def longestPalindrome(self, s):
		t = buildStr(s)
		print t
		n = len(t)
		p = [0] * n
		c = r = 0;
		for i in range(1, n-1):
			if i <= r:
				ip = c - (i - c)
				if p[ip] <= r - i:
					p[i] = p[ip]
				else:
					p[i] = r - i
			else:
				p[i] = 0
			while t[i - p[i] - 1] == t[i + p[i] + 1]:
				p[i] += 1
			if i + p[i] > r:
				c = i
				r = i + p[i]
		print p
		maxLen = max(p)
		index = p.index(maxLen)
		if index & 1:
			left = index / 2 - maxLen / 2
		else:
			left = index / 2 - 1- maxLen / 2
		return s[left : left + maxLen]

def buildStr(s):
	n = len(s)
	if n == 0:
		return '@$'
	t = '@'
	for ch in s:
		t += '#' + ch
	t += '#$'
	return t
		
print Solution().longestPalindrome('aabba')