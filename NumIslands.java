class Solution {
    public int numIslands(char[][] grid) {
        
        int island_count = 0;
        int row_len = grid.length;
        if(grid.length == 0) return island_count; 
        int col_len = grid[0].length;
        
        boolean[][] visited = new boolean[row_len][col_len];
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    island_count ++;
                    DFS_Traverse(grid, visited, i, j, row_len, col_len);
                }
            }
        }
        return island_count;
    }
    
    public void DFS_Traverse(char[][] adj, boolean[][] visited, int i, int j, int r_len, int c_len){
        
        visited[i][j] = true;
        if(i-1 >= 0     &&  adj[i-1][j] == '1'  &&  !visited[i-1][j]) DFS_Traverse(adj,visited, i-1, j, r_len, c_len);
        if(i+1 < r_len  &&  adj[i+1][j] == '1'  &&  !visited[i+1][j]) DFS_Traverse(adj,visited, i+1, j, r_len, c_len);
        if(j-1 >= 0     &&  adj[i][j-1] == '1'  &&  !visited[i][j-1]) DFS_Traverse(adj,visited, i, j-1, r_len, c_len);
        if(j+1 < c_len  &&  adj[i][j+1] == '1'  &&  !visited[i][j+1]) DFS_Traverse(adj,visited, i, j+1, r_len, c_len);
    }
}
