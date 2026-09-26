class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                StringBuilder key = new StringBuilder();
                i++;

                while (s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }

                result.append(map.getOrDefault(key.toString(), "?"));

            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}