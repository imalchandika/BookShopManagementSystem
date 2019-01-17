package lk.ijse.dep.BookShop.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.dep.BookShop.business.BOFactory;
import lk.ijse.dep.BookShop.business.custom.AuthorBO;
import lk.ijse.dep.BookShop.dto.AuthorDTO;
import lk.ijse.dep.BookShop.main.AppInitializer;
import lk.ijse.dep.BookShop.view.util.AuthorTM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthorFormController {
    @FXML
    private ImageView imgHome;
    @FXML
    private JFXTextField txtAuthorID;
    @FXML
    private JFXTextField txtAuthorName;
    @FXML
    private JFXTextField txtAuthorEmail;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private TableView<AuthorTM> tblAuthor;
    @FXML
    private AnchorPane root;

    AuthorBO authorBO =BOFactory.getInstance().getBO(BOFactory.DAOTypes.AUTHUR);

    public void initialize(){

        tblAuthor.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("aid"));
        tblAuthor.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("aname"));
        tblAuthor.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("aemail"));

        try {

            ObservableList<AuthorTM> authorTMS = FXCollections.observableArrayList();
            List<AuthorDTO> authors = authorBO.getAuthors();
            for (AuthorDTO author : authors) {
                authorTMS.add(new AuthorTM(author.getaId(),author.getaName(),author.getaEmail()));
            }

            tblAuthor.setItems(authorTMS);
            } catch (Exception e) {
                e.printStackTrace();
            }

            tblAuthor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<AuthorTM>() {
                @Override
                public void changed(ObservableValue<? extends AuthorTM> observable, AuthorTM oldValue, AuthorTM newValue) {
                    txtAuthorName.setText(newValue.getAname());
                    txtAuthorID.setText(newValue.getAid());
                    txtAuthorEmail.setText(newValue.getAemail());

            }});





    }

    @FXML
    private void navigate(MouseEvent event) throws IOException {
        AppInitializer.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    @FXML
    private void PlayEnterAnimation(MouseEvent event) {
        PlayEnterAnimationMethod(event);
    }

    static void PlayEnterAnimationMethod(MouseEvent event) {
        ImageView icon = (ImageView) event.getSource();
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
        scaleT.setToX(1.2);
        scaleT.setToY(1.2);
        scaleT.play();

        DropShadow glow = new DropShadow();
        glow.setColor(Color.CORNFLOWERBLUE);
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        icon.setEffect(glow);
    }

    @FXML
    private void PlayExitAnimation(MouseEvent event) {
        PlayExitAnimationMethod(event);
    }

    static void PlayExitAnimationMethod(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
        }
    }

    @FXML
    private void btnSave_OnAction(ActionEvent actionEvent)  {
         String id = txtAuthorID.getText();
        String name = txtAuthorName.getText();
        String email = txtAuthorEmail.getText();


        if(txtAuthorID.getText().isEmpty()){
            return;
        }



        if(tblAuthor.getSelectionModel().getSelectedItems().isEmpty()) {
            try {


                boolean isAdd = authorBO.createAuthor(new AuthorDTO(id, name, email));
                if (isAdd) {
                    new Alert(Alert.AlertType.INFORMATION, "member ADD", ButtonType.OK).show();
                    tblAuthor.getItems().add(new AuthorTM(id, name, email));

                } else {

                    new Alert(Alert.AlertType.ERROR, "member NOT ADD", ButtonType.OK).show();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{

            try {
                boolean isUpdate = authorBO.updateAuthor(new AuthorDTO(id, name, email));
                if (isUpdate) {
                    new Alert(Alert.AlertType.INFORMATION, "UPDATED", ButtonType.OK).show();


                } else {

                    new Alert(Alert.AlertType.ERROR, " NOT UPDATED", ButtonType.OK).show();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

             AuthorTM authorTM = tblAuthor.getSelectionModel().getSelectedItem();
             authorTM.setAname(txtAuthorName.getText());
             authorTM.setAemail(txtAuthorEmail.getText());
             tblAuthor.refresh();


        }


    }

    @FXML
    private void btnDelete_OnAction(ActionEvent actionEvent) {
        try {
             boolean isDeletede = authorBO.deleteAuthor(txtAuthorID.getText());
            if(isDeletede){
                new Alert(Alert.AlertType.INFORMATION,"Author delete succese", ButtonType.OK).show();

            }else{

                new Alert(Alert.AlertType.ERROR,"Author NOT Delete", ButtonType.OK).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void txtAuthord_OnAction(ActionEvent actionEvent) {

          if(txtAuthorID.getText().isEmpty()){
            return;
          }


          try {
             AuthorDTO author = authorBO.findAuthor(txtAuthorID.getText());
             txtAuthorName.setText(author.getaName());
             txtAuthorEmail.setText(author.getaEmail());
         } catch (Exception e) {
            e.printStackTrace();
         }
    }
}
