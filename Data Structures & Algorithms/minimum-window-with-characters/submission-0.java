class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> mp = new HashMap<>();
        for (char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> mp2 = new HashMap<>();
        int count = 0;
        int p1 = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            mp2.put(ch, mp2.getOrDefault(ch, 0) + 1);
            if (mp.containsKey(ch)
                    && mp2.get(ch).intValue() == mp.get(ch).intValue()) {
                count++;
            }
            while (count == mp.size()) {
                if (i - p1 + 1 < minLen) {
                    minLen = i - p1 + 1;
                    start = p1;
                }

                char left = s.charAt(p1);

                if (mp.containsKey(left)
                        && mp2.get(left).intValue()
                        == mp.get(left).intValue()) {
                    count--;
                }

                mp2.put(left, mp2.get(left) - 1);
                p1++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}