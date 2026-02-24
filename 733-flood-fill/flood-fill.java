class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origanal= image[sr][sc];
        if(origanal == color) return image;
        fill(image,sr,sc,origanal,color);
    return image;

    }
    public static void fill(int[][] image, int sr, int sc, int origanal,int color){
        if(sr<0 || sr>image.length-1)return;
        if(sc<0 || sc>image[0].length-1)return;
        if(image[sr][sc]==origanal){
            image[sr][sc]=color;
            fill(image,sr+1,sc,origanal,color);
            fill(image,sr,sc+1,origanal,color);
            fill(image,sr-1,sc,origanal,color);
            fill(image,sr,sc-1,origanal,color);
        }
    }
}
