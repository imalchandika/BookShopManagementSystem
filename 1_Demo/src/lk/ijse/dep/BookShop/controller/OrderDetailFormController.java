package lk.ijse.dep.BookShop.controller;


import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.BookShop.business.BOFactory;

import lk.ijse.dep.BookShop.business.custom.OrderBO;
import lk.ijse.dep.BookShop.dto.OrderDetail2DTO;
import lk.ijse.dep.BookShop.entity.OrderDetail2;
import lk.ijse.dep.BookShop.main.AppInitializer;
import lk.ijse.dep.BookShop.view.util.OrderDetail2TM;

import java.io.IOException;
import java.util.List;

public class OrderDetailFormController {

    public TableView<OrderDetail2TM> tblOrderDetail;

    public JFXTextField lblOrderID;

    public ImageView imgHome;

    public AnchorPane root;



    public void OnClickOrderid(ActionEvent actionEvent) {

        OrderBO orders = BOFactory.getInstance().getBO(BOFactory.DAOTypes.ORDERS);

        tblOrderDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cid"));
        tblOrderDetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("odate"));
        tblOrderDetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("price"));
        tblOrderDetail.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblOrderDetail.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("bid"));


        try {
             List<OrderDetail2DTO> orderDetails = orders.getOrderDetails(lblOrderID.getText());
            ObservableList<OrderDetail2TM> orderList = FXCollections.observableArrayList();

            for (OrderDetail2DTO orderDetail : orderDetails) {
                orderList.add(new OrderDetail2TM(orderDetail.getcId(),
                        orderDetail.getoDate(),
                        orderDetail.getPrice(),
                        orderDetail.getId(),
                        orderDetail.getbId()));
            }

            tblOrderDetail.setItems(orderList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void navigate(MouseEvent event) {
        try {
            AppInitializer.navigateToHome(root, (Stage) this.root.getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void PlayEnterAnimation(MouseEvent event) {
        AuthorFormController.PlayEnterAnimationMethod(event);
    }

    public void PlayExitAnimation(MouseEvent event) {
        AuthorFormController.PlayExitAnimationMethod(event);
    }
}
