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
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        ListNode *head, *p;
        head = p = new ListNode(0);
        while (l1 || l2) {
            if (l1 && l2)
                if (l1->val < l2->val)
                    insert(p, l1);
                else
                    insert(p, l2);
            else if (l1)
                insert(p, l1);
            else if (l2)
                insert(p, l2);
        }
        return head->next;
    }
    
    void insert(ListNode *&p, ListNode *&l) {
        p->next = l;
        l = l->next;
        p = p->next;
        p->next = NULL;
    }
};