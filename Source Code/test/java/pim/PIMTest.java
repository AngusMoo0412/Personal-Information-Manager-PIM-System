import src.main.java.pim.PIM;

import src.main.java.pim.Commands.*;
import src.main.java.pim.Records.Event;
import src.main.java.pim.Records.Record;
import src.main.java.pim.Records.*;


import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import org.junit.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PIMTest {
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @Test
    public void testAddTask() {
        systemInMock.provideLines("1","Task1", "12/12/2023", "Y");
        ArrayList<Record> records = new ArrayList<>();
        AddRecord addRecord = new AddRecord(records);
        addRecord.execute(); 
        assertEquals(1, records.size());
        assertTrue(records.get(0) instanceof Task);
    }

    @Test
    public void testAddNote() {
        systemInMock.provideLines("2","notes", "Y");
        ArrayList<Record> records = new ArrayList<>();
        AddRecord addRecord = new AddRecord(records);
        addRecord.execute(); 
        assertEquals(1, records.size());
        assertTrue(records.get(0) instanceof Note);
    }

    @Test
    public void testAddContact() {
        systemInMock.provideLines("3","Chan","Tai Man","21800000", "Y");
        ArrayList<Record> records = new ArrayList<>();
        AddRecord addRecord = new AddRecord(records);
        addRecord.execute(); 
        assertEquals(1, records.size());
        assertTrue(records.get(0) instanceof Contact);
    }    

    @Test
    public void testAddEvent() {
        systemInMock.provideLines("4","Event1","15/12/2023","23:00","22:00", "Y");
        ArrayList<Record> records = new ArrayList<>();
        AddRecord addRecord = new AddRecord(records);
        addRecord.execute(); 
        assertEquals(1, records.size());
        assertTrue(records.get(0) instanceof Event);
    }  

    @Test
    public void testModifyTask() {
        systemInMock.provideLines("1","Task1", "12/12/2023", "Y");
        ArrayList<Record> records = new ArrayList<>();
        AddRecord addRecord = new AddRecord(records);
        addRecord.execute(); 
        systemInMock.provideLines("0","Task2", "13/12/2023", "Y");
        ModifyRecord modifyRecord = new ModifyRecord(records);
        modifyRecord.execute(); 
        assertEquals(1, records.size());
        assertTrue(records.get(0) instanceof Task);
    }

    @Test
    public void testModifyNote() {
        systemInMock.provideLines("2","notes", "Y");
        ArrayList<Record> records = new ArrayList<>();
        AddRecord addRecord = new AddRecord(records);
        addRecord.execute(); 
        systemInMock.provideLines("0","notes2", "Y");
        ModifyRecord modifyRecord = new ModifyRecord(records);
        modifyRecord.execute(); 
        assertEquals(1, records.size());
        assertTrue(records.get(0) instanceof Note);
    }

    @Test
    public void testModifyContact() {
        systemInMock.provideLines("3","Chan","Tai Man","21800000", "Y");
        ArrayList<Record> records = new ArrayList<>();
        AddRecord addRecord = new AddRecord(records);
        addRecord.execute(); 
        systemInMock.provideLines("0","Chen","Tai","21900000", "Y");
        ModifyRecord modifyRecord = new ModifyRecord(records);
        modifyRecord.execute(); 
        assertEquals(1, records.size());
        assertTrue(records.get(0) instanceof Contact);
    }

    @Test
    public void testModifyEvent() {
        systemInMock.provideLines("4","Event1","15/12/2023","23:00","22:00", "Y");
        ArrayList<Record> records = new ArrayList<>();
        AddRecord addRecord = new AddRecord(records);
        addRecord.execute();  
        systemInMock.provideLines("0","Event2","17/12/2023","23:30","22:30", "Y");
        ModifyRecord modifyRecord = new ModifyRecord(records);
        modifyRecord.execute(); 
        assertEquals(1, records.size());
        assertTrue(records.get(0) instanceof Event);
    }

    @Test
    public void testDeleteTask() {
        systemInMock.provideLines("1","Task1", "12/12/2023", "Y");
        ArrayList<Record> records = new ArrayList<>();
        AddRecord addRecord = new AddRecord(records);
        addRecord.execute(); 
        systemInMock.provideLines("0", "Y");
        DeleteRecord deleteRecord = new DeleteRecord(records);
        deleteRecord.execute(); 
        assertEquals(0, records.size());
    }

    @Test
    public void testDeleteNote() {
        systemInMock.provideLines("2","notes", "Y");
        ArrayList<Record> records = new ArrayList<>();
        AddRecord addRecord = new AddRecord(records);
        addRecord.execute(); 
        systemInMock.provideLines("0", "Y");
        DeleteRecord deleteRecord = new DeleteRecord(records);
        deleteRecord.execute(); 
        assertEquals(0, records.size());
    }

    @Test
    public void testDeleteContact() {
        systemInMock.provideLines("3","Chan","Tai Man","21800000", "Y");
        ArrayList<Record> records = new ArrayList<>();
        AddRecord addRecord = new AddRecord(records);
        addRecord.execute(); 
        systemInMock.provideLines("0", "Y");
        DeleteRecord deleteRecord = new DeleteRecord(records);
        deleteRecord.execute(); 
        assertEquals(0, records.size());
    }

    @Test
    public void testDeleteEvent() {
        systemInMock.provideLines("4","Event1","15/12/2023","23:00","22:00", "Y");
        ArrayList<Record> records = new ArrayList<>();
        AddRecord addRecord = new AddRecord(records);
        addRecord.execute();  
        systemInMock.provideLines("0", "Y");
        DeleteRecord deleteRecord = new DeleteRecord(records);
        deleteRecord.execute(); 
        assertEquals(0, records.size());
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testPrintTask() {
        systemInMock.provideLines("1","Task1", "12/12/2023", "Y");
        ArrayList<Record> records = new ArrayList<>();
        AddRecord addRecord = new AddRecord(records);
        addRecord.execute(); 
        systemInMock.provideLines("0");
        PrintRecord printRecord = new PrintRecord(records);
        printRecord.execute(); 
        assertEquals("Task: Task {Description :'Task1', Date :Sun Jan 01 00:00:00 CST 2023}", "Task: " + records.get(0).toString());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
    
    @Test
    public void testExportFile(){
        systemInMock.provideLines("1","Task1", "12/12/2023", "Y");
        ArrayList<Record> records = new ArrayList<>();
        AddRecord addRecord = new AddRecord(records);
        addRecord.execute(); 
        systemInMock.provideLines("testfile");
        ExportFile ef = new ExportFile(records);
        ef.execute(); 
    }
    
    @Test
    public void testImportFile(){
        ArrayList<Record> records = new ArrayList<>(); 
        systemInMock.provideLines("testfile");
        ImportFile ef = new ImportFile(records);
        ef.execute(); 
    }
}
