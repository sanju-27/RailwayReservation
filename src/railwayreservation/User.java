/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayreservation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class User {

    String name, phone;
    int age, uID;
    List<Pnr> bookedPnr;

    /**
     *
     * @param uID
     * @param name
     * @param phone
     * @param age
     */
    public User(int uID, String name, String phone, int age) {
        this.name = name;
        this.uID = uID;
        this.phone = phone;
        this.age = age;
        bookedPnr = new ArrayList<>();
    }

    public boolean bookTicket(Train tr, int count, int tID, boolean tat) {
        Ticket temp = new Ticket(tID);
        if (tat == false) {
            if (tr.available.contains(temp)) {
                Ticket x = tr.available.get(tr.available.indexOf(temp));
                if (x.book(count)) {
                    Pnr p = new Pnr(tr, this, x, count);
                    p.status = p.status.concat("CNF");
                    bookedPnr.add(p);
                    tr.available.set(tr.available.indexOf(temp), x);
                } else {
                    Pnr p = new Pnr(tr, this, x, count);
                    p.status = p.status.concat("WL");
                    bookedPnr.add(p);
                    //                tr.available.set(tr.available.indexOf(temp), x);
                    tr.waitList.add(p);
                }
                return true;
            } else {
                return false;
            }
        } else if (tr.tatkal.contains(temp)) {
            Ticket x = tr.tatkal.get(tr.tatkal.indexOf(temp));
            if (x.book(count)) {
                Pnr p = new Pnr(tr, this, x, count);
                p.status = p.status.concat("TKL");
                bookedPnr.add(p);
                tr.tatkal.set(tr.tatkal.indexOf(temp), x);

            } else {
                Pnr p = new Pnr(tr, this, x, count);
                p.status = p.status.concat("WTKL");
                bookedPnr.add(p);
                //                tr.tatkal.set(tr.tatkal.indexOf(temp), x);
                tr.tWaitList.add(p);
            }
            return true;
        } else {
            return false;
        } //kax
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(uID).append(",").append(name).append(",").append(phone).append(",").append(age).append("\n");
        for (Pnr pnr : bookedPnr) {
            sb.append(pnr.pnrNo).append(",");
            
        }
        return sb.toString();
    }
    public void writeFile()
    {
        String fname = "C:/Users/Administrator/Desktop/Reservation/users/"+this.uID+".txt";
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
            bw.write(this.toString());
            bw.close();
        } catch (IOException ex) {
            System.err.println("Exception at User"+ex);
        }
    }

}
