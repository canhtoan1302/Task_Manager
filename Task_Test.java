    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task_manager;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dell
 */
public class Task_Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Task> list = new ArrayList<>();
//        list.add(new Task(1, "Dev program", 1, "20-02-2020", 8, 13.5, "dev", "A"));
//        list.add(new Task(2, "Test program", 2, "25-03-2020", 8, 10, "test", "B"));
//        list.add(new Task(3, "Dev1 program", 3, "13-04-2020", 9.5, 13.0, "dev 1", "C"));
//        list.add(new Task(4, "Dev2 program", 4, "28-05-2020", 8.0, 17.5, "dev 2", "D"));
        manager m = new manager(list);
        while (true) {
            System.out.println("1. Add task\n"
                              +"2. Delete task\n"
                              +"3. Display task\n"
                              +"4. Exit");
            int choice = m.checkInt("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1: {
                    m.addTask();
                    break;
                }
                case 2: {                  
                    m.deleteTask();
                    break;
                }
                case 3: {
                    m.showTasks();
                    break;
                }
                case 4: {
                    return;
                }
            }
        }
    }

}
