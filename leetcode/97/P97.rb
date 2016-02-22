# 97. Interleaving String
# @param {String} s1
# @param {String} s2
# @param {String} s3
# @return {Boolean}
def is_interleave(s1, s2, s3)
	n = s1.size
	m = s2.size
	if n + m != s3.size
		return false
	end
	d = Array.new(n + 1) { Array.new m + 1, false }
	d[0][0] = true
	for i in 1..n
		break if !(d[i][0] = s1[i - 1] == s3[i - 1])
	end
	for j in 1..m
		break if !(d[0][j] = s2[j - 1] == s3[j - 1])
	end
	for i in 1..n
		for j in 1..m
			d[i][j] = d[i - 1][j] && s1[i - 1] == s3[i + j - 1] \
					|| d[i][j - 1] && s2[j - 1] == s3[i + j - 1]
		end
	end
	return d[n][m]
end

p is_interleave 'db', 'b', 'cbb'

