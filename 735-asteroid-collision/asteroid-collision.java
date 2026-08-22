class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        int n = asteroids.length;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = asteroids[i];

            while (!s.isEmpty() && s.peek() > 0 && num < 0) {

                if (s.peek() < -num) {  
                    s.pop();
                } 
                else if (s.peek() == -num) { 
                    s.pop();
                    num = 0;
                    break;
                } 
                else {         
                    num = 0;
                    break;
                }
            }

            if (num != 0) {
                s.push(num);
            }
        }

        int[] res = new int[s.size()];

        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = s.pop();
        }

        return res;
    }
}