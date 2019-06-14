/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayreservation;

import java.util.*;
import java.io.*;


/**
 *
 * @author Administrator
 */
public class RailwayReservation {

    /**
     * @param args the command line arguments
     */
    static void writeFile(String fname, String str) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fname, true));
            bw.write(str);
        } catch (IOException ex) {
            System.err.println("Caught exception" + ex);
        }

    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Admin admin = (Admin)Admin.readFile();
        if(admin==null)
            admin = new Admin();
        String userFile = "C:/Users/Administrator/Desktop/userFile";
        int id = 3;
        do {
            System.out.print("Welcome to Railway Reservation\nEnter ID / Enter -1 to exit: ");
            id = Integer.parseInt(br.readLine());
            if (id == 1) {
                int ch1;
                do {
                    System.out.println("Hello Admin\n1.User\n2.Trains\n3.Logout");
                    ch1 = Integer.parseInt(br.readLine());
                    if (ch1 == 1) {
                        int ch2;
                        System.out.println("1.Add\n2.View\n3.Count\n4.Exit");
                        do
                        {
                            ch2 = Integer.parseInt(br.readLine());
                            switch (ch2)
                            {
                                case 1:
                                    System.out.print("Enter Name: ");
                                    String name = br.readLine();
                                    System.out.print("Enter Phone number: ");
                                    String ph = br.readLine();
                                    System.out.print("Entetr age: ");
                                    int age = Integer.parseInt(br.readLine());
                                    admin.users.add(new User(admin.users.size(), name, ph, age));
                                    break;
                                case 2:
                                    System.out.print("Enter UID: ");
                                    int uid = Integer.parseInt(br.readLine());
                                    System.out.println(admin.users.get(uid).toString());
                                    break;  
                                case 3:
                                    System.out.println("Total number of users: "+admin.users.size());
                            }
                        }while(ch2<3);
                    }
                    if(ch1==2)
                    {
                        int ch2;
                        System.out.println("1.Add\n2.View\n3.Count\n4.Exit");
                        do
                        {
                            ch2 = Integer.parseInt(br.readLine());
                            switch (ch2)
                            {
                                case 1:
                                    System.out.print("Enter Train number: ");
                                    int num = Integer.parseInt(br.readLine());
                                    Train t = new Train(num);
                                    List<Ticket> gen = new ArrayList<>();
                                    List<Ticket> tat = new ArrayList<>();
                                    System.out.print("Enter Type count: ");
                                    int n = Integer.parseInt(br.readLine());
                                    System.out.println("TID\tType\tGeneral\tTatkal\tPrice\tCancel Fee");
                                    for(int i = 0; i<n; i++)
                                    {
                                        String[] s = br.readLine().split(" ");
                                        Ticket gt = new Ticket(Integer.parseInt(s[0]),s[1],Double.valueOf(s[4]),Integer.parseInt(s[2]),Double.valueOf(s[5]));
                                        Ticket tt = new Ticket(Integer.parseInt(s[0]),s[3],Double.valueOf(s[4]),Integer.parseInt(s[2]),Double.valueOf(s[5]));
                                        gen.add(gt);
                                        tat.add(tt);
                                    }
                                    Map<String,String> mp = new HashMap<>();
                                    System.out.println("Enter Route Details\n");
                                    System.out.print("Number of Stops: ");
                                    n = Integer.parseInt(br.readLine());
                                    System.out.println("Place\tTime");
                                    for (int i = 0; i < n; i++) {
                                        String s[] = br.readLine().split(" ");
                                        mp.put(s[0], s[1]);
                                    }
                                    t.setRoute(mp);
                                    t.setAvailable(gen);
                                    t.setTatkal(tat);
                                    admin.trains.add(t);
                                    break;
                                case 2:
                                    System.out.print("Enter Train number: ");
                                    int uid = Integer.parseInt(br.readLine());
                                    System.out.println(admin.users.get(uid).toString());
                                    break;  
                                case 3:
                                    System.out.println("Total number of users: "+admin.users.size());
                            }
                        }while(ch2<3);
                    }
                } while (ch1 < 3);
            }
        } while (id < 0);

    }

}
