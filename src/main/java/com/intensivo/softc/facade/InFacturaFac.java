package com.intensivo.softc.facade;

import com.intensivo.softc.dto.Factura;
import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.exception.FacException;

import java.util.List;

public interface InFacturaFac {
    public void insert(Factura f) throws FacException;
    public void delete(Factura f) throws FacException;
    public List<Factura> selectall() throws FacException;
}
