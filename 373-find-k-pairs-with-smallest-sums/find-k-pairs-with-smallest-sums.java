import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return result;

        PriorityQueue<int[]> heap =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // push first column pairs
        for (int i = 0; i < nums1.length && i < k; i++) {
            heap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k-- > 0 && !heap.isEmpty()) {
            int[] curr = heap.poll();
            int i = curr[1];
            int j = curr[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // push next pair in same row
            if (j + 1 < nums2.length) {
                heap.offer(new int[]{
                    nums1[i] + nums2[j + 1],
                    i,
                    j + 1
                });
            }
        }
        return result;
    }
}