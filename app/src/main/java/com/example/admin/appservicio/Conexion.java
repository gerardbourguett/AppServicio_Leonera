package com.example.admin.appservicio;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Gerard Bourguett
 * Source: http://www.parallelcodes.com/connect-android-to-ms-sql-database-2/
 */

public class Conexion {

    String ip = "200.6.117.55";
    String classs = "net.sourceforge.jtds.jdbc.Driver";
    String db = "panelesl_casino";
    String un = "panelesl_appMovi";
    String password = "leo@22$forest.2018";

    @SuppressLint("AppServicio")
    public Connection CONN(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try{
            Class.forName(classs);
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";"
                    + "databaseName=" + db + ";user=" + un + ";password="
                    + password + ";";
            conn = DriverManager.getConnection(ConnURL);
        } catch (ClassNotFoundException e) {
            Log.e("ERROR", e.getMessage());
        } catch (SQLException se) {
            Log.e("ERROR", se.getMessage());
        } catch (Exception e){
            Log.e("ERROR", e.getMessage());
        }
        return conn;
    }

}



