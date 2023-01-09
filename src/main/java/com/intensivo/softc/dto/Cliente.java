package com.intensivo.softc.dto;

public class Cliente {

    private int nmcliente;
    private  String documento;
    private  String dsnombres;
    private  String desapellidos;
    private  String dsdireccion;

    public int getNmcliente() {
        return nmcliente;
    }

    public void setNmcliente(int nmcliente) {
        this.nmcliente = nmcliente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDsnombres() {
        return dsnombres;
    }

    public void setDsnombres(String dsnombres) {
        this.dsnombres = dsnombres;
    }

    public String getDesapellidos() {
        return desapellidos;
    }

    public void setDesapellidos(String desapellidos) {
        this.desapellidos = desapellidos;
    }

    public String getDsdireccion() {
        return dsdireccion;
    }

    public void setDsdireccion(String dsdireccion) {
        this.dsdireccion = dsdireccion;
    }
}
