/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *reverseKGroup(struct ListNode *head, int k) {
	struct ListNode *p0, *start, *end, *p, *q, *r, *startNext, *endNext;
	int i;
	p0 = (struct ListNode *)malloc(sizeof(struct ListNode));
	p0->next = head;
	start = p0;
	while (1) {
		p = start;
		for (i = 0; i < k; i++) {
			p = p->next;
			if (!p) return p0->next;
		}
		end = p;
		startNext = q = start->next;
		p = q->next;
		start->next = end;
		endNext = end->next;
		for (i = 0; i < i - 1; i++) {
			r = p->next;
			p->next = q;
			q = p;
			p = r;
		}
		startNext->next = end->next;
	}
}