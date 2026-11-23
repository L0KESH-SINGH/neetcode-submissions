class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length-1;
        int maxWater = 0;

        while (left < right) {
            int currOption = (right-left) * Math.min(heights[left], heights[right]);
            maxWater = Math.max(maxWater, currOption);
            
            if (heights[left] <= heights[right]) left++;
            else right--;
        }

        return maxWater;
    }
}
