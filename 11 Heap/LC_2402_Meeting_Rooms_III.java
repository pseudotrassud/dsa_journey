class RoomDetails{
    long endTime;
    int idx;
    public RoomDetails(long endTime, int idx){
        this.endTime = endTime;
        this.idx = idx;
    }
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int[] count = new int[n];
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>(n);
        PriorityQueue<RoomDetails> occupiedRooms = new PriorityQueue<>(n,
        (a,b) -> {
            if(a.endTime==b.endTime) return Integer.compare(a.idx,b.idx);
            else return Long.compare(a.endTime,b.endTime);
        });

        //during start all rooms are available
        for(int i =0 ; i<n ; i++){
            availableRooms.offer(i);
        }

        for(int i =0;i<meetings.length;i++){
            long start = meetings[i][0];
            long end = meetings[i][1];

            while(!occupiedRooms.isEmpty() && start>=occupiedRooms.peek().endTime){
                availableRooms.offer(occupiedRooms.poll().idx);
            }

            if(!availableRooms.isEmpty()){
                int room = availableRooms.poll();
                occupiedRooms.offer(new RoomDetails(end,room));
                count[room]++;
                
                
            }
            else{
                RoomDetails earliest_avlb_room = occupiedRooms.poll();
                earliest_avlb_room.endTime+=end-start;
                occupiedRooms.offer(earliest_avlb_room);
                count[earliest_avlb_room.idx]++;
            }
            
        }
        int max =0;
        for(int i =0; i<n;i++){
            if(count[i]>count[max]){
                max=i;
            }
        }
        return max;
    }
    
        // int meeting_nos= meetings.length;
        // int[] rooms = new int[n];
        // int[] count = new int[n];
        // outer:
        // for(int i =0;i<meeting_nos;i++){
        //     int earliest_avlb_room = 0;
        //     for(int j = 0;j<rooms.length;j++){
        //         if(rooms[j]<=meetings[i][0]){
        //             rooms[j]=meetings[i][1];
        //             count[j]++;
        //             continue outer;
        //         }
        //         if(rooms[j]<rooms[earliest_avlb_room])earliest_avlb_room=j;
                
        //     }
        //     rooms[earliest_avlb_room]+=meetings[i][1]-meetings[i][0];
        //     count[earliest_avlb_room]++;
            
        // }
        // int res=0;
        // for(int i =0;i<count.length;i++){
        //     if(count[i]>count[res])res=i;
        // }
        // return res;
    
}