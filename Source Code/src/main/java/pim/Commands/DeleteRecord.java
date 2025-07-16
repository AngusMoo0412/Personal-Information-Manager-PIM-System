package src.main.java.pim.Commands;

import java.util.*;

import src.main.java.pim.Records.Record; 

public class DeleteRecord implements Controller {

    protected ArrayList<Record> records;
    private Scanner sc = new Scanner(System.in);

    public DeleteRecord(ArrayList<Record> records) {
        this.records = records;
    }

    public void execute() {

        System.out.println("=============================================");
        System.out.println("======== PIM System - Delete Record =========");
        System.out.println("=============================================");
        for (int i = 0; i < records.size(); i++) {
            System.out.println("[" + i + "] " + records.get(i).toString());
        }
        System.out.println("=============================================");
        System.out.println("Please enter index of record want to delete: ");
        System.out.println("=============================================");
        int index = sc.nextInt();

        if (index < 0 || index >= records.size()) {
            System.out.println("Invalid index!");
            return;
        } else {
            System.out.println("=============================================");
            System.out.println("Are you sure you want to delete this record?");
            System.out.println("=============================================");
            System.out.println(records.get(index).toString());
            System.out.println("=============================================");
            System.out.println("Please enter [Y] to confirm, [N] to cancel: ");
            System.out.println("=============================================");
            String confirm = sc.next();
            if (confirm.equals("N")) {
                System.out.println("Delete canceled!");
                return;
            } else if (!confirm.equals("Y")) {
                System.out.println("Invalid input!");
                return;
            } else {
                records.remove(index);
                System.out.println("Record deleted successfully!");
            }
        }
    }
}
