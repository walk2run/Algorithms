#include <stdio.h>
#include <string.h>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n, c[8], d, count, remain, count3, remain3, i;
	vector<int> list;
	scanf("%d", &n);
	if (n == 1) {
		printf("1\n");
		return 0;
	} else if (n == 0) {
		printf("10\n");
		return 0;
	}
	memset(c, 0, sizeof(c));
	d = 2;
	while (n > 1) {
		if (n % d == 0) {
			n /= d;
			c[d]++;
		} else {
			d++;
			if (d > 7) {
				printf("-1\n");
				return 0;
			}
		}
	}
	count = c[2] / 3;
	remain = c[2] % 3;
	count3 = c[3] / 2;
	remain3 = c[3] % 2;
	for (i = 0; i < count; i++)
		list.push_back(8);
	for (i = 0; i < count3; i++)
		list.push_back(9);
	if (remain == 0) {
		if (remain3) list.push_back(3);
	} else if (remain == 1) {
		if (remain3)
			list.push_back(6);
		else
			list.push_back(2);
	} else {
		if (remain3) {
			list.push_back(2);
			list.push_back(6);
		} else {
			list.push_back(4);
		}
	}
	for (i = 0; i < c[5]; i++)
		list.push_back(5);
	for (i = 0; i < c[7]; i++)
		list.push_back(7);
	sort(list.begin(), list.end());
	for (int v : list)
		printf("%d", v);
	printf("\n");
	return 0;
}

/*1014. Product of Digits
Time limit: 1.0 second
Memory limit: 64 MB
Your task is to find the minimal positive integer number Q so that the product of digits of Q is exactly equal to N.
Input
The input contains the single integer number N (0 ≤ N ≤ 109).
Output
Your program should print to the output the only number Q. If such a number does not exist print −1.
Sample
input	output

10

	

25

Problem Source: Ural State University Internal Contest '99 #2
Tags: problem for beginners  (
hide tags for unsolved problems
)*/

