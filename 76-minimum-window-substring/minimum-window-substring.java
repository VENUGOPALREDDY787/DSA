class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (int k = 0; k < t.length(); k++) {
            char ch = t.charAt(k);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int n = s.length();
        int count = t.length();

        int i = 0;
        int j = 0;

        int head = 0;
        int d = Integer.MAX_VALUE;

        while (j < n) {

            char ch = s.charAt(j);

            if (map.containsKey(ch)) {

                if (map.get(ch) > 0) {
                    count--;
                }

                map.put(ch, map.get(ch) - 1);
            }

            while (count == 0) {

                if (j - i + 1 < d) {
                    d = j - i + 1;
                    head = i;
                }

                char at = s.charAt(i);

                if (map.containsKey(at)) {
                    map.put(at, map.get(at) + 1);

                    if (map.get(at) > 0) {
                        count++;
                    }
                }

                i++;
            }

            j++;
        }

        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}