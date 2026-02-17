class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> vals = new ArrayList<>();
        for(int i = 0;i<12;i++){
            for(int j =0;j<60;j++){
                int count = 0;
                int m = i;
                int n = j;
                while(m!=0 || n!=0){
                    count+=(m & 1);
                    count+=(n & 1);
                    m>>=1;
                    n>>=1;
                }
                if(count == turnedOn){
                    vals.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return vals;
    }
}