class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<arr.length-1;i++){
            sb.append(new StringBuilder(arr[i]).reverse());
            sb.append(" ");
        }
        sb.append(new StringBuilder(arr[arr.length-1]).reverse());
        return sb.toString();
    }
}