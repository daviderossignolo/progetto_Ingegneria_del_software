package it.univr.lavoratori_stagionali.model;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Modello {
    // Lista dei lavoratori sui cui sto lavorando
    private static ArrayList<Worker> workers;

    // Utente
    //private static User user;

    // istanza
    private static final Modello instance = null;

    // Richiami ai file di dati
    static String workersDb = "src/main/java/it/univr/lavoratori_stagionali/data/workers.csv";
    static String experienceDb = "src/main/java/it/univr/lavoratori_stagionali/data/experiences.csv";
    static String availabilitiesDb = "src/main/java/it/univr/lavoratori_stagionali/data/availabilities.csv";
    static String emergencyDb = "src/main/java/it/univr/lavoratori_stagionali/data/emergency.csv";

    // Creo il modello
    private Modello() {
        // recupero i lavoratori
        workers = getLavoratori();

        // per ogni lavoratore aggiungo i dati
        for (Worker l : workers) {
            l.setExperiences(getEsperienze(l));
            l.setLanguages(l.getLanguages());
            l.setPeriods(getDisponibilita(l));
            l.setContacts(getContattoEmergenza(l));
        }
    }

    // metodo getInstance
    public static Modello getInstance() {
        if (instance == null) {
            return new Modello();
        }
        return instance;
    }

    // Metodo get per recuperare elenco lavoratori
    public ArrayList<Worker> getElencoLavoratori(){
        return workers;
    }

    // metodo per creare i lavoratori leggendo dal file
    private static ArrayList<Worker> getLavoratori() {
        ArrayList<Worker> lavoratori = new ArrayList<>();
        List<String> lines = Collections.emptyList();

        // leggo dal file tutte le linee
        try {
            lines = Files.readAllLines(Paths.get(workersDb), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // tolgo la linea header del file csv
        lines.remove(0);

        // per ogni linea creo un nuovo lavoratore
        for (String l : lines) {
            // elimino le doppie virolette
            String newStr = l.replace("\"", "");

            // recupero tutti i parametri
            String [] parameters = newStr.split(",");

            // Creo lavoratore vuoto
            Worker lavoratore = new Worker();
            ArrayList<Experience> exp = new ArrayList<>();
            ArrayList<Availabilities> av = new ArrayList<>();
            ArrayList<EmergencyInfo> cont = new ArrayList<>();

            // Aggiungo i dati
            if(parameters[0].equals(""))
                lavoratore.setId(0);
            else{
                lavoratore.setId(Integer.parseInt(parameters[0]));
                lavoratore.setName(parameters[1]);
                lavoratore.setSurname(parameters[2]);
                lavoratore.setBirthday(parameters[3]);
                lavoratore.setBirthplace(parameters[4]);
                lavoratore.setAddress(parameters[5]);
                lavoratore.setPhone(parameters[6]);
                lavoratore.setNationality(parameters[7]);
                lavoratore.setEmail(parameters[8]);
                lavoratore.setLanguages(parameters[9]);
                lavoratore.setLicences(parameters[10]);
                if(parameters[11].equals(""))
                    lavoratore.setCar(false);
                else
                    lavoratore.setCar(parameters[11].equals("si"));
                lavoratore.setContacts(cont);
                lavoratore.setPeriods(av);
                lavoratore.setExperiences(exp);
                lavoratori.add(lavoratore);
            }
        }

        return lavoratori;
    }

    // Recupero le esperienze da ogni lavoratore
    private static ArrayList<Experience> getEsperienze(Worker lavoratore) {
        ArrayList<Experience> esperienze = new ArrayList<>();
        List<String> lines = Collections.emptyList();

        // leggo dal file
        try {
            lines = Files.readAllLines(Paths.get(experienceDb), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String l : lines) {
            // recupero l'id
            String [] parameters = l.split(",");

            // controllo se id esperienza e id worker corrispondono
            if (String.valueOf(lavoratore.getId()).equals(parameters[0])) {
                // creo l'esperienza
                esperienze.add(new Experience(Integer.parseInt(parameters[0]), parameters[1], parameters[2], parameters[3], parameters[4], parameters[5], parameters[6]));
            }
        }
        return esperienze;

    }

    // recupero le disponibilità
    private static ArrayList<Availabilities> getDisponibilita(Worker lavoratore) {
        ArrayList<Availabilities> disponibilita = new ArrayList<>();
        List<String> lines = Collections.emptyList();

        // leggo dal file tutte le disponibilità
        try {
            lines = Files.readAllLines(Paths.get(availabilitiesDb), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String l : lines) {
            String [] parameters = l.split(",");

            // controllo id disponibilità e id worker
            if (String.valueOf(lavoratore.getId()).equals(parameters[0])) {
                // creo la nuova disponibilità
                disponibilita.add(new Availabilities(Integer.parseInt(parameters[0]), parameters[1], parameters[2], parameters[3]));
            }
        }

        return disponibilita;
    }

    // recupero i contatti di emergenza
    private static ArrayList<EmergencyInfo> getContattoEmergenza(Worker lavoratore) {
        ArrayList<EmergencyInfo> contatti = new ArrayList<>();
        List<String> lines = Collections.emptyList();

        // leggo tutte le linee dal file
        try {
            lines = Files.readAllLines(Paths.get(emergencyDb), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String l : lines) {
            String [] parameters = l.split(",");
            // controllo se id corrispondono
            if (String.valueOf(lavoratore.getId()).equals(parameters[0])) {
                contatti.add(new EmergencyInfo(Integer.parseInt(parameters[0]), parameters[1],parameters[2],parameters[3],parameters[4]));
            }

        }

        return contatti;
    }

    // cancellazione del lavoratore
    public void cancelLavoratore(Worker lavoratore){
        // rimuovo il lavoratore
        workers.removeIf(l -> l.getId() == lavoratore.getId());

        // leggo il file dei lavoratori
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(workersDb), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> toWrite = new ArrayList<>();

        // cancello da file dei lavoratori
        for (String l : lines) {
            String [] parameters = l.split(",");
            if (!parameters[0].equals(String.valueOf(lavoratore.getId()))) {
                toWrite.add(l);
            }
        }

        // riscrivo tutti i lavoratori corretti nel file
        try (Writer writer = new BufferedWriter(new FileWriter(workersDb,false))) {
            for (String l : toWrite) {
                writer.write(l + "\n");
            }
        } catch (IOException e) {
            System.out.println("Errore");
        }

// cancello da dbContattiEmergenza
        lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(emergencyDb), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        toWrite = new ArrayList<>();

        // salvo i contatti che non sono da eliminare
        for (String l : lines) {
            String [] parameters = l.split(",");
            if (!parameters[0].equals(String.valueOf(lavoratore.getId()))) {
                toWrite.add(l);
            }
        }

        // riscrivo tutte le esperienze non legate al lavoratore
        try (Writer writer = new BufferedWriter(new FileWriter(emergencyDb,false))) {
            for (String l : toWrite) {
                writer.write(l + "\n");
            }
        } catch (IOException e) {
            System.out.println("Errore");
        }

        // leggo il file delle disponiblità
        try {
            lines = Files.readAllLines(Paths.get(availabilitiesDb), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        toWrite.clear();
        // salvo le disponiblità che non devo eliminare
        for (String l : lines) {
            String [] parameters = l.split(",");
            if (!parameters[0].equals(String.valueOf(lavoratore.getId()))) {
                toWrite.add(l);
            }
        }

        // scrivo le disponibilità che non ho eliminato
        try (Writer writer = new BufferedWriter(new FileWriter(availabilitiesDb,false))) {
            for (String l : toWrite) {
                writer.write(l + "\n");
            }
        } catch (IOException e) {
            System.out.println("Errore");
        }

        // leggo il file delle esperienze
        try {
            lines = Files.readAllLines(Paths.get(experienceDb), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        toWrite.clear();
        // salvo le esperienze che non devo eliminare
        for (String l : lines) {
            String [] parameters = l.split(",");
            if (!parameters[0].equals(String.valueOf(lavoratore.getId()))) {
                toWrite.add(l);
            }
        }
        // riscrivo sul file
        try (Writer writer = new BufferedWriter(new FileWriter(experienceDb,false))) {
            for (String l : toWrite) {
                writer.write(l + "\n");
            }
        } catch (IOException e) {
            System.out.println("Errore");
        }

    }

    // modifica del lavoratore
    public void editLavoratore (Worker lavoratore, Worker old) {
        if (old != null) {
            try{
                for (Worker l : this.getElencoLavoratori()) {
                    if (l.getId() == old.getId()) {
                        workers.remove(l);
                        cancelLavoratore(l);
                        lavoratore.setContacts(l.getContacts());
                        lavoratore.setPeriods(l.getPeriods());
                        lavoratore.setExperiences(l.getExperiences());
                    }
                }
            } catch (ConcurrentModificationException ignored) {}
            workers.add(lavoratore);
        }

        try (Writer writer = new BufferedWriter(new FileWriter(workersDb))) {
            writer.write("Id,name,surname,birthday,birthplace,address,phone,nationality,email,languages,licences,car\n");
            for(Worker w : workers)
                writer.write(w.toString());
        } catch (IOException e) {
            System.out.println("Errore interno al sistema");
        }

        try (Writer writer = new BufferedWriter(new FileWriter(emergencyDb, true))) {
            //writer.write("Id,name,surname,birthday,birthplace,address,phone,nationality,email,languages,licences,car\n");
            for(EmergencyInfo i : lavoratore.getContacts())
                writer.write(i.toString());
        } catch (IOException e) {
            System.out.println("Errore interno al sistema");
        }

        try (Writer writer = new BufferedWriter(new FileWriter(availabilitiesDb, true))) {
            //writer.write("Id,name,surname,birthday,birthplace,address,phone,nationality,email,languages,licences,car\n");
            for(Availabilities av : lavoratore.getPeriods())
                writer.write(av.toString());
        } catch (IOException e) {
            System.out.println("Errore interno al sistema");
        }

        try (Writer writer = new BufferedWriter(new FileWriter(experienceDb, true))) {
            //writer.write("Id,name,surname,birthday,birthplace,address,phone,nationality,email,languages,licences,car\n");
            for(Experience exp : lavoratore.getExperiences())
                writer.write(exp.toString());
        } catch (IOException e) {
            System.out.println("Errore interno al sistema");
        }
    }

    // eliminazione di una esperienza dall'elenco
    public void deleteEsperienza (Experience exp) {
        // leggo dal file
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(experienceDb), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> toWrite = new ArrayList<>();
        for (String l : lines) {
            String [] parameters = l.split(",");

        // aggiungo tutte le esperienze che non vanno eliminate
            if ( !(parameters[2].equals(exp.getStartDate()) ) && !(parameters[3].equals(exp.getEndDate()))) {
                toWrite.add(l);
            }
        }

        //Salva su file
        try (Writer writer = new BufferedWriter(new FileWriter(experienceDb,false))) {
            for (String l : toWrite) {
                writer.write(l + "\n");
            }
        } catch (IOException e) {
            System.out.println("Errore");
        }
    }

    // Eliminazione di una disponibilità
    public void deleteAvailabilities (Availabilities av) {
        // leggo dal file
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(availabilitiesDb), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> toWrite = new ArrayList<>();
        for (String l : lines) {
            String [] parameters = l.split(",");

            // aggiungo tutti i periodi che non vanno eliminati
            if ( !((parameters[0].equals(Integer.toString(av.getId())) && (parameters[1].equals(av.getStartDate())) && (parameters[2].equals(av.getEndDate()) && (parameters[3].equals(av.getComuni())))))) {
                toWrite.add(l);
            }
        }

        //Salva su file
        try (Writer writer = new BufferedWriter(new FileWriter(availabilitiesDb,false))) {
            for (String l : toWrite) {
                writer.write(l + "\n");
            }
        } catch (IOException e) {
            System.out.println("Errore interno al sistema");
        }
    }

    // Eliminazione di un contatto di emergenza
    public void deleteContact (EmergencyInfo contact) {
        // leggo dal file
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(emergencyDb), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> toWrite = new ArrayList<>();

        // elimino tutti i periodi che non vanno eliminati
        for (String l : lines) {
            String [] parameters = l.split(",");
            if ((!contact.getPhone().equals(parameters[3])) && (!contact.getEmail().equals(parameters[4]))) {
                toWrite.add(l);
            }
        }

        //Salva su file
        try (Writer writer = new BufferedWriter(new FileWriter(emergencyDb,false))) {
            for (String l : toWrite) {
                writer.write(l + "\n");
            }
        } catch (IOException e) {
            System.out.println("Errore interno al sistema");
        }
    }

    // aggiunta del lavoratore alla lista
    public void addLavoratore(Worker l) {
        // aggiungo un lavoratore all'elenco
        workers.add(l);

        //Salva su file
        try (Writer writer = new BufferedWriter(new FileWriter(workersDb,true))) {
            writer.write(l.toString());
        } catch (IOException e) {
            System.out.println("Errore");
        }

        for (Experience esp : l.getExperiences()) {
            try (Writer writer = new BufferedWriter(new FileWriter(experienceDb, true))) {
                writer.write(esp.toString());
            } catch (IOException e) {
                System.out.println("Errore interno al sistema");
            }
        }

        for (Availabilities d : l.getPeriods()) {
            try (Writer writer = new BufferedWriter(new FileWriter(availabilitiesDb, true))) {
                writer.write(d.toString());
            } catch (IOException e) {
                System.out.println("Errore interno al sistema");
            }
        }

        for (EmergencyInfo c : l.getContacts()) {
            try (Writer writer = new BufferedWriter(new FileWriter(emergencyDb, true))) {
                writer.write(c.toString());
            } catch (IOException e) {
                System.out.println("Errore interno al sistema");
            }
        }

    }

    // edit Esperienza
    public void editEsperienza (Worker lavoratore, Experience exp, Experience old) {
        ArrayList<Experience> newExp = new ArrayList<>();
        if (old != null) {
            try{
                for (Experience e : getEsperienze(lavoratore)) {

                    // elimino la vechia esperienza
                    if ((e.getId() == old.getId()) && (e.getStartDate().equals(old.getStartDate()) || e.getEndDate().equals(old.getEndDate()))) {
                        deleteEsperienza(e);
                    }
                }
            } catch (ConcurrentModificationException ignored) {}

            // setto le nuove esperienze al lavoratore
            newExp.add(exp);
            lavoratore.setExperiences(newExp);
        }

        // salvataggio su file
        try (Writer writer = new BufferedWriter(new FileWriter(experienceDb,true))) {
            //writer.write("ID,company,start,end,task,wage,place\n");
            for(Experience e : lavoratore.getExperiences())
                writer.write(e.toString());
        } catch (IOException e) {
            System.out.println("Errore");
        }
    }

    // modifica di un contatto di emergenza
    public void editContact(Worker lavoratore, EmergencyInfo contact, EmergencyInfo old){
        ArrayList<EmergencyInfo> newContact = new ArrayList<>();
        if (old != null) {
            try{
                for (EmergencyInfo c : getContattoEmergenza(lavoratore)) {
                    // elimino il vecchio contatto di emergenza
                    if ( (c.getId() == old.getId()) && (c.getPhone().equals(old.getPhone()))) {
                        deleteContact(c);
                    }
                }
            } catch (ConcurrentModificationException ignored) {}

            // aggiungo i nuovi contatti
            //newContact = lavoratore.getContacts();
            newContact.add(contact);
            lavoratore.setContacts(newContact);
        }

        try (Writer writer = new BufferedWriter(new FileWriter(emergencyDb, true))) {
            //writer.write("ID,name,surname,phone,email\n");
            for(EmergencyInfo c : lavoratore.getContacts())
                writer.write(c.toString());
        } catch (IOException e) {
            System.out.println("Errore");
        }
    }

    // modifica di un periodo di disponibilità
    public void editPeriod(Worker lavoratore, Availabilities period, Availabilities old){
        ArrayList<Availabilities> newAv = new ArrayList<>();
        if (old != null) {
            try{
                for (Availabilities av : getDisponibilita(lavoratore)) {
                    // elimino vecchia disponibilità
                    if ((av.getId() == old.getId()) && (av.getStartDate().equals(old.getStartDate())) && (av.getEndDate().equals(old.getEndDate()))) {
                        deleteAvailabilities(av);
                    }
                }
            } catch (ConcurrentModificationException ignored) {}

            // aggiungo i nuovi periodi
            newAv.add(period);
            lavoratore.setPeriods(newAv);
        }

        try (Writer writer = new BufferedWriter(new FileWriter(availabilitiesDb, true))) {
            //writer.write("ID,start,end,place\n");
            for(Availabilities av : lavoratore.getPeriods())
                writer.write(av.toString());
        } catch (IOException e) {
            System.out.println("Errore");
        }
    }

}
