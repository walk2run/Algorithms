/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *swapPairs(ListNode *head) {
        ListNode *p1, *p2, *p3, *prev, *newHead;
		p1 = head;
		if (p1 != NULL) newHead = p1->next == NULL ? p1 : p1->next;
		prev = NULL;
		while (p1 != NULL) {
			if (p1->next != NULL) {
				p2 = p1->next;
				p3 = p2->next;
				
				p1->next = p3;
				p2->next = p1;
				
				if (prev != NULL) prev->next = p2;
				prev = p1;
				
				p1 = p3;
			} else {
				p1 = NULL;
			}
		}
		return newHead;
    }
};
