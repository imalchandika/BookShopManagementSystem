package lk.ijse.dep.BookShop.idGeni;

import java.text.NumberFormat;

public class IDGenarator {
    public static String getNewID(String tableName,String colName,String prifix) throws Exception{
        String lastID= IDController.getLastID(tableName, colName);
        if (lastID!= null) {
            int id = Integer.parseInt(lastID.split(prifix)[1]);
            id++;
            System.out.println(id);
            NumberFormat nf= NumberFormat.getIntegerInstance();
            nf.setMaximumIntegerDigits(3);
            nf.setGroupingUsed(false);
            String newID= nf.format(id);

            return prifix +"00"+newID;

        } else {
            return prifix +"001";
        }
    }
}
