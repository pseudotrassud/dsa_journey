class Solution {
    public int lastStoneWeight(int[] stones) {
        
        // List<Integer> list = new ArrayList<>();

        // for (int stone : stones) {
        //     list.add(stone);
        // }
        
        // while(list.size()>1){

        //     Collections.sort(list);
        //     int len = list.size();

        //     int last = list.get(len-1);
        //     int last2 = list.get(len-2);
        //     list.remove(len-1);
        //     list.remove(len-2);
        //     int diff = last - last2;
        //     if(diff!=0){
        //         list.add(diff);
        //     }
        // }
        // if(list.isEmpty()){
        //     return 0;
        // }
        // return list.get(0);
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int largest = maxHeap.poll();
            int secondLargest = maxHeap.poll();

            int diff = largest - secondLargest;

            if (diff != 0) {
                maxHeap.offer(diff);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}