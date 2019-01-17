package lk.ijse.dep.BookShop.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.BookShop.business.BOFactory;
import lk.ijse.dep.BookShop.business.SuperBO;
import lk.ijse.dep.BookShop.business.custom.PublisherBO;
import lk.ijse.dep.BookShop.dto.PublisherDTO;
import lk.ijse.dep.BookShop.entity.Publisher;
import lk.ijse.dep.BookShop.main.AppInitializer;

import java.io.IOException;

public class PublisherFormController {
    @FXML
    private ImageView imgHome;
    @FXML
    private JFXTextField txtPublisherID;
    @FXML
    private JFXTextField txtPublisherName;
    @FXML
    private JFXTextField txtPublisherEmail;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private TableView tblPublisher;
    @FXML
    private AnchorPane root;

    @FXML
    private void navigate(MouseEvent event) throws IOException {
        AppInitializer.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    @FXML
    private void PlayEnterAnimation(MouseEvent event) {
        AuthorFormController.PlayEnterAnimationMethod(event);
    }

    @FXML
    private void PlayExitAnimation(MouseEvent event) {
        AuthorFormController.PlayExitAnimationMethod(event);
    }

    @FXML
    private void btnSave_OnAction(ActionEvent actionEvent) {
        PublisherBO publisherBO = BOFactory.getInstance().getBO(BOFactory.DAOTypes.PUBLISHER);
        String id = txtPublisherID.getText();
        String name = txtPublisherName.getText();
        String email =txtPublisherEmail.getText();


        try {
            boolean isAdd = publisherBO.createPublisher(new PublisherDTO(id,name,email));
            if(isAdd){
                new Alert(Alert.AlertType.INFORMATION," Publisher ADD", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void btnDelete_OnAction(ActionEvent actionEvent) {

    }
}
