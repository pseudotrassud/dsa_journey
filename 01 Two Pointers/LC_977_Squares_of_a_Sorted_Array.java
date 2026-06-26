class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0,
            j = nums.length-1;
        int fill=nums.length-1;

        while(fill>=0) {
            if(Math.abs(nums[i]) > Math.abs(nums[j])) {
                ans[fill]= nums[i]*nums[i];
                i=i+1;                
            }
            else {
                ans[fill] = nums[j]*nums[j];
                j=j-1;
            }
            fill--;
        }
        return ans;
    }
}