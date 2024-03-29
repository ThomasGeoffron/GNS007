/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gns;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author Thomas Geoffron
 */
public class Smash extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        
        Label titre = new Label();
        titre.setText("Nouveau Joueur :");
        
        Label nom = new Label();
        nom.setText("Nom : ");
        
        Label mdp = new Label();
        mdp.setText("Mot de passe : ");
        
        Label verif = new Label();
        verif.setText("Vérification : ");
        
        Label pays = new Label();
        pays.setText("Pays : ");
        
        TextField saisieNom = new TextField();
        saisieNom.setPromptText("Saisir le nom du joueur");
        
        PasswordField saisieMDP = new PasswordField();
        saisieMDP.setPromptText("Saisir le mot de passe");
        
        PasswordField saisieVerif = new PasswordField();
        saisieVerif.setPromptText("Vérifier le mot de passe");
        
        ComboBox<String> saisiePays = new ComboBox<String>();
        saisiePays.setPromptText("Choisissez un pays");
        saisiePays.getItems().addAll("France", "Espagne", "Allemagne", "Pologne", "Portugal", "Angleterre", "Écosse",
                               "Pays de Galle", "Irlande du Nord", "Irlande", "Italie");
        saisiePays.setVisibleRowCount(5);
        
        ToggleGroup genre = new ToggleGroup();  
        RadioButton genreH = new RadioButton("Homme");
        RadioButton genreF = new RadioButton("Femme");
        genreH.setToggleGroup(genre);
        genreF.setToggleGroup(genre);
        genreH.setSelected(true);
        
        CheckBox CGU = new CheckBox("Acceptez les conditions générales d'utilisation.");
        
        Button annuler = new Button();
        annuler.setText("Réinitialiser");
        
        Button valider = new Button();
        valider.setText("Valider");
        
        valider.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(saisieNom.getText().length() > 0 && saisieMDP.getText().length() > 0 && 
                    saisieVerif.getText().length() > 0){
                    if(saisiePays.getValue() == null){
                        Alert erreur = new Alert(AlertType.ERROR);
                        erreur.setTitle("Échec...");
                        erreur.setHeaderText(null);// No header
                        erreur.setContentText("Échec de création du joueur...");
                        erreur.showAndWait();
                    }
                    else{
                        if(saisieMDP.getText().equals(saisieVerif.getText())){
                            if(genreH.isSelected()){
                                Joueur joueur = new Joueur(saisieNom.getText(), saisieMDP.getText(), saisiePays.getValue(),'H', CGU.isSelected());
                                System.out.println(joueur.toString());
                            }
                            if(genreF.isSelected()){
                                Joueur joueur = new Joueur(saisieNom.getText(), saisieMDP.getText(), saisiePays.getValue(),'F', CGU.isSelected());
                                System.out.println(joueur.toString());
                            }

                            Alert reussie = new Alert(AlertType.CONFIRMATION);
                            reussie.setTitle("Création réussie ! ");
                            reussie.setHeaderText(null);// No header
                            reussie.setContentText("Le joueur a bien été créé !");
                            reussie.showAndWait();
                        }
                    }   
                }                
                else{
                    Alert erreur = new Alert(AlertType.ERROR);
                    erreur.setTitle("Échec...");
                    erreur.setHeaderText(null);// No header
                    erreur.setContentText("Échec de création du joueur...");
                    erreur.showAndWait();
                }
            }
        });
            
        annuler.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                saisieNom.setText("");
                saisieMDP.setText("");
                saisieVerif.setText("");
                saisiePays.getSelectionModel().clearSelection();
                genreH.setSelected(true);
                CGU.setSelected(false);
            }
        });
        
        
        VBox root = new VBox(6);
        
        HBox boxNom = new HBox();
        boxNom.getChildren().addAll(nom, saisieNom);
        
        HBox boxMDP = new HBox();
        boxMDP.getChildren().addAll(mdp, saisieMDP);
        
        HBox boxVerif = new HBox();
        boxVerif.getChildren().addAll(verif, saisieVerif);
        
        HBox boxPays = new HBox();
        boxPays.getChildren().addAll(pays, saisiePays);
        
        HBox boxRadio = new HBox();
        boxRadio.getChildren().addAll(genreH, genreF);
        
        HBox boxButton = new HBox();
        boxButton.getChildren().addAll(annuler, valider);
      
        root.getChildren().addAll(titre, boxNom, boxMDP, boxVerif, boxPays, boxRadio, CGU,boxButton);
        Scene scene = new Scene(root, 350, 250);
        root.setPadding(new Insets(10));
        
        primaryStage.setTitle("Création d'un joueur");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
