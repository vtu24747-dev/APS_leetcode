class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if (s.length() < p.length()) return result;

        int[] count = new int[26];

        // Count characters in p
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0, right = 0, needed = p.length();

        while (right < s.length()) {
            char c = s.charAt(right);

            if (count[c - 'a'] > 0) {
                needed--;
            }
            count[c - 'a']--;

            right++;

            if (needed == 0) {
                result.add(left);
            }

            if (right - left == p.length()) {
                char leftChar = s.charAt(left);

                if (count[leftChar - 'a'] >= 0) {
                    needed++;
                }
                count[leftChar - 'a']++;

                left++;
            }
        }

        return result;
    }
}