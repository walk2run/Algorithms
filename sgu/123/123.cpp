#include <iostream>
using namespace std;

int main()
{
	int k, s, f, fprev, i, tem;
	
	cin >> k;
	if (k == 1)
		cout << 1 << endl;
	else
	{
		f = 1;
		fprev = 0;
		s = 1;
		i = 1;
		while (i < k)
		{
			tem = f;
			f += fprev;
			fprev = tem;
			s += f;
			i++;
		}
		cout << s << endl;
	}
	
	return 0;
}