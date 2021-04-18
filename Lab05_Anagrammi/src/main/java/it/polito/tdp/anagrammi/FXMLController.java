package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button txtReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	
    	txtCorretti.clear();
    	txtErrati.clear();
    	List<String> anagrammi = new LinkedList<String>();
    	List<String> anagrammiCorretti = new LinkedList<String>();
    	List<String> anagrammiErrati = new LinkedList<String>();
    	anagrammi = model.anagrammi(txtParola.getText());
    	anagrammiCorretti = model.anagrammiCorretti(anagrammi);
    	anagrammiErrati = model.anagrammiErrati(anagrammi);
    	for(String s: anagrammiCorretti) {
    		txtCorretti.appendText(s + " ");
    	}
    	for(String s: anagrammiErrati) {
    		txtErrati.appendText(s + " ");
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtCorretti.clear();
    	txtErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtReset != null : "fx:id=\"txtReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
