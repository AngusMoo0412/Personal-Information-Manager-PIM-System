package src.main.java.pim.Records;

import java.util.Date;

public class Task extends Record {

    private String description;
    private Date date;

    private static final long serialVersionUID = 3L;

    public Task(String description, Date date) {
        this.description = description;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task {" +
                "Description :'" + description + '\'' +
                ", Date :" + date +
                '}';
    }
}