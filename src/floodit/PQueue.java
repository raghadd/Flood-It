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
public class PQueue {
    linklist list = new linklist();
    
    public PQueue(){
        
    }
    
    public void insert(int[][] grid, boolean[][] adj, boolean[][] visited, int levelCount, int done, int h, int times){
        this.list.PQInsert(grid, adj, visited, levelCount, done, h, times);
    }
    
    public LNode dequeue(){
        return this.list.deleteFirst();
    }
    
}
