package net.java.backEnd.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DBConnection 
 */
public class dbconn {
    public static final String PRODUCT_RDS_URL = "jdbc:sqlserver://rds-sql-server-2017-14v !! SECRET :( kkkk !!";

    public boolean Context(){
        String connectionUrl = PRODUCT_RDS_URL;
        ResultSet rs = null;
        int res = 0;
        
    
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT DB_NAME(dbid) as dbid, COUNT(dbid) AS Cnt FROM sys.sysprocesses WHERE dbid > 0 AND DB_NAME(dbid) = 'rdsproduct' GROUP BY dbid";
            rs = stmt.executeQuery(SQL);
            rs.next();
            res = rs.getInt("Cnt");

            if(res > 0){
                return true;
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


}
