package src.main.java.pim.Commands;

import java.util.*;

import src.main.java.pim.Records.*;
import src.main.java.pim.Records.Record;

import java.text.*;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class AddRecord implements Controller {

    protected ArrayList<Record> records;
    private Scanner sc = new Scanner(System.in);

    public AddRecord(ArrayList<Record> records) {
        this.records = records;
    }

    public void execute() {
        try {
                Scanner sc = new Scanner(System.in);
                System.out.println("=============================================");
                System.out.println("========== PIM System - Add Record ==========");
                System.out.println("=============================================");
                System.out.println("Enter the number of type you want to add:    ");
                System.out.println("| 1. Add a new task record                  |");
                System.out.println("| 2. Add a new note record                  |");
                System.out.println("| 3. Add a new contact record               |");
                System.out.println("| 4. Add a new event record                 |");
                System.out.println("| 5. Back to main menu                      |");
                System.out.println("=============================================");

                if (sc.hasNextInt()) {
                    int choice = sc.nextInt();
                    sc.nextLine();

                    Record CreateRecord;
                    switch (choice) {
                        case 1:
                            CreateRecord = addTask();
                            break;
                        case 2:
                            CreateRecord = addNote();
                            break;
                        case 3:
                            CreateRecord = addContact();
                            break;
                        case 4:
                            CreateRecord = addEvent();
                            break;
                        case 5:
                            return;
                        default:
                            throw new IllegalStateException("Unknown Value: " + choice);
                    }
                    // If return null do not add to records
                    if (CreateRecord != null) {
                        records.add(CreateRecord);
                        System.out.println("Record added successfully!");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input. Please enter a valid integer.");
                }
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
        }

    }

    // Add Task Part
    public Record addTask() {

        String description;
        Date date;

        do {

            try {

                System.out.println("Enter task description:");
                description = sc.nextLine();

                System.out.println("Enter task date (MM/DD/YYYY):");
                String dateStr = sc.nextLine();

                SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
                date = sdf.parse(dateStr);
                System.out.println("=============================================");
                System.out.println("Save Task? (Y/N) or Exit Add Task (E)");
                System.out.println("=============================================");
                String choice = sc.nextLine();

                if (choice.equals("Y")) {
                    return new Task(description, date);
                } else if (choice.equals("N")) {
                    continue;
                } else if (choice.equals("E")) {
                    return null;
                } else {
                    System.out.println("=============================================");
                    System.out.println("Unknown Command");
                    System.out.println("=============================================");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (true);

    }

    // Add Note Part
    public Record addNote() {
        String note = "";

        while (true) {

            note = getNoteInput(note);
            String confirm = getNoteConfirmation();
            if (confirm.equals("Y")) {
                return new Note(note);
            } else if (confirm.equals("N")) {
                continue;
            } else if (confirm.equals("E")) {
                return null;
            } else {
                System.out.println("=============================================");
                System.out.println("Unknown Command");
                System.out.println("=============================================");
            }
        }
    }

    private String getNoteInput(String note) {
        if (note.isEmpty()) {
            System.out.println("=============================================");
            System.out.println("Enter note:");
        } else {
            System.out.println("=============================================");
            System.out.println("Previous note:");
            System.out.println(note);
            System.out.println("=============================================");
        }
        note = sc.nextLine();
        // validation
        return note;
    }

    private String getNoteConfirmation() {
        System.out.println("=============================================");
        System.out.println("Save note? (Y/N) or Exit Add Note (E)");
        System.out.println("=============================================");
        return sc.nextLine();
    }

    // Add Contact Part
    public Record addContact() {
        String firstName;
        String lastName;
        String phoneNumber;

        do {

            try {

                System.out.println("Enter contact first name:");
                firstName = sc.nextLine();

                System.out.println("Enter contact last name:");
                lastName = sc.nextLine();

                System.out.println("Enter contact phone number:");
                phoneNumber = sc.nextLine();

                // validation
                System.out.println("=============================================");
                System.out.println("Contact Information:");
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Phone Number: " + phoneNumber);
                System.out.println("=============================================");
                System.out.println("Save Contact? (Y/N) or Exit Add Contact (E)");
                System.out.println("=============================================");
                String choice = sc.nextLine();

                if (choice.equals("Y")) {
                    return new Contact(firstName, lastName, phoneNumber);
                } else if (choice.equals("N")) {
                    continue;
                } else if (choice.equals("E")) {
                    return null;
                } else {
                    System.out.println("=============================================");
                    System.out.println("Unknown Command");
                    System.out.println("=============================================");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (true);

    }

    // Add Event Part
    public Record addEvent() {
        String description;
        Date date;
        LocalTime time;
        LocalTime alarm;

        do {
            try {
                System.out.println("Enter event description:");
                description = sc.nextLine();

                System.out.println("Enter event date (MM/DD/YYYY):");
                String dateStr = sc.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
                try {
                    date = dateFormat.parse(dateStr);
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter the date in MM/DD/YYYY format.");
                    continue;
                }

                do {
                    System.out.println("Enter event time (HH:MM):");
                    String timeStr = sc.nextLine();
                    time = LocalTime.parse(timeStr);

                    System.out.println("Enter event alarm (HH:MM):");
                    String alarmStr = sc.nextLine();
                    alarm = LocalTime.parse(alarmStr);

                    try {
                        alarm = LocalTime.parse(alarmStr);
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid time format, use HH:MM");
                        continue;
                    }

                    if (alarm.isAfter(time)) {
                        System.out.println("Alarm time cannot be after event time");
                    } else {
                        break;
                    }

                } while (true);

                // validation
                System.out.println("=============================================");
                System.out.println("Event Information:");
                System.out.println("Description: " + description);
                // Date only shows the date, not the time
                ////// BUG already Fixed //////
                // date = dateFormat.parse(dateStr);
                System.out.println("Date: " + dateStr);
                System.out.println("Time: " + time);
                System.out.println("Alarm: " + alarm);
                System.out.println("=============================================");
                System.out.println("Save Event? (Y/N) or Exit Add Event (E)");
                System.out.println("=============================================");
                String choice = sc.nextLine();

                if (choice.equals("Y")) {
                    return new Event(description, date, time, alarm);
                } else if (choice.equals("N")) {
                    continue;
                } else if (choice.equals("E")) {
                    return null;
                } else {
                    System.out.println("=============================================");
                    System.out.println("Unknown Command");
                    System.out.println("=============================================");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (true);
    }

}
