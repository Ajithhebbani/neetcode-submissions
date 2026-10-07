class MedianFinder {

     private List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }

    public double findMedian() {
        int n = list.size();

        if (n % 2 == 1) {
            return list.get(n / 2);
        }

        return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
    } 
    
}
