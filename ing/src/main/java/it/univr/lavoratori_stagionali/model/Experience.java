package it.univr.lavoratori_stagionali.model;

public class Experience {
    // Campi che definiscono una esperienza
    private int id;
    private String company;
    private String startDate;
    private String endDate;
    private String task;
    private String wage;
    private String place;

    // Costruttore blank
    public Experience(){
        super();
    }
    // Costruttore con parametri
    public Experience(int id, String company, String startDate, String endDate, String task, String wage, String place) {
        this.id = id;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.task = task;
        this.wage = wage;
        this.place = place;
    }

    // Metodi GET
    public String getWage() {
        return wage;
    }
    public String getPlace() {
        return place;
    }
    public String getCompany() {
        return company;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public String getTask() {
        return task;
    }
    public int getId() {
        return id;
    }

    // Metodi SET
    public void setWage(String wage) {
        this.wage = wage;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return id + "," + company  + "," + startDate  + "," + endDate  + "," + task  + "," + wage  + "," + place + "\n";
    }
}
