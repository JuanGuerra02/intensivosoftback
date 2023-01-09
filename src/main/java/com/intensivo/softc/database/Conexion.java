package com.intensivo.softc.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private Connection con = null;

    public Connection getCon(){
    return con;
    }

    public void connetc(){

        try {
            String sURL = "jdbc:mysql://localhost:3306/ventas";
            con = DriverManager.getConnection(sURL,"root", null);
            con.setAutoCommit(false);
        }catch (Exception ex){
        ex.printStackTrace();
        }

    }

}
