package lk.ijse.dep.BookShop.controller;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.BookShop.business.BOFactory;

import lk.ijse.dep.BookShop.business.custom.CustomerBO;
import lk.ijse.dep.BookShop.dto.CustomerDTO;
import lk.ijse.dep.BookShop.idGeni.IDGenarator;
import lk.ijse.dep.BookShop.main.AppInitializer;
import lk.ijse.dep.BookShop.view.util.CustomerTM;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerFormController {
    public JFXButton btnReport1;
    @FXML
    private JFXButton lblAddNew;

    @FXML
    private TableView<CustomerTM> tblCustomer;

    @FXML
    private JFXTextField txtCustomerTele;
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgHome;
    @FXML
    private JFXTextField txtCustomerID;
    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;

    public CustomerBO customerBO = BOFactory.getInstance().getBO(BOFactory.DAOTypes.CUSTOMER);

     public void initialize() throws Exception {

         tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cid"));
         tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("cname"));
         tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("ctele"));
         List<CustomerDTO> customers;
         try {
             customers=customerBO.getCustomers();

             ObservableList<CustomerTM> memberTMS = FXCollections.observableArrayList();

             for (CustomerDTO customer : customers) {
                 memberTMS.add(new CustomerTM(customer.getcId(),
                         customer.getcName(),
                         customer.getcTele()));
             }
             tblCustomer.setItems(memberTMS);
              } catch (Exception e) {
             e.printStackTrace();
         }

         tblCustomer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerTM>() {
             @Override
             public void changed(ObservableValue<? extends CustomerTM> observable, CustomerTM oldValue, CustomerTM newValue) {
                 txtCustomerID.setText(newValue.getCid());
                 txtCustomerName.setText(newValue.getCname());
                 txtCustomerTele.setText(newValue.getCtele());

                 btnSave.setDisable(false);
                 btnDelete.setDisable(false);

                 txtCustomerName.setEditable(true);
                 txtCustomerTele.setEditable(true);
             }
         });
         customerID();

         btnSave.setDisable(true);
         btnDelete.setDisable(true);
         txtCustomerName.setEditable(false);
         txtCustomerTele.setEditable(false);
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
         String id = txtCustomerID.getText();
         String name = txtCustomerName.getText();
         String tele =txtCustomerTele.getText();



         if(txtCustomerID.getText().isEmpty()){
             return;
         }

        if(tblCustomer.getSelectionModel().isEmpty()) {

            try {
                for (CustomerDTO customer : customerBO.getCustomers()) {
                    if (txtCustomerID.getText().equals(customer.getcId())) {
                        new Alert(Alert.AlertType.ERROR, "duplicate entry", ButtonType.OK).show();
                        return;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                boolean isADD = customerBO.createCustomer(new CustomerDTO(id, name, tele));
                if (isADD) {
                    new Alert(Alert.AlertType.INFORMATION, "customer ADD", ButtonType.OK).showAndWait();

                    tblCustomer.getItems().add(new CustomerTM(id, name, tele));
                } else {

                    new Alert(Alert.AlertType.ERROR, "customer NOT ADD", ButtonType.OK).show();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{

            try {
                boolean isUpdate = customerBO.updateCustomer(new CustomerDTO(txtCustomerID.getText(),
                        txtCustomerName.getText(),
                        txtCustomerTele.getText()));

                if (isUpdate) {
                    new Alert(Alert.AlertType.INFORMATION, "customer UPDATE", ButtonType.OK).showAndWait();

                    //tblCustomer.getItems().add(new CustomerTM(id, name, tele));
                } else {

                    new Alert(Alert.AlertType.ERROR, "customer NOT UPADATE", ButtonType.OK).show();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            CustomerTM selectedItem = tblCustomer.getSelectionModel().getSelectedItem();
            selectedItem.setCname(txtCustomerName.getText());
            selectedItem.setCtele(txtCustomerTele.getText());
            tblCustomer.refresh();


        }



    }

    @FXML
    private void btnDelete_OnAction(ActionEvent actionEvent) {



        try {
            boolean isDelete = customerBO.deleteCustomer(txtCustomerID.getText());
            if(isDelete){
                tblCustomer.getItems().remove(tblCustomer.getSelectionModel().getSelectedItem());
                new Alert(Alert.AlertType.INFORMATION,"customer DELETE", ButtonType.OK).show();

            }else{

                new Alert(Alert.AlertType.ERROR,"customer NOT DELETE", ButtonType.OK).show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void txtMemberId_OnAction(ActionEvent actionEvent)  {
        if(txtCustomerID.getText().isEmpty()){
            return;
        }
        try {
            for (CustomerDTO customer : customerBO.getCustomers()) {
                if( txtCustomerID.getText().equals(customer.getcId())) {
                     //memberBO.findMember(txtMemberID.getText());
                    txtCustomerName.setText(customer.getcName());
                    txtCustomerTele.setText(customer.getcTele());
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnAddNew_OnAction(ActionEvent actionEvent) {
         tblCustomer.getSelectionModel().clearSelection();
        reset();
    }

    private void reset() {
        btnSave.setDisable(false);
        btnDelete.setDisable(false);

        txtCustomerName.clear();
        txtCustomerTele.clear();
        txtCustomerID.requestFocus();
        txtCustomerName.setEditable(true);
        txtCustomerTele.setEditable(true);
    }

    public void OnClickReport(ActionEvent actionEvent) throws JRException {

            File file = new File("Report-1/Customer.jasper");

            JasperReport compiledReport = (JasperReport) JRLoader.loadObject(file);

             Map<String, Object> params = new HashMap<>();

        params.put("cid",txtCustomerID.getText());
        params.put("cname",txtCustomerName.getText());
        params.put("ctele",txtCustomerTele.getText());

            DefaultTableModel dtm = new DefaultTableModel(new Object[]{"id","name"},0);

            ObservableList<CustomerTM> customers = tblCustomer.getItems();

            for (CustomerTM customer : customers) {
                Object[] rowData = {customer.getCid(), customer.getCname()};
                dtm.addRow(rowData);
            }

            JasperPrint filledReport = JasperFillManager. fillReport(compiledReport, params, new JRTableModelDataSource(dtm));


            JasperViewer.viewReport(filledReport,false);
    }

    private void customerID() throws Exception {
         String newID = IDGenarator.getNewID("customer", "cId", "c");
         txtCustomerID.setText(newID);

    }


    public void OnClickValidationName(KeyEvent keyEvent) {
        String txt=txtCustomerName.getText();

        int position= txtCustomerName.getCaretPosition();
        if (!txt.matches("^[A-Za-z//]*$")) {
            txtCustomerName.setText(txt.substring(0, position - 1) + txt.substring(position));
            txtCustomerName.positionCaret(position - 1);
        }
    }

    public void OnClickValidationTele(KeyEvent keyEvent) {

    }
}
