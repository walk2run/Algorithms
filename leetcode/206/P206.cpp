// 206. Reverse Linked List 
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
    ListNode* reverseList(ListNode* head) {
        ListNode *p = head, *q = NULL, *np;
        while (p) {
            np = p->next;
            p->next = q;
            q = p;
            p = np;
        }
        return q;
    }
};

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        return reverse(head, NULL);
    }
    
    ListNode *reverse(ListNode *p, ListNode *q) {
        if (p) {
            ListNode *np = p->next;
            p->next = q;
            return reverse(np, p);
        } else {
            return q;
        }
    }
};
