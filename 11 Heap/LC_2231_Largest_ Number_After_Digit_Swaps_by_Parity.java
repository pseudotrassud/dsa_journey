
class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> even  = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd  = new PriorityQueue<>(Collections.reverseOrder());

        char[] digits = String.valueOf(num).toCharArray();
        for (char c : digits){
            if((c-'0')%2==0){
                even.offer(c-'0');
            }
            else{odd.offer(c-'0');}
        }
        StringBuilder res = new StringBuilder();
        for(int i =0;i<digits.length;i++){
            int digit = digits[i]-'0';
            if(digit%2==0){
                res.append(even.poll());
            }
            else{
                res.append(odd.poll());
            }
        }
        return Integer.parseInt(res.toString());


    }
}