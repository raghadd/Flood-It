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
public class Queue {
    linklist list = new linklist();
    
    
    public Queue(){
        
    }
    
    public void insert(int[][] grid, boolean[][] adj, boolean[][] visited, int levelCount, int done, int times){
        this.list.insert(grid, adj, visited, levelCount, done, times);
    }
    
    public LNode dequeue(){
        return this.list.deleteFirst();
    }
}
