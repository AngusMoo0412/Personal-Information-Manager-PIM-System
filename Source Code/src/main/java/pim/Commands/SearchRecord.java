package src.main.java.pim.Commands;

import java.util.*;

import src.main.java.pim.Records.*;
import src.main.java.pim.Records.Record;

public class SearchRecord implements Controller {

    protected ArrayList<Record> records;
    private Scanner sc = new Scanner(System.in);

    public SearchRecord(ArrayList<Record> records) {
        this.records = records;
    }

    public void execute() {

        System.out.println("=============================================");
        System.out.println("======== PIM System - Search Record =========");
        System.out.println("=============================================");
        System.out.println("Please enter type of record want to search:  ");
        System.out.println("| 1. Task                                   |");
        System.out.println("| 2. Note                                   |");
        System.out.println("| 3. Contact                                |");
        System.out.println("| 4. Event                                  |");
        System.out.println("=============================================");
        int type = sc.nextInt();
        sc.nextLine();

        if (type < 1 || type > 4) {
            System.out.println("Invalid type!");
            return;
        }

        System.out.println("Please enter criteria: ");
        String criteria = sc.nextLine();
        if (type == 1) {
            for (int i = 0; i < records.size(); i++) {
                if (records.get(i) instanceof Task) {
                    if (((Task) records.get(i)).getDescription().contains(criteria)) {
                        System.out.println("=============================================");
                        System.out.println("Search Result                                ");
                        System.out.println("=============================================");
                        System.out.println("Task: " + records.get(i).toString());
                    }
                }
            }
        } else if (type == 2) {
            for (int i = 0; i < records.size(); i++) {
                if (records.get(i) instanceof Note) {
                    if (((Note) records.get(i)).getText().contains(criteria)) {
                        System.out.println("=============================================");
                        System.out.println("Search Result                                ");
                        System.out.println("============================================="); 
                        System.out.println("Note: " + records.get(i).toString());
                    }
                }
            }
        } else if (type == 3) {
            for (int i = 0; i < records.size(); i++) {
                if (records.get(i) instanceof Contact) {
                    if (((Contact) records.get(i)).getFirstName().contains(criteria) || ((Contact) records.get(i)).getLastName().contains(criteria) || ((Contact) records.get(i)).getPhoneNumber().contains(criteria)) {
                        System.out.println("=============================================");
                        System.out.println("Search Result                                ");
                        System.out.println("============================================="); 
                        System.out.println("Contact: " + records.get(i).toString());
                    }
                }
            }
        } else if (type == 4) {
            for (int i = 0; i < records.size(); i++) {
                if (records.get(i) instanceof Event) {
                    if (((Event) records.get(i)).getDescription().contains(criteria) || ((Event) records.get(i)).getTime().toString().contains(criteria) || ((Event) records.get(i)).getAlarm().toString().contains(criteria)) {
                        System.out.println("=============================================");
                        System.out.println("Search Result                                ");
                        System.out.println("============================================="); 
                        System.out.println("Event: " + records.get(i).toString());
                    }
                }
            }
        }
    }
}
