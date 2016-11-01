/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *removeNthFromEnd(struct ListNode *head, int n) {
    struct ListNode *p0, *p1;
    int i;
    p0 = (struct ListNode *)malloc(sizeof(struct ListNode));
    p0->next = head;
    p1 = head;
    for (i = 0; i < n; i++)
        p1 = p1->next;
    while (p1) {
        p0 = p0->next;
        p1 = p1->next;
    }
    if (p0->next == head) {
        return head->next;
    }
    p0->next = p0->next->next;
    return head;
    // should free node
}