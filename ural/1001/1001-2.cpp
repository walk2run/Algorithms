#include <iostream>
#include <iomanip>
#include <math.h>
#include <vector>
using namespace std;
typedef unsigned long long ull;

int main() {
	ull n;
	vector<ull> list;
	while (cin >> n)
		list.push_back(n);
	cout << fixed << setprecision(4);
	for (vector<ull>::reverse_iterator it = list.rbegin(); it != list.rend(); it++)
		cout << sqrt(*it) << '\n';
	return 0;
}
