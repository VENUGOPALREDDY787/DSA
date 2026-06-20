import java.util.*;

class Solution {

    class Point {
        String word;
        int level;

        Point(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);

        // If endWord is not present
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(beginWord, 1));

        // Mark beginWord visited
        set.remove(beginWord);

        while (!q.isEmpty()) {
            Point now = q.poll();
            String word = now.word;
            int level = now.level;

            if (word.equals(endWord)) {
                return level;
            }

            for (int i = 0; i < word.length(); i++) {

                char[] arr = word.toCharArray();
                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;

                    String newWord = new String(arr);

                    if (set.contains(newWord)) {
                        q.add(new Point(newWord, level + 1));
                        set.remove(newWord); // mark visited
                    }
                }

                arr[i] = original;
            }
        }

        return 0;
    }
}