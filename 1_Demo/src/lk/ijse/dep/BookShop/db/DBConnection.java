package lk.ijse.dep.BookShop.db;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() throws SQLException, IOException {
        if (connection == null){
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bookshop", "root", "mysqlroot");


            File file = new File("resource/application.properties");
            FileReader fileReader = new FileReader(file);
            Properties dbProp = new Properties();
            dbProp.load(fileReader);

            String ip = dbProp.getProperty("ip");
            String port = dbProp.getProperty("port");
            String db = dbProp.getProperty("database");
            String username = dbProp.getProperty("username");
            String password = dbProp.getProperty("password");

            String url = "jdbc:mysql://" + ip + ":" + port + "/" + db;

            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

}
