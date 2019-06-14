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
public class Admin {
    List<Train> trains = new ArrayList<>();
    List<User> users = new ArrayList<>();
    boolean addUser(User user)
    {
        return this.users.add(user);
    }
    boolean addTrain(Train train)
    {
        train.writeFile();
        return this.trains.add(train);
    }
}
