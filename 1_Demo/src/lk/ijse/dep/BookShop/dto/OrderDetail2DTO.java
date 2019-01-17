package lk.ijse.dep.BookShop.dto;

import java.util.Date;

public class OrderDetail2DTO extends SuperDTO{


        private String cId;
        private Date oDate;
        private double price;
        private String id;
        private String bId;

        public OrderDetail2DTO(String cId, Date oDate, double price, String id, String bId) {
            this.setcId(cId);
            this.setoDate(oDate);
            this.setPrice(price);
            this.setId(id);
            this.setbId(bId);
        }

        public String getcId() {
            return cId;
        }

        public void setcId(String cId) {
            this.cId = cId;
        }

        public Date getoDate() {
            return oDate;
        }

        public void setoDate(Date oDate) {
            this.oDate = oDate;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getbId() {
            return bId;
        }

        public void setbId(String bId) {
            this.bId = bId;
        }
}
