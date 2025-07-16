package src.main.java.pim.Commands;

import java.util.ArrayList;
import java.util.Scanner;

import src.main.java.pim.Records.Record;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class ImportFile implements Controller{
    protected ArrayList<Record> records;
    private Scanner sc = new Scanner(System.in);

    public ImportFile(ArrayList<Record> records) {
        this.records = records;
    }

    public void execute() {
        System.out.println("=============================================");
        System.out.println("======== PIM System - Import File ===========");
        System.out.println("=============================================");
        System.out.println("Enter File Name");
        String name = sc.nextLine();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(name))) {
            @SuppressWarnings("unchecked")
            ArrayList<Record> tempRecords = (ArrayList<Record>) in.readObject();
            records = tempRecords;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Record> impFile() {
        System.out.println("=============================================");
        System.out.println("======== PIM System - Import File ===========");
        System.out.println("=============================================");
        System.out.println("Enter File Name");
        String name = sc.nextLine();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(name))) {
            @SuppressWarnings("unchecked")
            ArrayList<Record> tempRecords = (ArrayList<Record>) in.readObject();
            records = tempRecords;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return records;
    }
}
