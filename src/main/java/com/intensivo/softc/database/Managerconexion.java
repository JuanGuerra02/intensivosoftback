package com.intensivo.softc.database;

import java.sql.Connection;

public class Managerconexion {

    private static Managerconexion instance;
    private Conexion conexion;

    private Managerconexion(){
    conexion= new Conexion();
    }

    public static  Managerconexion getInstance(){
        if (instance==null){
            instance=new Managerconexion();
        }
        return instance;
    }

    public void open(){
        conexion.connetc();
    }

    public void commit(){
        try {
            conexion.getCon().commit();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void rollback(){
        try {
            conexion.getCon().rollback();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void close(){
        try {
            conexion.getCon().close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public Connection getConnection() {return  conexion.getCon();}
}
