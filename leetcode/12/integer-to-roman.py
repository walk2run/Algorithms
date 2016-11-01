class Solution:
	# @return a string
	def intToRoman(self, num):
		m = num / 1000
		st = 'M' * m
		num %= 1000
		if num >= 900:
			st += 'CM'
			num -= 900
		elif num >= 500:
			st += 'D'
			num -= 500
		elif num >= 400:
			st += 'CD'
			num -= 400
		
		c = num / 100
		st += 'C' * c
		num %= 100
		if num >= 90:
			st += 'XC'
			num -= 90
		elif num >= 50:
			st += 'L'
			num -= 50
		elif num >= 40:
			st += 'XL'
			num -= 40
		
		x = num / 10
		st += 'X' * x
		num %= 10
		st += ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII', 'VIII', 'IX'][num]
		
		return st