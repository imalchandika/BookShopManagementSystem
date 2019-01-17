package lk.ijse.dep.BookShop.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.BookShop.business.BOFactory;

import lk.ijse.dep.BookShop.business.custom.BookBO;
import lk.ijse.dep.BookShop.business.custom.CustomerBO;
import lk.ijse.dep.BookShop.business.custom.OrderBO;
import lk.ijse.dep.BookShop.dto.*;

import lk.ijse.dep.BookShop.idGeni.IDGenarator;
import lk.ijse.dep.BookShop.main.AppInitializer;

import lk.ijse.dep.BookShop.view.util.OrderDetailTM;
import lk.ijse.dep.BookShop.view.util.PaymentTM;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class PaymentFormController {

    public JFXTextField txtOrderID;

    public JFXTextField txtUnitPrice;

    public JFXTextField txtBookQty;

    public JFXTextField txtOrderDate;

    public JFXTextField txtPaymentID;

    public TableView<OrderDetailTM> tblOrderDetails;

    public JFXButton btnOrderPay;

    public TableView<PaymentTM> tblPaymentDetails;

    public ComboBox<String> cmbBookID;

    public ComboBox<String> cmbCuustomerID;

    public JFXButton btnReport;


    public JFXTextField txtQty;
    @FXML
    private JFXDatePicker dprBuyDate;
    @FXML
    private JFXTextField txtAuthorID1;
    @FXML
    private Label lblTotalPrize;
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgHome;

    @FXML
    private JFXTextField txtBookName;
    @FXML
    private JFXTextField txtAuthorID;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXTextField txtAuthorName;
    @FXML
    private JFXTextField txtPublisherID;
    @FXML
    private JFXTextField txtPublisherName;
    @FXML
    private JFXDatePicker dprBorrowDate;
    @FXML
    private JFXDatePicker dprReturnDate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private ImageView imgBorrow;

    public OrderBO orderBO;

    double total=0;

    public CustomerBO customerBO;

    BookBO bookBO;

    public void initialize(){
        customerBO=BOFactory.getInstance().getBO(BOFactory.DAOTypes.CUSTOMER);
        orderBO = BOFactory.getInstance().getBO(BOFactory.DAOTypes.ORDERS);
        bookBO=BOFactory.getInstance().getBO(BOFactory.DAOTypes.BOOK);

        tblOrderDetails.getColumns().get(0).setStyle("-app-alignment:center");
        tblOrderDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("oid"));
        tblOrderDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("bid"));
        tblOrderDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblOrderDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitprice"));

        tblPaymentDetails.getColumns().get(0).setStyle("-app-alignment:center");
        tblPaymentDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblPaymentDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("price"));
        tblPaymentDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("oid"));



        txtPaymentID.requestFocus();

        try {
            List<CustomerDTO> customers = customerBO.getCustomers();
            for (CustomerDTO customer : customers) {
                cmbCuustomerID.getItems().add(customer.getcId());
            }

            List<BookDTO> books = bookBO.getBooks();
            for (BookDTO book : books) {
                cmbBookID.getItems().add(book.getbId());
            }
            orderID();
            paymentID();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //cmbCuustomerID.setValue("c002");
       // cmbBookID.setValue("b001");

        tblOrderDetails.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<OrderDetailTM>() {
            @Override
            public void changed(ObservableValue<? extends OrderDetailTM> observable, OrderDetailTM oldValue, OrderDetailTM newValue) {
                cmbBookID.setValue(newValue.getBid());
            }
        });
        tblPaymentDetails.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PaymentTM>() {
            @Override
            public void changed(ObservableValue<? extends PaymentTM> observable, PaymentTM oldValue, PaymentTM newValue) {
                txtPaymentID.setText(newValue.getId());
            }
        });


        txtPaymentID.setEditable(false);
        txtOrderID.setEditable(false);


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
    private void txtBookID_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void txtBookName_OnKeyReleased(KeyEvent keyEvent) {
    }

    @FXML
    private void txtAuthorID_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnSave_OnAction(ActionEvent actionEvent) {

        String oId = txtOrderID.getText();
        int  bookQtyOnhand = Integer.parseInt(txtBookQty.getText());
        String bId =cmbBookID.getSelectionModel().getSelectedItem();
        double unitprice = Double.parseDouble(txtUnitPrice.getText());
        String id = txtPaymentID.getText();
        int Qty = Integer.parseInt(txtQty.getText());
        double price=Qty*unitprice;

        tblOrderDetails.getItems().add(new OrderDetailTM(oId, bId, Qty, unitprice));

        tblPaymentDetails.getItems().add(new PaymentTM(id,oId,price));

        total+=price;
        lblTotalPrize.setText(total+"");


         int i = Integer.parseInt(id.split("P")[1]);
        i++;
         txtPaymentID.setText("P"+"00"+i+"");

    }

    @FXML
    private void txtAuthorName_OnKeyReleased(KeyEvent keyEvent) {
    }

    @FXML
    private void txtPublisherID_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void txtPublisherName_OnKeyReleased(KeyEvent keyEvent) {
    }

    @FXML
    private void txtMemberID_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnDelete_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void imgBorrow_OnMouseClicked(MouseEvent event) {
    }

    public void txtPaymentID_OnAction(ActionEvent actionEvent) {
    }

    public void txtUnitPrice_OnAction(ActionEvent actionEvent) {
    }

    public void txtOrderID_OnAction(ActionEvent actionEvent) {
    }

    public void btnOrderPay_OnAction(ActionEvent actionEvent) {
        if(cmbCuustomerID.getSelectionModel().getSelectedItem()==null||cmbBookID.getSelectionModel().getSelectedItem()==null||dprBuyDate.getValue()==null){
            new Alert(Alert.AlertType.ERROR, "CUSTOMER ID OR BOOK ID OR DATE NOT SELECT", ButtonType.OK).show();
            return;
        }



        String oid = txtOrderID.getText();
        LocalDate date =dprBuyDate.getValue();
        String cid=cmbCuustomerID.getSelectionModel().getSelectedItem();
        List<PaymentDTO> paymentDTOlist=new ArrayList<>();
        List<OrderDetailDTO> orderDetailDTOS=new ArrayList<>();


        List<PaymentTM> paymentDetailsItems = tblPaymentDetails.getItems();

        for (PaymentTM pdi : paymentDetailsItems) {
            paymentDTOlist.add(new PaymentDTO(pdi.getId(),pdi.getOid(),pdi.getPrice()));

        }

        List<OrderDetailTM> orderDetailsItems = tblOrderDetails.getItems();

        for (OrderDetailTM orderDetailsItem : orderDetailsItems) {
            orderDetailDTOS.add(new OrderDetailDTO(orderDetailsItem.getOid(),
                    orderDetailsItem.getBid(),
                    orderDetailsItem.getQty(),
                    orderDetailsItem.getUnitprice()));

           // System.out.println(orderDetailsItem.getBid());
        }


        try {
             boolean isAdd = orderBO.createOrder(new OrdersDTO(oid, date, cid, paymentDTOlist, orderDetailDTOS));
            if (isAdd) {
                txtBookQty.clear();
                //cmbBookID.getItems().clear();
                new Alert(Alert.AlertType.INFORMATION, "PAYMENT SUCCESS", ButtonType.OK).showAndWait();

            } else {

                new Alert(Alert.AlertType.ERROR, "PAYMENT SUCCESS NOT ADD", ButtonType.OK).show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void OnClickReport(ActionEvent actionEvent) throws JRException {
        File file = new File("Report-1/Paymentform.jasper");

        JasperReport compiledReport = (JasperReport) JRLoader.loadObject(file);
        Map<String, Object> params = new HashMap<>();

          params.put("date", Date.valueOf(dprBuyDate.getValue()));


        DefaultTableModel dtm = new DefaultTableModel(new Object[]{"orderid","qty","bookid","unitprice","Amount"},0);

        ObservableList<OrderDetailTM> customers = tblOrderDetails.getItems();

        for (OrderDetailTM orderDetailTM : customers) {
            Object[] rowData = {orderDetailTM.getOid(),orderDetailTM.getQty(),orderDetailTM.getBid(),orderDetailTM.getUnitprice()};
            dtm.addRow(rowData);
        }


        JasperPrint filledReport = JasperFillManager. fillReport(compiledReport, params, new JRTableModelDataSource(dtm));


        JasperViewer.viewReport(filledReport,false);




    }

    public void OnClickcmbBook(ActionEvent actionEvent) {

        try {
             BookDTO bookDTO = bookBO.findBook(cmbBookID.getValue());

             txtBookQty.setText(bookDTO.getbQtyOnHand()+"");

             txtUnitPrice.setText(bookDTO.getbAmount()+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void orderID() throws Exception {
        String newID = IDGenarator.getNewID("orderbook", "oId", "o");
        txtOrderID.setText(newID);

    }
    private void paymentID() throws Exception {
        String newID = IDGenarator.getNewID("payment", "id", "P");
        txtPaymentID.setText(newID);

    }
}
