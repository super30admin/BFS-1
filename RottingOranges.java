
/*
Thought Process: 
Using DFS approach is not feasible as at same instant different oranges at different locations will be rotten. So used BFS.
Firstly, find all the rotten oranges and add them tot he rotten queue and calculate initial number of fresh oranges.
Loop through queue in 4 in-bounds direction for all the rotten tomates. Once q is empty check if fresh oranges are still left then return -1 else total time taken -1.

TC -> O(V+E) or O(M*N)
SC -> O(M*N) where it is the toal size of the grid
*/

class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int fresh = 0, time = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> rottenQ = new LinkedList<>();
        
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1)
                    fresh++;
                if(grid[i][j] == 2)
                    rottenQ.add(new int[]{i,j});
            }
        }
        
        if(fresh == 0) return 0;
        
        while(!rottenQ.isEmpty()){
            int size = rottenQ.size();
            for(int k = 0; k<size; k++){
                int[] polled = rottenQ.poll();
                for(int[] dir : dirs){
                    int r = polled[0] + dir[0];
                    int c = polled[1] + dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c] == 1){
                        grid[r][c]=2;
                        rottenQ.add(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        
        if(fresh > 0) return -1;
        return time-1;
    }
}