# 87. Scramble String
# @param {String} s1
# @param {String} s2
# @return {Boolean}
def is_scramble(s1, s2)
	$hash = {}
	$s1, $s2 = s1, s2
	search 0, 0, s1.size
end

def search i1, i2, n
	match = $hash[[i1, i2, n]]
	return match if match != nil
	return $hash[[i1, i2, n]] = $s1[i1] == $s2[i2] if n == 1
	for i in 1...n
		if search(i1, i2, i) && search(i1 + i, i2 + i, n - i) ||
				search(i1, i2 + n - i, i) && search(i1 + i, i2, n - i)
			return $hash[[i1, i2, n]] = true
		end
	end
	$hash[[i1, i2, n]] = false
end

p is_scramble 'great', 'rgtae'

