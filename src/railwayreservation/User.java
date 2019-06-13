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
    public boolean bookTicket(Train tr, int count, int tID, boolean tat)
    {
        Ticket temp = new Ticket(tID);
        if(tat==false)
        {
            if(tr.available.contains(temp))
            {
                Ticket x = tr.available.get(tr.available.indexOf(temp));
                if(x.book(count))
                {
                    Pnr p = new Pnr(tr, this, x, count);
                    p.status.concat("CNF");
                    bookedPnr.add(p);
                    tr.available.set(tr.available.indexOf(temp), x);
                }
                else
                {
                    Pnr p = new Pnr(tr, this, x, count);
                    p.status.concat("WL");
                    bookedPnr.add(p);
    //                tr.available.set(tr.available.indexOf(temp), x);
                    tr.waitList.add(p);
                }
                return true;
            }
            else return false;
        }
        else
        {
            if(tr.tatkal.contains(temp))
            {
                Ticket x = tr.tatkal.get(tr.tatkal.indexOf(temp));
                if(x.book(count))
                {
                    Pnr p = new Pnr(tr, this, x, count);
                    p.status.concat("TKL");
                    bookedPnr.add(p);
                    tr.tatkal.set(tr.tatkal.indexOf(temp), x);
                }
                else
                {
                    Pnr p = new Pnr(tr, this, x, count);
                    p.status.concat("WL");
                    bookedPnr.add(p);
    //                tr.tatkal.set(tr.tatkal.indexOf(temp), x);
                    tr.tWaitList.add(p);
                }
                return true;
            }
            else return false;
            //kax
        }
    }
    
    
}
