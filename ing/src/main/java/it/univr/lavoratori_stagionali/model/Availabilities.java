package it.univr.lavoratori_stagionali.model;

public class Availabilities {
    // campi descrittivi della classe
    private int id;
    private String startDate;
    private String endDate;
    private String comuni;

    // costruttore vuoto
    public Availabilities(){
        super();
    }

    // costruttore con parametri
    public Availabilities(int id, String startDate, String endDate, String comuni){
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.comuni = comuni;
    }

    // Metodi GET
    public String getStartDate() {
        return startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public String getComuni() {
        return comuni;
    }
    public int getId() {
        return id;
    }

    // Metodi SET
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public void setComuni(String comuni) {
        this.comuni = comuni;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return id  + "," + startDate  + "," + endDate  + "," + comuni + "\n";
    }

}
