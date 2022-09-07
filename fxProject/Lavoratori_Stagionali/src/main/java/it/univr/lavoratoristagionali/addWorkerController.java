package it.univr.lavoratoristagionali;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;



public class addWorkerController {
    @FXML private TextField address;
    @FXML private TextField birthplace;
    @FXML private DatePicker datePicker;
    @FXML private TextField email;
    @FXML private TextField languages;
    @FXML private TextField name;
    @FXML private TextField nationality;
    @FXML private TextField phone;
    @FXML private TextField surname;
    @FXML private CheckBox patenteA;
    @FXML private CheckBox patenteA1;
    @FXML private CheckBox patenteA2;
    @FXML private CheckBox patenteAM;
    @FXML private CheckBox patenteB;
    @FXML private CheckBox patenteB1;
    @FXML private CheckBox patenteBE;
    @FXML private CheckBox patenteC;
    @FXML private CheckBox patenteC1;
    @FXML private CheckBox patenteCE;
    @FXML private CheckBox patenteD;
    @FXML private CheckBox patenteD1;
    @FXML private CheckBox patenteDE;
    @FXML private RadioButton autoMunitoSi;
    @FXML private RadioButton autoMunitoNo;



    private Stage stage;
    private Scene scene;
    private modelWorkersArray lista_lavoratori = new modelWorkersArray();
    private contattoEmergenza [] lista_contatti;

    @FXML
    void switchBackToLogin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void insertWorker(MouseEvent event) {
        modelWorker lavoratore = createWorker();
        lavoratore.writeInFile();
        lista_lavoratori.add(lavoratore, lista_contatti);
        clearAll();
    }
    public modelWorker createWorker(){
        modelWorker lavoratore = new modelWorker();
        lavoratore.setNome(name.getText());
        lavoratore.setCognome(surname.getText());
        lavoratore.setDataDiNascita(datePicker.getValue().toString());
        lavoratore.setLuogoDiNascita(birthplace.getText());
        lavoratore.setIndirizzo(address.getText());
        lavoratore.setTelefono(phone.getText());
        lavoratore.setNazionalita(nationality.getText());
        lavoratore.setEmail(email.getText());
        lavoratore.setLingueParlate(languages.getText());
        lavoratore.setAutomunito(autoMunitoSi.isSelected() ? true : false);
        lavoratore.setLicences(writeLicenses());

        return lavoratore;
    }

    @FXML
    void openSearch(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("searchView.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ricerca");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void insertEmergencyInfo(MouseEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("emergencyInfo.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Contatti d'emergenza");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String writeLicenses(){
        String res = "";
        if(patenteAM.isSelected())
            res += "AM, ";
        if(patenteA1.isSelected())
            res += "A1, ";
        if(patenteA2.isSelected())
            res += "A2, ";
        if(patenteA.isSelected())
            res += "A, ";
        if(patenteB1.isSelected())
            res += "B1, ";
        if(patenteB.isSelected())
            res += "B, ";
        if(patenteC1.isSelected())
            res += "C1, ";
        if(patenteC.isSelected())
            res += "C, ";
        if(patenteD1.isSelected())
            res += "D1, ";
        if(patenteD.isSelected())
            res += "D, ";
        if(patenteCE.isSelected())
            res += "CE, ";
        if(patenteDE.isSelected())
            res += "DE, ";
        if(patenteBE.isSelected())
            res += "BE";

        return res;
    }

    @FXML
    void switchBacktoHome(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void clearAll(){
        name.clear();
        surname.clear();
        datePicker.getEditor().clear();
        birthplace.clear();
        address.clear();
        phone.clear();
        nationality.clear();
        email.clear();
        languages.clear();
        patenteA.setSelected(false);
        patenteA1.setSelected(false);
        patenteA2.setSelected(false);
        patenteAM.setSelected(false);
        patenteB.setSelected(false);
        patenteB1.setSelected(false);
        patenteBE.setSelected(false);
        patenteC.setSelected(false);
        patenteC1.setSelected(false);
        patenteCE.setSelected(false);
        patenteD.setSelected(false);
        patenteD1.setSelected(false);
        patenteDE.setSelected(false);
        autoMunitoSi.setSelected(false);
        autoMunitoNo.setSelected(false);
    }

//    private void writeInFile(){
//        CSVWriter writer = null;
//
//        try {
//            //out = new PrintWriter("D:\\Lavoratori_Stagionali\\src\\main\\java\\it\\univr\\data\\workers.csv");
//            writer = new CSVWriter(new FileWriter("D:\\Lavoratori_Stagionali\\src\\main\\java\\it\\univr\\data\\workers.csv", true));
//            // stampa nel file
//            String automunito = autoMunitoSi.isSelected() ? "si" : "no";
//            String res [] = {name.getText(), surname.getText(), datePicker.getValue().toString(), birthplace.getText(), address.getText(),
//                    phone.getText(), nationality.getText(), email.getText(), languages.getText(), writeLicenses(), automunito};
//
//            //Writing data to the csv file
//            writer.writeNext(res);
//
//            //Flushing data from writer to file
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
