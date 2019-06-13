/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayreservation;

/**
 *
 * @author Administrator
 */
public class Ticket {
    
    
    String type;
    double price;
    int count;
    double cancelPrice;
    
    public Ticket(String type, double price, int count, double cancelPrice)
    {
        this.type = type;
        this.cancelPrice = cancelPrice;
        this.count = count;
        this.price = price;
    }
    
    public boolean book(int n)
    {
        if(this.count<n)
            return false;
        else
            this.count-=n;
        return true;
    }    
}
