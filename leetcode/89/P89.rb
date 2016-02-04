# @param {Integer} n
# @return {Integer[]}
def gray_code(n)
	$list = []
	$x = 0
	search n - 1
	$list
end

def search i
	if i == -1
		$list << $x
		return
	end
	search i - 1
	$x = $x ^ (1 << i)
	search i - 1
end

p gray_code 4

