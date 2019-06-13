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

    String pnrNo;
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
        this.bill = count * (this.t.price);
        this.count = count;
        this.status = "";
        this.pnrNo = "Tr" + myTrain.trainNo + "U" + uName.name.charAt(0) + uName.name.charAt(1) + uName.name.charAt(2) + "Ti" + t.type;
    }

    public double getBill() {
        return this.bill;
    }

    public double getRefund() {

        double refund = this.getBill();
        if (this.status.equalsIgnoreCase("CNF")) {
            if (this.uName.age > 65) {
                refund = this.bill - this.t.cancelPrice * 0.9;
            } else {
                refund = this.bill - this.t.cancelPrice;
            }
        } else if (this.status.equalsIgnoreCase("WL")) {
            refund = this.bill;
        } else if (this.status.equals("TKL")) {
            refund = 0;
        }
        this.status = "CAN";
        return refund;
    }

    public void cancel() {
        double refund=0;
        if (this.status.equals("WL")) {

            if (!(this.myTrain.waitList.remove(this))) {
                System.out.println("PNR number not found");
                return;
            }
            refund = this.getRefund();
        }
        else if(this.status.equals("WTKL"))
        {
            if (!(this.myTrain.tWaitList.remove(this))) {
                System.out.println("PNR number not found");
                return;
            }
            refund = this.getRefund();
        }
    }

    @Override
    public String toString() {
        return "Pnr{" + "Train=" + myTrain + ", Name=" + uName + ", status=" + status + ", bill=" + bill + ", Ticket count=" + count + '}';
    }

}
