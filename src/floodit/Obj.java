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
public class Obj {
    /*int[][] grid;
    int[][] adjacent;
    boolean[][] visit;
    int f;
    int g;
    int h = f+g;*/
    
    int v;
    String label;
    boolean visit;
    
    // 
    public Obj(){
        this.v = 0;
        this.label = "";
        this.visit = false;
    }
    
    public Obj(int color){
        this.v = color;
    }
    
    public int get(){
        return this.v;
    }
    
    public void set(int n){
        this.v = n;
    }
    
    
    public boolean getVisit(){
        return this.visit;
    }
    
    
    public void setVisit(boolean b){
        this.visit = b;
    }
    /*public Obj(int[][] grid){
        this.grid = grid;
    }
    
    public Obj(int[][] grid, int[][] adjacent){
        this.grid = grid;
        this.adjacent = adjacent;
    }*/
    
    // METHODS
    /*public void markVisited(int i, int j){
        this.visit[i][j] = true;
    }
    
    public boolean getVisited(int i, int j){
        return this.visit[i][j];
    }*/
}
