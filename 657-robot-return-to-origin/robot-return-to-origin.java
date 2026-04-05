class Solution {
    public boolean judgeCircle(String moves) {
        int vertical = 0;
        int horzental = 0;
        for(int i =0; i< moves.length();i++){
            if(moves.charAt(i)=='U')vertical++;
            if(moves.charAt(i)=='D')vertical--;
            if(moves.charAt(i)=='R')horzental++;
            if(moves.charAt(i)=='L')horzental--;
        }
        if(vertical==0&& horzental==0)return true;
        return false;
    }

}