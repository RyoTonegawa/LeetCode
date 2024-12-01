import java.util.HashMap;

class LRUCache {
  class Node{
    int key, value;
    Node prev,next;

    Node(int key, int value){
      this.key = key;
      this.value = value;
    }
  };
  private int capacity;
  private HashMap<Integer,Node> cache;
  private Node head, tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();

    /**
     * Create dummy head and tail nodes
     * for the doubly linked list
     */
    this.head = new Node(0,0);
    this.tail = new Node(0,0);
    head.next = tail;
    tail.prev = head;
  }
  
  public int get(int key) {
      if(cache.containsKey(key)){
        Node node = cache.get(key);
        /**
         * Move the node to the front
         * 'cause that node becomes
         * most recently used node
         */
        remove(node);
        insertToFront(node);
        return node.value;
      }
      /*
       * Key not found
       */
      return -1;
  };
  
  
  public void put(int key, int value) {
      if(cache.containsKey(key)){
        /*
         * If key exists, update ites
         * value and move it to the front
         */
        Node node = cache.get(key);
        node.value = value;
        remove(node);
        insertToFront(node);
      }  else {
        /*
         * If key does not exist,
         * create a new node
         */
        if(cache.size()== capacity){
          Node lru = tail.prev;
          remove(lru);
          cache.remove(lru.key);
        }
        Node newNode = new Node(key,value);
        cache.put(key,newNode);
        insertToFront(newNode);
      };
  }

  /**
   * Helper functions
   */
  private void remove(Node node){
    /**
     * Question:Which node we're evicting?
     * Evict node from current ?node
     */
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }
  private void insertToFront(Node node){
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
    node.prev = head;
  }
}

/**
* Your LRUCache object will be instantiated and called as such:
* LRUCache obj = new LRUCache(capacity);
* int param_1 = obj.get(key);
* obj.put(key,value);
*/