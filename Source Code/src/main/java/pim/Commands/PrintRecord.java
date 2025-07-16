package src.main.java.pim.Commands;

import java.util.*;

import src.main.java.pim.Records.*;
import src.main.java.pim.Records.Record;

// As a user, I want to print out detailed information about a specific PIR or all PIRs.
public class PrintRecord implements Controller {

    protected ArrayList<Record> records;
    private Scanner sc = new Scanner(System.in);

    public PrintRecord(ArrayList<Record> records) {
        this.records = records;
    }

    public void execute() {

        System.out.println("=============================================");
        System.out.println("======== PIM System - Print Record ==========");
        System.out.println("=============================================");
        for (int i = 0; i < records.size(); i++) {
            System.out.println("[" + i + "] " + records.get(i).toString());
        }
        // ask user to enter index of record want to print or all records to print
        System.out.println("=============================================");
        System.out.println("Please enter index of record want to print:  ");
        System.out.println("If you want to print all records, enter -1:  ");
        System.out.println("=============================================");
        int index = sc.nextInt();

        if (index < -1 || index >= records.size()) {
            System.out.println("Invalid index!");
            return;
        }

        // identify the type of records and print the record
        if (index == -1) {
            System.out.println("=============================================");
            System.out.println("All records: ");
            for (int i = 0; i < records.size(); i++) {
                System.out.println("[" + i + "] " + (records.get(i) instanceof Task ? "Task: " : records.get(i) instanceof Note ? "Note: " : records.get(i) instanceof Contact ? "Contact: " : "Event: ") + records.get(i).toString());
            }
        } else {
            if (records.get(index) instanceof Task) {
                System.out.println("Task: " + records.get(index).toString());
            } else if (records.get(index) instanceof Note) {
                System.out.println("Note: " + records.get(index).toString());
            } else if (records.get(index) instanceof Contact) {
                System.out.println("Contact: " + records.get(index).toString());
            } else if (records.get(index) instanceof Event) {
                System.out.println("Event: " + records.get(index).toString());
            }
        }
    }
}