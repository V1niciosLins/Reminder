package com.example.reminder.Fundamentals;

public class Reminder {
    private String title, dateCreated;
    private boolean pendence;
    private int reminderType;

    public Reminder(){
        super();
    }

    public Reminder(String title, boolean pendence, String dateCreated, int reminderType) {
        this.title = title;
        this.pendence = pendence;
        this.dateCreated = dateCreated;
        this.reminderType = reminderType;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean getPendence() {
        return pendence;
    }
    public void setPendence(boolean pendence) {
        this.pendence = pendence;
    }
    public String getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
    public int getReminderType() {
        return reminderType;
    }
    public void setReminderType(int reminderType) {
        this.reminderType = reminderType;
    }
}
