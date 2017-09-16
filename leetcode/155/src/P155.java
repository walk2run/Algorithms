// 155. Min Stack

import java.util.LinkedList;
import java.util.PriorityQueue;

class MinStack {

  PriorityQueue<Integer> heap;
  LinkedList<Integer> list;

  /** initialize your data structure here. */
  public MinStack() {
    heap = new PriorityQueue<>();
    list = new LinkedList<>();
  }

  public void push(int x) {
    heap.add(x);
    list.add(x);
  }

  public void pop() {
    int x = list.removeLast();
    heap.remove(x);
  }

  public int top() {
    return list.getLast();
  }

  public int getMin() {
    return heap.peek();
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class P155 {
}
