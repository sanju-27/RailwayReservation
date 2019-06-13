/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayreservation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class User {
    
    String name, phone;
    int age;
    List <Pnr> bookedPnr; 

    public User(String name, String phone, int age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        bookedPnr = new ArrayList<>();
    }
    public boolean bookTicket(Train tr, int count, )
    {
        
    }
    
    
}
