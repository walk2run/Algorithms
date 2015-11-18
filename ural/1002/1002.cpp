#include <stdio.h>
#include <string.h>
#include <string>
#include <algorithm>
#include <unordered_map>
using namespace std;

#define INF 99999

const char c2d[26] = {'2', '2', '2', '3', '3', '3', '4', '4', '1', '1', '5',
	'5', '6', '6', '0', '7', '0', '7', '7', '8', '8', '8', '9', '9', '9', '0'};

void solve() {
	int n, i, j, numLen, wordLen, count, maxWordLen;
	int f[100], prev[100], list[100];
	char number[101], words[50000][51], digits[51], *p, buf[51];
	unordered_map<string, int> mapp;
	unordered_map<string, int>::iterator it; 
	
	gets(number);
	scanf("%d ", &n);
	maxWordLen = 0;
	for (i = 0; i < n; i++) {
		gets(words[i]);
		wordLen = strlen(words[i]);
		if (wordLen > maxWordLen)
			maxWordLen = wordLen;
		strcpy(digits, words[i]);
		for (p = digits; *p; p++)
			*p = c2d[(*p) - 'a'];
		mapp.insert(make_pair(digits, i));
	}

	for (i = 0; i < 100; i++) f[i] = INF;
	numLen = strlen(number);
	for (i = 0; i < numLen; i++) {
		for (j = max(i - maxWordLen + 1, 0); j <= i; j++) {
			memmove(buf, number + j, i - j + 1);
			buf[i - j + 1] = 0;
			it = mapp.find(buf);
			if (it != mapp.end()) {
				if (j == 0) {
					f[i] = 1;
					prev[i] = it->second;
				} else if (f[j - 1] + 1 < f[i]) {
					f[i] = f[j - 1] + 1;
					prev[i] = it->second;
				}
			}
		}
	}

	if (f[numLen - 1] == INF)
		printf("No solution.\n");
	else {
		i = numLen - 1;
		count = 0;
		while (i >= 0) {
			list[count++] = prev[i];
			i -= strlen(words[prev[i]]);
		}
		for (i = count - 1; i > 0; i--)
			printf("%s ", words[list[i]]);
		printf("%s\n", words[list[0]]);
	}
}

int main() {
	char c;
	while ((c = getchar()) != '-') {
		ungetc(c, stdin);
		solve();
	}
	return 0;
}

/*
1002. Phone Numbers
Time limit: 2.0 second
Memory limit: 64 MB
In the present world you frequently meet a lot of call numbers and they are going to be longer and longer. You need to remember such a kind of numbers. One method to do it in an easy way is to assign letters to digits as shown in the following picture:

1 ij    2 abc   3 def
4 gh    5 kl    6 mn
7 prs   8 tuv   9 wxy
        0 oqz

This way every word or a group of words can be assigned a unique number, so you can remember words instead of call numbers. It is evident that it has its own charm if it is possible to find some simple relationship between the word and the person itself. So you can learn that the call number 941837296 of a chess playing friend of yours can be read as WHITEPAWN, and the call number 2855304 of your favourite teacher is read BULLDOG.
Write a program to find the shortest sequence of words (i.e. one having the smallest possible number of words) which corresponds to a given number and a given list of words. The correspondence is described by the picture above.
Input
Input contains a series of tests. The first line of each test contains the call number, the transcription of which you have to find. The number consists of at most 100 digits. The second line contains the total number of the words in the dictionary (maximum is 50 000). Each of the remaining lines contains one word, which consists of maximally 50 small letters of the English alphabet. The total size of the input doesn't exceed 300 KB. The last line contains call number −1.
Output
Each line of output contains the shortest sequence of words which has been found by your program. The words are separated by single spaces. If there is no solution to the input data, the line contains text “No solution.”. If there are more solutions having the minimum number of words, you can choose any single one of them.
Sample
input	output

7325189087
5
it
your
reality
real
our
4294967296
5
it
your
reality
real
our
-1

	

reality our
No solution.

Problem Source: Central European Olympiad in Informatics 1999
*/

