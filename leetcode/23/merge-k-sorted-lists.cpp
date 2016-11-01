#include <queue>
using namespace std;

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

class CmpNode {
public:
	bool operator()(ListNode *a, ListNode *b) {
		return a->val > b->val;
	}
};

class Solution {
public:
	ListNode *mergeKLists(vector<ListNode *> &lists) {
		priority_queue<ListNode *, vector<ListNode *>, CmpNode> heap;
		ListNode *head, *p, *q;
		
		for (auto node : lists)
			if (node) heap.push(node);
		head = heap.empty() ? NULL : heap.top();
		q = new ListNode(0);
		while (!heap.empty()) {
			p = heap.top();
			heap.pop();
			if (p->next)
				heap.push(p->next);
			q->next = p;
			q = p;
		}
		return head;
	}
};