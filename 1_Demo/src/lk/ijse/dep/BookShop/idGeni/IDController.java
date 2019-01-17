package lk.ijse.dep.BookShop.idGeni;

import lk.ijse.dep.BookShop.db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IDController {
    public static String getLastID(String tableName,String colName) throws Exception{
        String SQL="SELECT "+colName+" FROM "+tableName+" ORDER BY 1 DESC LIMIT 1";
        Connection connection= (Connection) DBConnection.getConnection();
        Statement stm = (Statement) connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            return rst.getString(1);
        }
        return  null;

    }
}
