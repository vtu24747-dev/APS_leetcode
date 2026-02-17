import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // if number already in window, duplicate found
            if (set.contains(nums[i]))
                return true;

            set.add(nums[i]);

            // keep window size <= k
            if (set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }
}
