class Solution {
    public void sumHelper(int f, int[] nums, List<List<Integer>> res) {

        int i = f + 1;
        int j = nums.length - 1;

        while (i < j) {
            int sum = nums[f] + nums[i] + nums[j];
            if (sum > 0) {
                j--;
            } else if (sum < 0) {
                i++;
            }
            /// sum is 0;
            else {
                res.add(Arrays.asList(nums[f], nums[i], nums[j]));
                i++;
                j--;

                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int f = 0; f < nums.length - 2 && nums[f] <= 0; f++) {

            if (f == 0 || nums[f] != nums[f - 1]) {
                sumHelper(f, nums, res);
            }
        }
        return res;

    }
}