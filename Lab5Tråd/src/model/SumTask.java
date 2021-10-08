/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Queue;

/**
 *
 * @author user
 */
public class SumTask extends Thread {
    private int[] sum;
    private Queue high, low;
    
    public SumTask(int[] sum, Queue high, Queue low){
        this.sum = sum;
        this.high = high;
        this.low = low;
    }
    
    @Override
    public void run(){
        
    }
}
