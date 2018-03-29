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
public class LNode {
    //LNode node;
    LNode next;
    
    int[][] grid;
    boolean[][] adjacent;
    boolean[][] visit;
    int levelCount;
    int cells;
    int times;
    int h;
    int g;
    int f = h+levelCount;
    
    // CCONSTRUCTORS
    public LNode(int[][] grid, boolean done){
        this.grid = grid;
        this.next = null;
    }
    
    public LNode(int[][] grid, int levelCount, boolean done){
        this.grid = grid;
        this.next = null;
        this.levelCount = levelCount;
    }
    public LNode(int[][] grid, boolean[][] adj, boolean[][] visited, int levelCount, int done, int times){
        this.grid = grid;
        this.adjacent = adj;
        this.visit = visited;
        this.next = null;
        this.levelCount = levelCount;
        this.cells = done;
        this.times = times;
    }
    
    public LNode(int[][] grid, boolean[][] adj, boolean[][] visited, int levelCount, int done, int h, int times){
        this.grid = grid;
        this.adjacent = adj;
        this.visit = visited;
        this.next = null;
        this.levelCount = levelCount;
        this.cells = done;
        this.h = h;
        this.f = h+levelCount;
        this.times = times;
    }
    
    // METHODS  
    public int getDone(){
        return this.cells;
    }
    public void setGrid(int[][] grid){
        this.grid = grid;
    }
    
    public void setAdj(boolean[][] adjacent){
        this.adjacent = adjacent;
    }
    
    public void markVisited(int i, int j){
        this.visit[i][j] = true;
    }
    
    public boolean getVisited(int i, int j){
        return this.visit[i][j];
    }
    
    public LNode getNext(){
        return this.next;
    }
    
    public int[][] getGrid(){
        return this.grid;
    }
    
    public int getF(){
        return this.f;
    }
    
    public boolean[][] getAdj(){
        return this.adjacent;
    }
    
    public boolean[][] getVisited(){
        return this.visit;
    }
    
    
    public void setNext(int[][] grid, int levelCount, boolean done, int times){
        this.next = new LNode(grid, levelCount, done);
    }
    public void setNext(int[][] grid, boolean[][] adj, boolean[][] visited, int levelCount, int done, int times){
        this.next = new LNode(grid, adj, visited, levelCount, done, times);
    }
    
    public void setNext(LNode n){
        this.next = n;
    }
    
    public int getTimes(){
        return this.times;
    }
    
    public int getLevel(){
        return this.levelCount;
    }
}
