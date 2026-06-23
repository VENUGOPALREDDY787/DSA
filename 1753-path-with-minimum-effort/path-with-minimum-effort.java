class Solution {
    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] efforts = new int[rows][cols];

        for(int[] row : efforts){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        efforts[0][0] = 0;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) -> a[0] - b[0]);

        pq.add(new int[]{0,0,0});

        int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        while(!pq.isEmpty()){

            int[] current = pq.poll();

            int effort = current[0];
            int row = current[1];
            int col = current[2];

            if(row == rows - 1 && col == cols - 1){
                return effort;
            }

            if(effort > efforts[row][col]){
                continue;
            }

            for(int[] dir : directions){

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow < 0 || newRow >= rows ||
                   newCol < 0 || newCol >= cols){
                    continue;
                }

                int diff = Math.abs(
                    heights[newRow][newCol] - heights[row][col]
                );

                int newEffort = Math.max(effort, diff);

                if(newEffort < efforts[newRow][newCol]){

                    efforts[newRow][newCol] = newEffort;

                    pq.add(new int[]{
                        newEffort,
                        newRow,
                        newCol
                    });
                }
            }
        }

        return 0;
    }
}