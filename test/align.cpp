#include <stdio.h>

struct S {
  int &b;
};

int main() {
  printf("%d\n", sizeof(S));
  int *a;
  int b[5];
  int c = 1;
  int &d = c;
  printf("%d\n", sizeof(a));
  printf("%d\n", sizeof(&d));
  return 0;
}
