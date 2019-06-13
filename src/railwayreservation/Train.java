/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayreservation;

import java.util.*;
//import java.util.List;

/**
 *
 * @author Administrator
 */
class Train {
    int trainNo;
    List<Ticket> available = new ArrayList<>();
//    Map<User, Pnr> waitList = new LinkedHashMap<>();
    List<Pnr> waitList = new ArrayList<>();
    List<Pnr> tWaitList = new ArrayList<>();
    List<Pnr> names = new ArrayList<>();
    List<Ticket> tatkal = new ArrayList<>();

    public Train(int trainNo) {
        this.trainNo = trainNo;
    }

    public void setAvailable(List<Ticket> available) {
        this.available = available;
    }

    public void setTatkal(List<Ticket> tatkal) {
        this.tatkal = tatkal;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
