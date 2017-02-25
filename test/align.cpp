#include <stdio.h>

struct S {
  int b;
  //char c;
};

int main() {
  printf("%d\n", sizeof(S));
  int *a;
  int b[5];
  int c = 1;
  int &d = c;
  return 0;
}
