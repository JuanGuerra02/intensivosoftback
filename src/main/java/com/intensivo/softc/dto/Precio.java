package com.intensivo.softc.dto;

import java.util.Date;

public class Precio {

    private int nmprecio;
    private Producto psku;
    private double precio;
    private Date fedesde;
    private Date fehasta;

    public Producto getSku() {return psku;}

    public void setSku(Producto sku) {this.psku = sku;}

    public int getNmprecio() {
        return nmprecio;
    }

    public void setNmprecio(int nmprecio) {
        this.nmprecio = nmprecio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFedesde(Date fedesde){ this.fedesde =fedesde;}

    public Date getFedesde(){return fedesde; }

    public void setFehasta(Date fehasta ){ this.fehasta = fehasta;}

    public Date getFehasta( ){ return fehasta ;}


}
