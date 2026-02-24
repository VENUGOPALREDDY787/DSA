class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) {
            return image;
        }

        int k = image[sr][sc];
        image[sr][sc] = color;
        int m = image.length;
        int n = image[0].length;
        if(sr>0){
            if(image[sr-1][sc] == k ) {
                floodFill(image, sr-1, sc, color);
            }
        }
        if(sc<n-1){
            if(image[sr][sc+1] == k) {
                floodFill(image, sr, sc+1, color);
            }
        }
        if(sr<m-1){
            if(image[sr+1][sc] == k) {
                floodFill(image, sr+1, sc, color);
            }
        }
        if(sc>0){
            if(image[sr][sc-1] == k) {
                floodFill(image, sr, sc-1, color);
            }
        }

        return image;
        
    }
}