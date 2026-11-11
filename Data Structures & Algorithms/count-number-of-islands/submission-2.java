class Solution {
    static class Node{
        int x,y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int numIslands(char[][] grid) {
        int cnt=0;
        int n=grid[0].length;
        int m=grid.length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    bfs(grid,i,j,m,n);
                }
            }
        }
        return cnt;
    }
    public static void bfs(char[][] grid,int i,int j,int m,int n){
        Deque<Node> dq=new ArrayDeque<>();
        dq.add(new Node(i,j));
        grid[i][j]='0';
        while(!dq.isEmpty()){
                Node curr=dq.pollFirst();
                if(curr.x<m-1 && grid[curr.x+1][curr.y]=='1'){
                    grid[curr.x+1][curr.y]='0';
                    dq.addLast(new Node(curr.x+1,curr.y));
                }
                if(curr.y<n-1 && grid[curr.x][curr.y+1]=='1'){
                    grid[curr.x][curr.y+1]='0';
                    dq.addLast(new Node(curr.x,curr.y+1));
                }
                if(curr.x>0 && grid[curr.x-1][curr.y]=='1'){
                    grid[curr.x-1][curr.y]='0';
                    dq.addLast(new Node(curr.x-1,curr.y));
                }
                if(curr.y>0 && grid[curr.x][curr.y-1]=='1'){
                    grid[curr.x][curr.y-1]='0';
                    dq.addLast(new Node(curr.x,curr.y-1));
                }
        }
    } 
}
