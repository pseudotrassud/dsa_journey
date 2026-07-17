class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(max.size()==0){
            max.offer(num);
            return;
        }
        

        if(max.size()==min.size()){
            if(num>min.peek()) {
                max.offer(min.poll());
                min.offer(num);
            }
            else{
                max.offer(num);
            } 

        }
        else{
            if(num<max.peek()){
                min.offer(max.poll());
                max.offer(num);
            }
            else{
                min.offer(num);
            }
        }
    }
    
    public double findMedian() {
        if(max.size()== min.size()) return (max.peek()+min.peek())/2.0;
        else return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */