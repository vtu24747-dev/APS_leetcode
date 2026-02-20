import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        // min heap based on frequency
        PriorityQueue<Integer> heap =
            new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int num : map.keySet()) {
            heap.offer(num);
            if (heap.size() > k)
                heap.poll();
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--)
            result[i] = heap.poll();

        return result;
    }
}