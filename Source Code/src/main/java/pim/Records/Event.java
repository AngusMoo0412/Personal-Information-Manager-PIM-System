package src.main.java.pim.Records;

import java.time.LocalTime;
import java.util.Date;

public class Event extends Record {
    private String description;
    private Date date;
    private LocalTime time;
    private LocalTime alarm;

    private static final long serialVersionUID = 5L;

    public Event(String description, Date date, LocalTime time, LocalTime alarm) {
        this.description = description;
        this.date = date;
        this.time = time;
        this.alarm = alarm;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public LocalTime getTime(){
        return time;
    }

    public LocalTime getAlarm(){
        return alarm;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public void setTime(LocalTime time){
        this.time = time;
    }

    public void setAlarm(LocalTime alarm){
        this.alarm = alarm;
    }

    @Override
    public String toString() {
        return "Event {" +
                "Description :'" + description + '\'' +
                ", Date :" + date +
                ", Time :" + time +
                ", Alarm :" + alarm +
                '}';
    }
}