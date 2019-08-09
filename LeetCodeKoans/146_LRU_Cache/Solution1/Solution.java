class LRUCache {

    public class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    public int count;
    
    public int cap;
    
    public Node head;
    
    public Node tail;
    
    public Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        count = 0;
        cap = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // if found, return val and set the node as head
        Node node = map.get(key);
        remove(node);
        moveToHead(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        
        if (node != null) {
            // Key exist
            node.val = value;
            remove(node);
            moveToHead(node);
        } else {
            // Key not exist
            node = new Node(key, value);
            if (map.size() == this.cap) {
                popTail();
            }
            moveToHead(node);
            map.put(key, node);
        }
    }
    /*
    Head -> node 1 -> node 2 -> ... -> Node n -> Tail
    */
    public void moveToHead(Node node) {
        node.prev = this.head;
        node.next = this.head.next;
        this.head.next.prev = node;
        this.head.next = node;
    }
    
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void popTail() {
        Node last = this.tail.prev;
        remove(last);
        map.remove(last.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */