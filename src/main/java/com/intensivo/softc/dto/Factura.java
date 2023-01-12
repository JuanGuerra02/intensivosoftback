package com.intensivo.softc.dto;

import java.sql.Date;

public class Factura {

    private int nmfactura;
    private String cdfactura;
    private Date fefactura;
    private Vendedor nmvendedor;
    private Cliente nmcliente;

    public int getNmfactura() {
        return nmfactura;
    }

    public void setNmfactura(int nmfactura) {
        this.nmfactura = nmfactura;
    }

    public String getCdfactura() {
        return cdfactura;
    }

    public void setCdfactura(String cdfactura) {
        this.cdfactura = cdfactura;
    }

    public Date getFefactura() {
        return fefactura;
    }

    public void setFefactura(Date fefactura) {
        this.fefactura = fefactura;
    }

    public Vendedor getFnmvendedor() {
        return nmvendedor;
    }

    public void setFnmvendedor(Vendedor nmvendedor) {
        this.nmvendedor = nmvendedor;
    }

    public Cliente getFnmcliente() {
        return nmcliente;
    }

    public void setFnmcliente(Cliente nmcliente) {
        this.nmcliente = nmcliente;
    }
}
