import urllib2

f = open('file', 'w')
data = urllib2.urlopen('http://acm.timus.ru/problem.aspx?num=1004').read()
f.write(data)
f.close()

