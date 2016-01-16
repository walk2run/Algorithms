require 'net/http'

def main
	url = 'http://acm.timus.ru/problem.aspx?num='
	for i in 1000..2073
		is = i.to_s
		if !File.exist? is
			puts 'Getting ' + is
			content = Net::HTTP.get(URI(url + is))
			file = File.new(is, 'w')
			file.puts content
			file.close
		end
	end
end

main

