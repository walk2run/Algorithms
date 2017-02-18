#include <iostream>
#include <vector>
#include <unordered_map>

class Foo {
public:
  static int a;
  bool b = 0;
  const int c = 1;
  Foo(int c): c(c) {}
  static void print() {
    std::cout << "print\n";
  }
};

int Foo::a = 5;

bool operator==(const Foo& f1, const Foo& f2) {
  std::cout << "==\n";
  return f1.a == f2.a && f1.b == f2.b;
}

std::ostream& operator<<(std::ostream& os, const Foo& foo) {
  return os << foo.a << foo.b << foo.c;
}

struct hash {
  std::size_t operator()(const Foo& foo) const {
    std::cout << "hash\n";
    return foo.a * 10 + foo.b;
  }
};

int main() {
  /*Foo f1{1, true}, f2{5, false};
  std::cout << f1 << f2 << std::endl;
  std::cout << (f1 == f2) << std::endl;
  std::cout << (f1 == Foo{1, true}) << std::endl;
  std::cout << hash{}(f1) << std::endl;
  
  std::unordered_map<Foo, int, hash> map;
  map.insert({f1, 5});
  map.insert({f1, 4});
  map.insert({f2, 3});
  
  std::vector<int> vec={5, 9};
  std::cout << vec[3] << std::endl;
  std::cout << std::vector<int>{1, 2, 3, 4, 5}[3] << std::endl;
  std::cout << (new int[5]{1, 2, 3})[1] << std::endl;*/
  
  Foo foo(3);
  std::cout << foo << std::endl;
  std::cout << Foo::a << std::endl;
  foo.print();
  Foo::print();
  
}