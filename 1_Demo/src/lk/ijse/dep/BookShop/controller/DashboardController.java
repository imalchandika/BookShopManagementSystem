package lk.ijse.dep.BookShop.controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController {
    public ImageView Orderimg;

    public ImageView OrderDetailimg;
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgBurrow;
    @FXML
    private ImageView imgMember;
    @FXML
    private ImageView imgBook;
    @FXML
    private ImageView imgAuthor;
    @FXML
    private ImageView imgPublisher;
    @FXML
    private Label lblWelcome;
    @FXML
    private Label lblStatus;
    @FXML
    private ImageView imgReturn;

    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();


    }

    @FXML
    private void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch(icon.getId()){
                case "imgMember":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/BookShop/view/CustomerForm.fxml"));
                    break;
                case "imgBook":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/BookShop/view/BooksForm.fxml"));
                    break;
                case "imgAuthor":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/BookShop/view/AuthorForm.fxml"));
                    break;
                case "imgPublisher":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/BookShop/view/PublisherForm.fxml"));
                    break;

                case "imgBurrow":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/BookShop/view/PaymentForm.fxml"));
                    break;
                case "Orderimg":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/BookShop/view/OrderForm.fxml"));
                    break;
                case "OrderDetailimg":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/BookShop/view/OrderDetailForm.fxml"));
                    break;
            }

            if (root != null){
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();
                primaryStage.setResizable(true);


                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }

    @FXML
    private void PlayEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();

            switch(icon.getId()){
                case "imgMember":
                    lblWelcome.setText(" Customer Form");
                    lblStatus.setText("Click to add, edit, delete or view Customer");
                    break;
                case "imgBook":
                    lblWelcome.setText(" Books Form");
                    lblStatus.setText("Click to add, edit, delete or view Books");
                    break;
                case "imgAuthor":
                    lblWelcome.setText("Authors Form");
                    lblStatus.setText("Click to add, edit, delete or view Authors");
                    break;
                case "imgPublisher":
                    lblWelcome.setText("Publishers Form");
                    lblStatus.setText("Click to add, edit, delete or view Publishers");
                    break;

                case "imgBurrow":
                    lblWelcome.setText("Payment Form");
                    lblStatus.setText("Click to Payment books");
                    break;
                case "Orderimg":
                    lblWelcome.setText("Order Form");
                    lblStatus.setText("Click to Order");
                    break;
                case "OrderDetailimg":
                    lblWelcome.setText("OrderDetail Form");
                    lblStatus.setText("Click to OrderDetail");
                    break;
            }

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
    }

    @FXML
    private void PlayExitAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            lblWelcome.setText("Welcome");
            lblStatus.setText("Please Select an Option to Proceed");
        }
    }
}
