#include <stdio.h>

class Der {};
class der : Der {};

void f(der b) {printf("a\n");}
void f(Der b) {printf("b\n");}

int main() {
  der d;
  f(d);
}