package com.intensivo.softc.dto;

public class DetalleFactura {

    private int nmdetfactura;
    private Producto sku;
    private Factura nmfactura;
    private int cantidad;
    private Precio nmprecio;
    private double precio;

    public double getDprecio() {return precio;}
    public void setDprecio(double precio) {this.precio = precio;}
    public int getNmdetfactura() {
        return nmdetfactura;
    }
    public void setNmdetfactura(int nmdetfactura) {
        this.nmdetfactura = nmdetfactura;
    }
    public Producto getDSku() {
        return sku;
    }
    public void setDSku(Producto sku) {
        this.sku = sku;
    }
    public Factura getDnmfactura() {
        return nmfactura;
    }
    public void setDnmfactura(Factura nmfactura) {
        this.nmfactura = nmfactura;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Precio getDnmprecio() {
        return nmprecio;
    }
    public void setDnmprecio(Precio nmprecio) {
        this.nmprecio = nmprecio;
    }
}
