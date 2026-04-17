class Solution {
    public int orangesRotting(int[][] grid) {
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    grid[i][j]=Integer.MAX_VALUE;
                }
                else if(grid[i][j]==2){
                    grid[i][j]=0;
                }
                else{
                  grid[i][j]=-1;
                }
            }
            
        }
        
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    func(grid,i,j,0);
                    
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==Integer.MAX_VALUE){
                    return -1;
                }
                c=Math.max(c,grid[i][j]);
            }
        }
        return c;
        
    }
    public static void func(int[][] grid ,int i,int j,int time){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==-1){
            return;
        } 
        if(grid[i][j]<time){
            return;
        }
        grid[i][j]=time;
        
        
        func(grid,i+1,j,time+1);
        func(grid,i,j+1,time+1);
        func(grid,i-1,j,time+1);
        func(grid,i,j-1,time+1);

    }
}