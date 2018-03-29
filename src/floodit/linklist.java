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
public class linklist {
    LNode first;
    
    int n;
    //Node[] nodes;
   
    
    public linklist(){
        this.first = null;
        
    }
    public linklist(int n){
        this.n = n;
        //this.nodes = new Node[n];
        
        for(int i = 0 ; i<n ; i++){
            //this.nodes[i] = new
        }
    }
    
    /*public void insert(int[][] grid, int levelCount, boolean done, int times){
        if (this.isEmpty()){
            this.first = new LNode(grid, levelCount, done, times);
        }
        else {
            LNode w = this.first;
            while (w.getNext() != null){
                w = w.getNext();
            }
            w.setNext(grid, levelCount, done, times, times);
        }
    }*/
    
    public void insert(int[][] grid, boolean[][] adj, boolean[][] visited, int levelCount, int done, int times){
        if (this.isEmpty()){
            this.first = new LNode(grid, adj, visited, levelCount, done, times);
        }
        else {
            LNode w = this.first;
            while (w.getNext() != null){
                w = w.getNext();
            }
            w.setNext(grid, adj, visited, levelCount, done, times);
        }
    }
    
    public void PQInsert(int[][] grid, boolean[][] adj, boolean[][] visited, int levelCount, int done, int h, int times){
        LNode hptr = this.first;
        LNode newNode = new LNode(grid, adj, visited, levelCount, done, h, times);
        
        if (this.isEmpty()){
            this.first = new LNode(grid, adj, visited, levelCount, done, h, times);
        }
        else if (hptr.getF()> newNode.getF()){
            newNode.setNext(this.first);
            this.first = newNode;
        } else {
            while (hptr.getNext() != null){
                if (hptr.getNext().getF() > newNode.getF()){
                    break;
                }
                hptr = hptr.getNext();
            }
            newNode.setNext(hptr.getNext());
            hptr.setNext(newNode);
        } 
    }
    
    
    public boolean isEmpty(){
        return (this.first == null);
    }
    
    public LNode deleteFirst(){
        if (this.isEmpty()){
            return null;
        }
        else {
            LNode w = this.first;
            this.first = this.first.getNext();
            return w;
        }
    }
    
    public LNode getFirst(){
        LNode r = this.first;
        this.first = this.first.getNext();
        return r;
    }
}
