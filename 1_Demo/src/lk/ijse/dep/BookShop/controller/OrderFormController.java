package lk.ijse.dep.BookShop.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.BookShop.main.AppInitializer;

import java.io.IOException;

public class OrderFormController {
    public JFXTextField txtOrderId;

    public JFXTextField txtOrderDate;

    public JFXTextField txtCustomerId;
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgHome;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private TableView tblAuthor_Book;

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
    private void txtBookId_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void txtAuthorID_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnSave_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnDelete_OnAction(ActionEvent actionEvent) {
    }

    public void txtOrderId_OnAction(ActionEvent actionEvent) {
    }

    public void txtCustomerId_OnAction(ActionEvent actionEvent) {
    }
}
