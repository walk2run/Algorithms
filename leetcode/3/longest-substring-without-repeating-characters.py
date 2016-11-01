class Solution:
    # @return an integer
    def lengthOfLongestSubstring(self, s):
        appear = {}
        maxLen = curLen = i = 0
        for j in range(len(s)):
            if s[j] in appear:
                if appear[s[j]] >= i:
                    i = appear[s[j]] + 1
                appear[s[j]] = j
                curLen = j - i + 1
                if curLen > maxLen:
                    maxLen = curLen
            else:
                appear[s[j]] = j
                curLen += 1
                if curLen > maxLen:
                    maxLen = curLen
        return maxLen
