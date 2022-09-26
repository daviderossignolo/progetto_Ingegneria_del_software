package it.univr.lavoratori_stagionali.controllers;

import it.univr.lavoratori_stagionali.model.Experience;
import it.univr.lavoratori_stagionali.model.Modello;
import it.univr.lavoratori_stagionali.model.Worker;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class searchController {
    @FXML private Button search;
    @FXML private TextField home;
    @FXML private TextField name;
    @FXML private TextField surname;
    @FXML private DatePicker start;
    @FXML private DatePicker end;
    @FXML private TextField languages;
    @FXML private ComboBox car;
    @FXML private RadioButton or;
    @FXML private RadioButton and;
    @FXML private Pane mainPane;
    @FXML private AnchorPane anchorPane;
    @FXML private GridPane gridPane;
    @FXML private CheckBox amBox;
    @FXML private CheckBox a1Box;
    @FXML private CheckBox a2Box;
    @FXML private CheckBox aBox;
    @FXML private CheckBox c1Box;
    @FXML private CheckBox cBox;
    @FXML private CheckBox ceBox;
    @FXML private CheckBox b1Box;
    @FXML private CheckBox bBox;
    @FXML private CheckBox beBox;
    @FXML private CheckBox dBox;
    @FXML private CheckBox d1Box;
    @FXML private CheckBox deBox;
    @FXML private RadioButton yes;
    @FXML private RadioButton no;

    @FXML private TextArea tasks;

    //variabili per il cambio View
    private Stage stage;
    private Scene scene;
    private Parent root;

    //Istanza del modello / ArrayList per scorrere tutti i lavoratori / ArrayList per i lavoratori trovati
    private Modello instance = Modello.getInstance();
    private ArrayList<Worker> listaW = new ArrayList<>();
    ArrayList<Worker> result = new ArrayList<>();

    //ritorna la lista di lavoratori cercati
    //con il pulsante AND selezionato tutti i lavoratori che presentano tutti i campi compilati nella ricerca
    //con il pulsante OR selezionato tutti i lavoratori che hanno almeno un campo tra quelli inseriti nella ricerca
    public ArrayList<Worker> showSearch(MouseEvent event) throws IOException {
        //se nessun campo è compilato la finestra si chiude
        if(emptyList(getParameters())) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
        //altrimenti proseguo
        else {
            //recupero tutti i lavoratori inseriti fino ad ora nel sistema
            listaW = instance.getElencoLavoratori();

            //se il pulsante AND è selezionato proseguo con la ricerca in AND
            if (and.isSelected()) {
                //per ogni lavoratore controllo se soddisfa i requisiti di ricerca
                for (int i = 0; i < listaW.size(); i++) {
                    //se soddisfa i requisiti lo aggiungo alla lista da ritornare al cotroller per la HomeView
                    if(containsParamAnd(listaW.get(i)) == true)
                        result.add(listaW.get(i));
                }
                //chiudo SearchView
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
            //altrimenti proseguo con la ricerca in AND
            else {
                //per ogni lavoratore controllo se soddisfa i requisiti di ricerca
                for (int i = 0; i < listaW.size(); i++) {
                    //se soddisfa i requisiti lo aggiungo alla lista da ritornare al cotroller per la HomeView
                    if(containsParamOr(listaW.get(i)) == true)
                        result.add(listaW.get(i));
                    //System.out.println(result);
                }
                //chiudo SearchView
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        }

        //in caso di errori torno null
        return null;
    }

    //controllo i campi per la ricerca AND
    public Boolean containsParamAnd(Worker w){
        //flag da tornare
        Boolean containsParam = true;

        ArrayList<String> tmp = new ArrayList<String>();
        tmp.addAll(writeLicenses());

        //controllo il nome
        if(!name.getText().trim().isEmpty() && !w.getName().equalsIgnoreCase(name.getText())) {
            containsParam = false;
        }
        //controllo il cognome
        if(!surname.getText().trim().isEmpty() && !w.getSurname().equalsIgnoreCase(surname.getText())) {
            containsParam = false;
        }

        //controllo la data di inizio disponibilità
        if(start.getValue() != null) {
            Boolean haveDate = false;
            for (int i = 0; i < w.getPeriods().size(); i++)
                if(w.getPeriods().get(i).getStartDate().equals(start.getValue().toString())) {
                    haveDate = true;
                }
            if(!haveDate)
                containsParam = false;
        }

        //controllo la data di fine disponibilità
        if(end.getValue() != null) {
            Boolean haveDate = false;
            for (int i = 0; i < w.getPeriods().size(); i++)
                if(w.getPeriods().get(i).getEndDate().equals(end.getValue().toString())) {
                    haveDate = true;
                }
            if(!haveDate)
                containsParam = false;
        }

        //controllo la residenza
        if(!home.getText().trim().isEmpty() && !w.getAddress().equalsIgnoreCase(home.getText())) {
            containsParam = false;
        }
        //controllo le lingue parlate
        if(!languages.getText().trim().isEmpty() && !w.getLanguages().toLowerCase().contains(languages.getText().toLowerCase())){
            containsParam = false;
        }

        //contrllo se automunito
        if(yes.isSelected() && !w.getCar())
            containsParam = false;

        //controllo se non automunito
        if(no.isSelected() && w.getCar())
            containsParam = false;

        //controllo se ha tutte le patenti selezionate
        String[] test = stringLicenses().split(" ");
        Boolean haveAll = true;
        for(int i = 0; i < test.length; i++) {
            if (!tmp.isEmpty() && !w.getLicences().contains(test[i]))
                haveAll = false;
        }
        if(!haveAll)
            containsParam = false;

        //controllo le mansioni
        if(!tasks.getText().trim().isEmpty()) {
            Boolean havetasks = false;
            for (int i = 0; i < w.getExperiences().size(); i++) {
                if (w.getExperiences().get(i).getTask().toLowerCase().contains(tasks.getText().toLowerCase())) {
                    havetasks = true;
                }
            }
            if(!havetasks)
                containsParam = false;
        }
        //System.out.println(containsParam);
        return containsParam;
    }

    //controllo i campi per la ricerca OR
    public Boolean containsParamOr(Worker w){
        //controllo il nome
        ArrayList<String> tmp = new ArrayList<>();
        tmp.addAll(writeLicenses());

        if(!name.getText().trim().isEmpty() && w.getName().equalsIgnoreCase(name.getText()))
            return true;

        //controllo il cognome
        if(!surname.getText().trim().isEmpty() && w.getSurname().equalsIgnoreCase(surname.getText()))
            return true;

        //controllo la data di inizio disponibilità
        if(start.getValue() != null) {
            Boolean haveDate = false;
            for (int i = 0; i < w.getPeriods().size(); i++)
                if(w.getPeriods().get(i).getStartDate().equals(start.getValue().toString()))
                    haveDate = true;
            if(haveDate)
                return true;
        }

        //controllo la data di fine disponibilità
        if(end.getValue() != null) {
            Boolean haveDate = false;
            for (int i = 0; i < w.getPeriods().size(); i++) {
                if (w.getPeriods().get(i).getEndDate().equals(end.getValue().toString()))
                    haveDate = true;
            }
            if(haveDate)
                return true;
        }

        //controllo la residenza
        if(!home.getText().trim().isEmpty() && w.getAddress().equalsIgnoreCase(home.getText()))
            return true;

        //controllo le lingue parlate
        if(!languages.getText().trim().isEmpty() && !w.getLanguages().toLowerCase().contains(languages.getText().toLowerCase())){
            return true;
        }

        //controllo se automunito
        if(yes.isSelected() && w.getCar())
            return true;

        if(no.isSelected() && !w.getCar())
            return true;

        //controllo le patenti possedute
        for(int i = 0; i < tmp.size(); i++){
            if(!tmp.isEmpty() && w.getLicences().toLowerCase().contains(tmp.get(i).toLowerCase()))
                return true;
        }

        //controllo le mansioni
        if(!tasks.getText().trim().isEmpty()) {
            Boolean havetasks = false;
            for (int i = 0; i < w.getExperiences().size(); i++) {
                if (w.getExperiences().get(i).getTask().toLowerCase().contains(tasks.getText().toLowerCase())) {
                    havetasks = true;
                }
            }
            if(havetasks)
                return true;
        }

        return false;
    }

    //funzione che ritorna i paramentri inseriti nei campi di ricerca
    public ArrayList<String> getParameters(){
        //ArrayList di ritorno
        ArrayList<String> param = new ArrayList<>();

        ArrayList<String> tmp = new ArrayList<>();
        tmp.addAll(writeLicenses());

        if(!name.getText().trim().isEmpty())
            param.add(name.getText());

        if(!surname.getText().trim().isEmpty())
            param.add(surname.getText());

        if(start.getValue() != null)
            param.add(start.getValue().toString());

        if(end.getValue() != null)
            param.add(end.getValue().toString());

        if(!home.getText().trim().isEmpty())
            param.add(home.getText());

        if(!languages.getText().trim().isEmpty())
            param.add(languages.getText());

        if(yes.isSelected())
            param.add("si");
        if(no.isSelected())
            param.add("no");

        if(!tmp.isEmpty())
           param.add("ok");

        if(!tasks.getText().trim().isEmpty())
            param.add(tasks.getText());

        return param;
    }

    //controllo le tutti i campi della ricerca sono vuoti
    private Boolean emptyList(ArrayList<String> param){
        Boolean empty = true;
        for(int i = 0; i < param.size(); i++){
            if(!param.get(i).isEmpty())
                empty = false;
        }
        return empty;
    }

    //ritorna la stringa con tutte le patenti
    private ArrayList<String> writeLicenses(){
        ArrayList<String> res = new ArrayList<String>();
        if(amBox.isSelected())
            res.add("AM");
        if(a1Box.isSelected())
            res.add("A1");
        if(a2Box.isSelected())
            res.add("A2");
        if(aBox.isSelected())
            res.add("A3");
        if(b1Box.isSelected())
            res.add("B1");
        if(bBox.isSelected())
            res.add("B");
        if(c1Box.isSelected())
            res.add("C1");
        if(cBox.isSelected())
            res.add("C");
        if(d1Box.isSelected())
            res.add("D1");
        if(dBox.isSelected())
            res.add("D");
        if(ceBox.isSelected())
            res.add("CE");
        if(deBox.isSelected())
            res.add("DE");
        if(beBox.isSelected())
            res.add("BE");

        return res;
    }

    private String stringLicenses(){
        String res = "";
        if(amBox.isSelected())
            res += "AM ";
        if(a1Box.isSelected())
            res += "A1 ";
        if(a2Box.isSelected())
            res += "A2 ";
        if(aBox.isSelected())
            res += "A3 ";
        if(b1Box.isSelected())
            res += "B1 ";
        if(bBox.isSelected())
            res += "B ";
        if(c1Box.isSelected())
            res += "C1 ";
        if(cBox.isSelected())
            res += "C ";
        if(d1Box.isSelected())
            res += "D1 ";
        if(dBox.isSelected())
            res += "D ";
        if(ceBox.isSelected())
            res += "CE ";
        if(deBox.isSelected())
            res += "DE ";
        if(beBox.isSelected())
            res += "BE ";

        return res;
    }

}
