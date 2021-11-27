/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task_manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class manager {

    Scanner sc = new Scanner(System.in);
    public ArrayList<Task> list;

    public manager(ArrayList<Task> list) {
        this.list = list;
    }

    public manager() {
    }

    public void addTask() {
        int id;
        if (list.isEmpty()) {
            id = 1;
        } else {
            id = list.get(list.size() - 1).getId() + 1;
        }
        String name = checkString("Enter name: ");
        int typeID = checkInt("Enter type id: ", 1, 4);
        String date = checkDate("Enter date: ");
//        double from = checkFromTo("Enter From: ", 8, 17.5);
//        double to = checkFromTo("Enter To: ", from + 0.5, 17.5);

        double from;
        double to;
        while(true){
            from = checkFromTo("from: ", 8, 17.5);
            to = checkFromTo("from: ", 8, 17.5);
            if(to > from){
                break;
            }else{
                System.out.println("Enter again");
            }
        }
        
        String assignee = checkString("Enter assignee: ");
        String reviewer = checkString("Enter reviewer: ");
        Task t = new Task(id, name, typeID, date, from, to, assignee, reviewer);
        list.add(t);
    }

    public void deleteTask() {
        int delID = checkInt("Enter id you want to delete: ", 1, list.size());
        int checkID = checkIDexist(list, delID);
        if (checkID != -1) {
            list.remove(checkID);
            System.out.println("Delete successfull");
        } else {
            System.out.println("Id is not exist");
        }
    }

    public int checkIDexist(ArrayList<Task> list, int id) {
        for (Task t : list) {
            if (t.getId() == id) {
                return list.indexOf(t);
            }
        }
        return -1;
    }

    public void showTasks() {
        System.out.printf("%-10s%-30s%-15s%-15s%-10s%-15s%-15s\n",
                "ID", "Name", "Task type", "Date", "Time", "Assignee", "Reviewer");
        for (Task o : list) {
            o.display();
        }
    }

    //ham check double
    public double checkFromTo(String s, double min, double max) {
        double a = 0;
        do {
            System.out.print(s);
            try {
                a = Double.parseDouble(sc.nextLine());
                if (a >= min && a <= max) {
                    if (a % 0.5 == 0) {
                        return a;
                    }
                } else {
                    System.out.println("out of range, input must be in [" + min + ", " + max + "] please.");
                }
            } catch (Exception e) {
                System.out.println("accept number only");
            }
        } while (true);
    }

    //ham check int
    public int checkInt(String s, int min, int max) {
        int number = 0;
        do {
            System.out.print(s);
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("out of range, try again!");
                }
            } catch (Exception e) {
                System.out.println("accept number only");
            }
        } while (true);
    }

    //ham check date
    public String checkDate(String s) {
        Date d;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        do {
            System.out.print(s);
            try {
                d = sdf.parse(sc.nextLine());
                return sdf.format(d);
            } catch (Exception e) {
                System.out.println("invalid date input, try again");
            }
        } while (true);
    }

    public String checkString(String s) {
        String str;
        do {
            System.out.println(s);
            //System.out.print("Input name: ");
            try {
                str = sc.nextLine();
                if (!str.trim().isEmpty()) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("not accept empty name");
            }
        } while (true);
        return str;
    }


}
