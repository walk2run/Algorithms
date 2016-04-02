#include <stdio.h>

bool equal(int a[], int b[]) {
  for (int i = 0; i < 9; i++)
    if (a[i] != b[i] && b[i] != 0)
      return false;
  return true;
}

int main() {
  int i, d[9], *ansOut = NULL;
  int anss[][9] = {
    {4, 9, 2, 3, 5, 7, 8, 1, 6},
    {8, 3, 4, 1, 5, 9, 6, 7, 2},
    {6, 1, 8, 7, 5, 3, 2, 9, 4},
    {2, 7, 6, 9, 5, 1, 4, 3, 8},
    {2, 9, 4, 7, 5, 3, 6, 1, 8},
    {6, 7, 2, 1, 5, 9, 8, 3, 4},
    {8, 1, 6, 3, 5, 7, 4, 9, 2},
    {4, 3, 8, 9, 5, 1, 2, 7, 6}};
  for (i = 0; i < 9; i++)
    scanf("%d", d + i);
  for (i = 0; i < 8; i++) {
    if (equal(anss[i], d)) {
      if (ansOut == NULL) {
        ansOut = (int *)(anss + i);
      } else {
        ansOut = NULL;
        break;
      }
    }
  }
  if (ansOut == NULL)
    printf("Too Many\n");
  else
    printf("%d %d %d\n%d %d %d\n%d %d %d\n", 
        ansOut[0], ansOut[1], ansOut[2],
        ansOut[3], ansOut[4], ansOut[5],
        ansOut[6], ansOut[7], ansOut[8]);
  return 0;
}

