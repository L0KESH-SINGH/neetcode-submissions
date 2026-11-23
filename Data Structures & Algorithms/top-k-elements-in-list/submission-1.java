class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b) -> map.get(a) - map.get(b));

        for (int ele : map.keySet()) {
            minHeap.add(ele);
            
            while (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int ans[] = new int[k];
        for (int i=0; i<k; i++) {
            ans[i] = minHeap.poll();
        }

        return ans;
    }
}
