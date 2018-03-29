/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floodit;

/**
 *
 * @author RaghadSalem
 */
public class returned {
    int[][] grid;
    boolean[][] adj;
    boolean[][] visited;
    int done;
    int times;
    
    public returned(){
        
    }
    public returned(int n){
        this.grid = new int[n][n];
        this.adj = new boolean[n][n];
        this.visited = new boolean[n][n];
    }
    
    public returned(int[][] grid, boolean[][] adj, boolean[][] visited, int done, int times){
        this.grid = grid;
        this.adj = adj;
        this.visited = visited;
        this.done = done;
        this.times = times;
    }
    
    public int[][] getGrid(){
        return this.grid;
    }
    
    public boolean[][] getAdj(){
        return this.adj;
    }
    
    public void setGrid(int[][] grid){
        this.grid = grid;
    }
    
    public void setAdj(boolean[][] adj){
        this.adj =  adj;
    }
    
    public void setVisited(boolean[][] v){
        this.visited = v;
    }
    public boolean[][] getVisited(){
        return this.visited;
    }
    
    public int getDone(){
        return this.done;
    }
    
    public void setDone(int d){
        this.done = d;
    }
    
    public int getTimes(){
        return this.times;
    }
}
