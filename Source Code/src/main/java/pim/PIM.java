package src.main.java.pim;

import java.util.*;

import src.main.java.pim.Records.Record;
import src.main.java.pim.Commands.*;


// Main class to run the PIM program.
public class PIM {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        ArrayList<Record> records = new ArrayList<Record>();

        while (true) {
            
            System.out.println("=============================================");
            System.out.println("Personal Information Management System (PIM) ");
            System.out.println("=============================================");
            System.out.println("Please Enter Command:[a][b][c][d][e][f][g][h]");
            System.out.println("| a = add record      | b = modify record   |");
            System.out.println("| c = search record   | d = print record    |");
            System.out.println("| e = delete record   | f = export file     |");
            System.out.println("| g = import file     | h = exit            |");
            System.out.println("=============================================");
            System.out.print("Command: ");

            String command = sc.nextLine();
            Controller cmd;

            switch (command) {
                case "a":
                    cmd = new AddRecord(records);
                    cmd.execute();
                    break;
                case "b":
                    cmd = new ModifyRecord(records);
                    cmd.execute();
                    break;
                case "c":
                    cmd = new SearchRecord(records);
                    cmd.execute();
                    break;
                case "d":
                    cmd = new PrintRecord(records);
                    cmd.execute();
                    break;
                case "e":
                    cmd = new DeleteRecord(records);
                    cmd.execute();
                    break;
                case "f":
                    cmd = new ExportFile(records);
                    cmd.execute();
                    break;
                case "g":
                    records = new ImportFile(records).impFile();
                    break;
                case "h":
                    System.out.println("Exit PIM System");
                    System.exit(0);
                default:
                    System.out.println("Unknown Command");
            }
        }
    }
}
