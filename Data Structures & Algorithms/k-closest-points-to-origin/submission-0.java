class Solution {
    public int getDistance(int[] point) {
        int distance = (point[0] * point[0]) + (point[1] * point[1]);
        return distance;
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b) -> getDistance(b) - getDistance(a));

        for (int[] point : points) {
            q.add(point);
            if (q.size() > k) q.poll();
        }

        int[][] ans = new int[q.size()][2];
        int currIndex = 0;

        while (q.size() > 0) {
            int[] temp = q.poll();
            ans[currIndex][0] = temp[0];
            ans[currIndex][1] = temp[1];
            currIndex++;
        }

        return ans;
    }
}
