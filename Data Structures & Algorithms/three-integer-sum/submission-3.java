class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        int end = nums.length-1;

        for (int i=0; i<end-1; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            int j=i+1, k=end;
            
            while (j < k) {
                int sum = nums[j] + nums[k];

                if (sum == -nums[i]) {
                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++; k--;
                } else if (sum > -nums[i]) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return ans;
    }
}
