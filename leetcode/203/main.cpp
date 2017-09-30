// 203. Remove Linked List Elements
#include <iostream>

class Solution {
public:
  ListNode *removeElements(ListNode *head, int val) {
    ListNode *p = head, *q = NULL;
    while (p) {
      if (p->val == val) {
        if (q) q->next = p->next; else head = p->next;
      } else {
        q = p;
      }
      p = p->next;
    }
    return head;
  }
};

int main() {
  std::cout << "Hello, World!" << std::endl;
  return 0;
}
