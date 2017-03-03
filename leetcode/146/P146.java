public class LRUCache {
  private Map<Integer, Node> map;
  private Node head, tail;
  private int capacity;
  
  public LRUCache(int capacity) {
    map = new HashMap<>();
    this.capacity = capacity;
  }
  
  public int get(int key) {
    Node node = map.get(key);
    if (node == null)
      return -1;
    delNode(node);
    addHead(node);
    return node.value;
  }
  
  public void put(int key, int value) {
    Node node = map.get(key);
    if (node == null) {
      if (map.size() == capacity) {
        map.remove(tail.key);
        if (tail.prev != null)
          tail.prev.next = null;
        tail = tail.prev;
      }
      node = new Node(key, value);
      map.put(key, node);
    } else {
      node.value = value;
      delNode(node);
    }
    addHead(node);
  }
  
  private void delNode(Node node) {
    if (node.next != null)
      node.next.prev = node.prev;
    else
      tail = node.prev;
    if (node.prev != null)
      node.prev.next = node.next;
    else
      head = node.next;
  }
  
  private void addHead(Node node) {
    node.prev = null;
    if (head == null) {
      head = tail = node;
      node.next = null;
    } else {
      node.next = head;
      head = node;
    }
  }
  
  private static class Node {
    int key, value;
    Node next, prev;
    Node(int k, int v) {
      key = k;
      value = v;
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */