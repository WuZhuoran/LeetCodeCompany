class MedianFinder {

    private int count = 0;

    private PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();

    private PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        this.count ++;

        if (count % 2 == 0) {
            // count is even
            if(!maxPQ.isEmpty() && num < maxPQ.peek()) {
                maxPQ.offer(num);
                num = maxPQ.poll();
            }
            minPQ.offer(num);
        } else {
            // count is odd
            if (!minPQ.isEmpty() && num > minPQ.peek()) {
                minPQ.offer(num);
                num = minPQ.poll();
            }
            maxPQ.offer(num);
        }
    }

    public double findMedian() {
        if (count % 2 == 0) {
            return (minPQ.peek() + maxPQ.peek()) / 2.0;
        } else {
            return maxPQ.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
