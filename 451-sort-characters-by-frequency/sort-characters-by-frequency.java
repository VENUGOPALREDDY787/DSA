import java.util.*;

class Solution {

    class node implements Comparable<node> {

        int count;
        char ch;

        public node(char ch, int count) {
            this.count = count;
            this.ch = ch;
        }

        @Override
        public int compareTo(node n) {
            return n.count - this.count;
        }
    }

    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // count frequency
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<node> pq = new PriorityQueue<>();

        for (char ch : map.keySet()) {
            pq.add(new node(ch, map.get(ch)));
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {

            node now = pq.poll();

            int count = now.count;

            while (count > 0) {
                sb.append(now.ch);
                count--;
            }
        }

        return sb.toString();
    }
}