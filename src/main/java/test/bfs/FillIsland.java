package test.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class FillIsland {
    private static int land = 1;
    public static void main(String[] args) {
        int[][] numbers = {{1,1},{1,1}};
        System.out.println(maxAreaOfIsland(numbers));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(!visited[i][j] && grid[i][j] == land){
                    int area = getArea( new Index(i,j), grid, visited);
                    maxArea = area > maxArea ? area : maxArea;
                }
            }
        }
        return maxArea;
    }

    private static int getArea(Index index, int[][]grid, boolean[][] visited){
        Queue<Index> queue = new LinkedList();
        queue.add(index);
        int area = 0;
        while(!queue.isEmpty()){
            Index curr = queue.poll();
            visited[curr.row][curr.col] = true;
            area++;
            List<Index> neighbors = getNeighboringLand(curr, grid, visited);
            neighbors.forEach( entry -> {
                visited[entry.row][entry.col] = true;
                queue.add(entry);
            });
        }
        return area;
    }

    private static List<Index> getNeighboringLand(Index index, int[][]grid, boolean[][] visited){
        List<Index> neighbors = new ArrayList(4);
        int row = index.row;
        int col = index.col;
        if( row-1 >=0 && !visited[row-1][col] && grid[row-1][col] == land )
            neighbors.add(new Index(row-1,col));
        if( row+1 < grid.length && !visited[row+1][col] && grid[row+1][col] == land )
            neighbors.add(new Index(row+1,col));
        if( col-1 >=0 && !visited[row][col-1] && grid[row][col-1] == land )
            neighbors.add(new Index(row,col-1));
        if( col+1 < grid[row].length && !visited[row][col+1] && grid[row][col+1] == land )
            neighbors.add(new Index(row,col+1));
        return neighbors;
    }

    private static class Index {
        int row;
        int col;

        public Index(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}