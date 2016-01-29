require 'net/http'
require 'thread'

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

#main

$mutex = Mutex.new
$mutex2 = Mutex.new
$resource = ConditionVariable.new
$id = 1000
$threadCount = 0
$url = 'http://acm.timus.ru/problem.aspx?num='

def get
	id = 0
	$mutex.synchronize do
		id = $id
		puts id
		$id += 1
	end
	is = id.to_s
	filename = is + '.html'
	if !File.exist? filename
		#puts 'Getting ' + is
		content = Net::HTTP.get(URI($url + is))
		file = File.new(filename, 'w')
		file.puts content
		file.close
	end
	$mutex2.synchronize do
		$threadCount -= 1
		if $threadCount < 200
			$resource.signal
		end
	end
end

def pullMulti
	Dir.mkdir 'p'
	Dir.chdir 'p'
	threads = []
	for i in 1000..2073
		$mutex2.synchronize do
			$threadCount += 1
			if $threadCount > 200
				$resource.wait $mutex2
			end
		end
		threads << Thread.new { get }
	end
	threads.each { |t| t.join }
end

pullMulti

