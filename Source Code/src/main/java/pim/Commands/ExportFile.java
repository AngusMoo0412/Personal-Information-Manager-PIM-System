package src.main.java.pim.Commands;

import java.util.ArrayList;
import java.util.Scanner;

import src.main.java.pim.Records.Record;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class ExportFile implements Controller{
    protected ArrayList<Record> records;
    private Scanner sc = new Scanner(System.in);

    public ExportFile(ArrayList<Record> records) {
        this.records = records;
    }

    public void execute() {
        System.out.println("=============================================");
        System.out.println("======== PIM System - Export File ===========");
        System.out.println("=============================================");
        System.out.println("Enter File Name");
        String name = sc.nextLine();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(name+".pim"))) {
            out.writeObject(records);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }          
}
