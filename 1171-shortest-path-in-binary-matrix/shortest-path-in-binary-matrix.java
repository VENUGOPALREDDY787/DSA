class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] ==1){
            return -1;
        }
        int[][] directions = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},        {0,1},
            {1,-1},{1,0},{1,1}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        grid[0][0] =1;
        int pathlen= 1;
        while(!queue.isEmpty()){
            int size = queue.size();
for(int i = 0; i < size; i++){
            
                int[] cell = queue.poll();
                int r = cell[0],c =cell[1];
                if(r==n-1&& c==n-1){
                    return pathlen;
                }
                for(int[] d : directions){
                    int nr =r+d[0];
                    int nc =c+d[1];
                    if(nr>=0&& nc>=0&&nc<n&&nr<n&&grid[nr][nc]==0){
                        queue.offer(new int[]{nr,nc});
                        grid[nr][nc] =1;
                    }
                }
            } pathlen++;
        }
        return -1;

    }
}