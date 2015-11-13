#include <stdio.h>
#include <math.h>
#include <vector>
using namespace std;
typedef unsigned long long ull;

int main() {
	ull n;
	vector<ull> list;
	while (scanf("%lld", &n) > 0)
		list.push_back(n);
	for (vector<ull>::reverse_iterator it = list.rbegin(); it != list.rend(); it++)
		printf("%f\n", sqrt(*it));
	return 0;
}