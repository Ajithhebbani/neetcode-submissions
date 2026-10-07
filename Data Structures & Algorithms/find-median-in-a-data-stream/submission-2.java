class MedianFinder {

    private Queue<Integer> sh;
    private Queue<Integer> lh;

    public MedianFinder() {
        sh = new PriorityQueue<>((a, b) -> b - a);
        lh = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        sh.add(num);
        if( sh.size() - lh.size() > 1 || !lh.isEmpty() && sh.peek() > lh.peek()){
            lh.add(sh.poll());
        }
        if(lh.size() - sh.size() > 1){
            sh.add(lh.poll());
        }
    }

    public double findMedian() {
        if (sh.size() == lh.size()) {
            return (double) (lh.peek() + sh.peek()) / 2;
        } else if (sh.size() > lh.size()) {
            return (double) sh.peek();
        } else {
            return (double) lh.peek();
        }
    } 
    
}
