package src.main.java.pim.Commands;

import java.util.*;

import src.main.java.pim.Records.*;
import src.main.java.pim.Records.Record;

import java.time.LocalTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ModifyRecord implements Controller {

    protected ArrayList<Record> records;
    private Scanner sc = new Scanner(System.in);

    public ModifyRecord(ArrayList<Record> records) {
        this.records = records;
    }

    public void execute() {

        System.out.println("=============================================");
        System.out.println("======== PIM System - Modify Record =========");
        System.out.println("=============================================");
        for (int i = 0; i < records.size(); i++) {
            System.out.println("[" + i + "] " + records.get(i).toString());
        }
        System.out.println("=============================================");
        System.out.println("Please enter index of record you want to modify: ");
        System.out.println("=============================================");
        int index = sc.nextInt();
        // Consume the newline character
        sc.nextLine(); 

        // if the index is out of range of records size then return
        if (index < 0 || index >= records.size()) {
            System.out.println("Invalid index!");
            return;
        }

        // identify the type of records and modify the record
        if (records.get(index) instanceof Task) {
            System.out.println("Please enter new Task description: ");
            String new_description = sc.nextLine();
            System.out.println("Please enter new Task date (MM/DD/YYYY): ");
            String new_dateStr = sc.nextLine();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date new_date = dateFormat.parse(new_dateStr);
                Task new_task = new Task(new_description, new_date);
                records.set(index, new_task);
                System.out.println("Record modified successfully!");
            } catch (ParseException e) {
                System.out.println("Invalid date format!");
                return;
            }
        } else if (records.get(index) instanceof Note) {
            System.out.println("Please enter new note text: ");
            String new_text = sc.nextLine();
            Note new_note = new Note(new_text);
            new_note.setText(new_text);
            records.set(index, new_note);
            System.out.println("Record modified successfully!");

        } else if (records.get(index) instanceof Contact) {
            System.out.println("Please enter new contact first name: ");
            String new_firstName = sc.nextLine();
            System.out.println("Please enter new contact last name: ");
            String new_lastName = sc.nextLine();
            System.out.println("Please enter new contact phone number: ");
            String new_phoneNumber = sc.nextLine();
            Contact new_contact = new Contact(new_firstName, new_lastName, new_phoneNumber);
            records.set(index, new_contact);
            System.out.println("Record modified successfully!");
        } else if (records.get(index) instanceof Event) {
            System.out.println("Please enter new event description: ");
            String new_description = sc.nextLine();
            System.out.println("Please enter new event date (MM/DD/YYYY): ");
            String new_dateStr = sc.nextLine();
            System.out.println("Please enter new event time (HH:mm): ");
            String new_timeStr = sc.nextLine();
            System.out.println("Please enter new event alarm (HH:mm): ");
            String new_alarmStr = sc.nextLine();

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date new_date = dateFormat.parse(new_dateStr);
                LocalTime new_time = LocalTime.parse(new_timeStr);
                LocalTime new_alarm = LocalTime.parse(new_alarmStr);
                Event new_event = new Event(new_description, new_date, new_time, new_alarm);
                records.set(index, new_event);
                System.out.println("Record modified successfully!");
            } catch (ParseException e) {
                System.out.println("Invalid date or time format!");
                return;
            }
        } else {
            System.out.println("Invalid record type!");
            return;
        }
    }
}
