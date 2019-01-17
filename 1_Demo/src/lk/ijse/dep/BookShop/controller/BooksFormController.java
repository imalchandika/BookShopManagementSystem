package lk.ijse.dep.BookShop.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.BookShop.business.BOFactory;

import lk.ijse.dep.BookShop.business.custom.AuthorBO;
import lk.ijse.dep.BookShop.business.custom.BookBO;
import lk.ijse.dep.BookShop.business.custom.PublisherBO;
import lk.ijse.dep.BookShop.dto.AuthorDTO;
import lk.ijse.dep.BookShop.dto.BookDTO;
import lk.ijse.dep.BookShop.dto.PublisherDTO;
import lk.ijse.dep.BookShop.idGeni.IDGenarator;
import lk.ijse.dep.BookShop.main.AppInitializer;
import lk.ijse.dep.BookShop.view.util.BookTM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BooksFormController {
    @FXML
    private TableView<BookTM> tblBook;
    @FXML
    private JFXComboBox<String> cmbauthorId;
    @FXML
    private JFXComboBox<String> cmbpublisherId;

    @FXML
    private JFXTextField txtBookAmount;
    @FXML
    private JFXTextField txtBookQty;


    @FXML
    private JFXButton btnRelateAuthor;
    @FXML
    private JFXButton btnRelatePublisher;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtBookID;
    @FXML
    private ImageView imgHome;
    @FXML
    private JFXTextField txtBookName;

    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;


    BookBO bookBO;

    AuthorBO authorBO;

    PublisherBO publisherBO;

    public void initialize() {

        tblBook.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bid"));
        tblBook.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("bname"));
        tblBook.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("bamount"));
        tblBook.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("bqtyonhand"));
        tblBook.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("aid"));
        tblBook.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("pid"));


        bookBO = BOFactory.getInstance().getBO(BOFactory.DAOTypes.BOOK);
        authorBO=BOFactory.getInstance().getBO(BOFactory.DAOTypes.AUTHUR);
        publisherBO=BOFactory.getInstance().getBO(BOFactory.DAOTypes.PUBLISHER);

        try {
            List<BookDTO> books = bookBO.getBooks();
            ObservableList<BookTM> bookDTOS = FXCollections.observableArrayList();
            for (BookDTO book : books) {
                bookDTOS.add(new BookTM(book.getbId(),book.getbName(),book.getbAmount(),book.getbQtyOnHand(),
                        book.getaId(),book.getpId()));
            }

            tblBook.setItems(bookDTOS);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            List<AuthorDTO> authors = authorBO.getAuthors();

            for (AuthorDTO author : authors) {
                cmbauthorId.getItems().add(author.getaId());
            }

            List<PublisherDTO> publishers =publisherBO.getPublishers();
            for (PublisherDTO publisher : publishers) {
                cmbpublisherId.getItems().add(publisher.getpId());
            }
            bookID();
        } catch (Exception e) {
            e.printStackTrace();
        }



        tblBook.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BookTM>() {
            @Override
            public void changed(ObservableValue<? extends BookTM> observable, BookTM oldValue, BookTM newValue) {
                txtBookAmount.setText(newValue.getBamount()+"");
                txtBookName.setText(newValue.getBname());
                txtBookQty.setText(newValue.getBqtyonhand()+"");
                cmbauthorId.setValue(newValue.getAid());
                cmbpublisherId.setValue(newValue.getPid());
                txtBookID.setText(newValue.getBid());
            }
        });



        txtBookName.requestFocus();
    }

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
        String bid=txtBookID.getText();
        String name = txtBookName.getText();
        double amount = Double.parseDouble(txtBookAmount.getText());
        int qty = Integer.parseInt(txtBookQty.getText());
        String aid = cmbauthorId.getSelectionModel().getSelectedItem();
        String pid = cmbpublisherId.getSelectionModel().getSelectedItem();

        BookTM bookTM = new BookTM(bid, name, amount, qty, aid, pid);

        BookBO bookBO = BOFactory.getInstance().getBO(BOFactory.DAOTypes.BOOK);

        if(tblBook.getSelectionModel().isEmpty()) {
            try {
                boolean isAdd = bookBO.createBook(new BookDTO(bid, name, amount, qty, pid, aid));
                if (isAdd) {
                    tblBook.getItems().add(bookTM);
                    tblBook.scrollTo(bookTM);
                    new Alert(Alert.AlertType.INFORMATION, "BOOk ADD", ButtonType.OK).show();

                } else {
                    new Alert(Alert.AlertType.ERROR, "BOOk NOT ADD", ButtonType.OK).show();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{

            try {


                boolean isUpdate = bookBO.updateBook(new BookDTO(bid,name,amount,qty,aid,pid));

                if (isUpdate) {
                    new Alert(Alert.AlertType.INFORMATION, "customer UPDATE", ButtonType.OK).showAndWait();

                    //tblBook.getItems().add(new BookTM(bid,name,amount,qty,aid,pid));
                } else {

                    new Alert(Alert.AlertType.ERROR, "customer NOT UPADATE", ButtonType.OK).show();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            BookTM selectedItem = tblBook.getSelectionModel().getSelectedItem();
            selectedItem.setBname(txtBookName.getText());
            selectedItem.setBamount(Double.parseDouble(txtBookAmount.getText()));
            tblBook.refresh();



        }


    }

    @FXML
    private void btnDelete_OnAction(ActionEvent actionEvent) {
        Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION, "ARE YOU SURE BOOK DELETE", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = confirmMsg.showAndWait();

        if (buttonType.get() == ButtonType.YES) {

            try {
                boolean isDelete = bookBO.deleteBook(txtBookID.getText());
                if (isDelete) {
                    tblBook.getItems().remove(tblBook.getSelectionModel().getSelectedItem());
                    new Alert(Alert.AlertType.INFORMATION, "BooK delete", ButtonType.OK).showAndWait();

                    //.getItems().add(new CustomerTM(id, name, tele));
                } else {

                    new Alert(Alert.AlertType.ERROR, "book NOT ADD", ButtonType.OK).show();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void btnRelateAuthor_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnRelatePublisher_OnAction(ActionEvent actionEvent) {
    }
    private void bookID() throws Exception {
        String newID = IDGenarator.getNewID("book", "bId", "b");
        txtBookID.setText(newID);

    }
}
