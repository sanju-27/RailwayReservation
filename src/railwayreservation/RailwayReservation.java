/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayreservation;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                } while (ch1 < 3);
            }
        } while (id < 0);

    }

}
