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
public class adjacent {
    boolean adj;
    
    public adjacent(){
        this.adj = false;
    }
    
    public void set(boolean adj){
        this.adj = adj;
    }
    
    public boolean get(){
        return this.adj;
    }
    
}
