#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

#define BASE 10000

// >= 0
class BigInt
{
public:
	BigInt(int n);
	void mul(const BigInt &b);	// *= b
	void sub(const BigInt &b);	// -= b
	bool less(const BigInt &b);
	void print();
private:
	vector<int> *nums;
};

BigInt::BigInt(int n)
{
	nums = new vector<int>;
	nums->push_back(n);
}

void BigInt::mul(const BigInt &b)
{
	int i, j, k;
	vector<int> *product;
	
	product = new vector<int>(nums->size() + b.nums->size(), 0);
	for (i = 0; i < nums->size(); i++)
		for (j = 0; j < b.nums->size(); j++)
		{
			k = i + j;
			product->at(k) += nums->at(i) * b.nums->at(j);
			product->at(k+1) += product->at(k) / BASE;
			product->at(k) %= BASE;
		}
	if (product->back() == 0) product->pop_back();
	delete nums;
	nums = product;
}

void BigInt::sub(const BigInt &b)
{
	int i;
	for (i = 0; i < nums->size(); i++)
	{
		if (i < b.nums->size())
			if (nums->at(i) < b.nums->at(i))
			{
				nums->at(i+1)--;
				nums->at(i) += BASE - b.nums->at(i);
			}
			else
			{
				nums->at(i) -= b.nums->at(i);
			}
		else
			if (nums->at(i) < 0)
			{
				nums->at(i+1)--;
				nums->at(i) += BASE;
			}
	}
	while (nums->back() == 0 && nums->size() > 1) nums->pop_back();
}

bool BigInt::less(const BigInt &b)
{
	if (nums->size() < b.nums->size())
		return true;
	else if (nums->size() > b.nums->size())
		return false;
	else
	{
		for (int i = nums->size() - 1; i >= 0; i--)
			if (nums->at(i) < b.nums->at(i))
				return true;
			else if (nums->at(i) < b.nums->at(i))
				return false;
		return false;
	}
}

void BigInt::print()
{
	int x;
	cout << nums->back();
	for (int i = nums->size() - 2; i >= 0; i--)
	{
		x =  nums->at(i);
		if (x < 1000) cout << 0;
		if (x < 100) cout << 0;
		if (x < 10) cout << 0;
		cout << x;
	}
	cout << endl;
}

int main()
{
	int a0, b0, i;
	
	cin >> a0 >> b0;
	
	BigInt a(a0);
	BigInt b(b0);
	BigInt pow1(1);
	BigInt pow2(1);
	
	for (i = 0; i < b0; i++)
		pow1.mul(a);
	for (i = 0; i < a0; i++)
		pow2.mul(b);
	
	//pow1.print();
	//pow2.print();
	
	if (pow1.less(pow2))
	{
		pow2.sub(pow1);
		cout << '-';
		pow2.print();
	}
	else
	{
		pow1.sub(pow2);
		pow1.print();
	}
	
	return 0;
}