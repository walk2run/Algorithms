class Solution:
	# @return a list of lists of length 4, [[val1,val2,val3,val4]]
	def fourSum(self, num, target):
		n = len(num)
		d = {}
		lists = []
		sett = set()
		for i in range(n - 1):
			for j in range(i + 1, n):
				s = num[i] + num[j]
				if s in d:
					d[s].append((i, j))
				else:
					d[s] = [(i, j)]
		for a in d:
			b = target - a
			bPairs = d.get(b)
			if bPairs:
				aPairs = d[a]
				for p1 in aPairs:
					for p2 in bPairs:
						if not (p1[0] in p2 or p1[1] in p2):
							lt = [num[p1[0]], num[p1[1]], num[p2[0]], num[p2[1]]]
							lt.sort()
							tp = tuple(lt)
							if not tp in sett:
								sett.add(tp)
								lists.append(lt)
		return lists

print Solution().fourSum([-1, -1, 0, 0, 1], 0)