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
class Pnr {
    Train myTrain;
    String status;
    User uName;
    Ticket t;
    double bill;
    int count;

    public Pnr(Train myTrain, User uName, Ticket t, int count) {
        this.myTrain = myTrain;
        this.uName = uName;
//        this.status = status;
        this.t = t;
        this.bill = count*(this.t.price);
        this.count = count;
    }
    public double getBill()
    {
        return this.bill;
    }
    public double cancel()
    {
        
        double refund = 0.0;
        if(this.status.equalsIgnoreCase("CNF"))
        {
            if(this.uName.age>65)
            {
                refund = this.bill - this.t.cancelPrice*0.9;
            }
            else
                refund = this.bill - this.t.cancelPrice;
        }
        else if(this.status.equalsIgnoreCase("CAN"))
        {
            refund = this.bill;
        }
        else if(this.status.equals("TKL"))
            refund = 0;
        this.status = "cancelled";
        return refund;
    }

    @Override
    public String toString() {
        return "Pnr{" + "Train=" + myTrain + ", Name=" + uName + ", status=" + status + ", bill=" + bill + ", Ticket count=" + count + '}';
    }
    
    
}
