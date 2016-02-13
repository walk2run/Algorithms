# 93. Restore IP Addresses
# @param {String} s
# @return {String[]}
def restore_ip_addresses(s)
	$s = s
	$lists = []
	$list = []
	search 0
	return $lists
end

def search i
	if $list.size == 4
		if i == $s.size
			$lists << $list.join('.')
		end
	else
		for len in 1..3
			if i + len > $s.size
				break
			end
			num = $s[i...i + len].to_i
			if len > 1 && $s[i] == '0' || num > 255
				next
			end
			$list << num
			search i + len
			$list.pop
		end
	end
end

p restore_ip_addresses '25525511135'

