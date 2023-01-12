package com.intensivo.softc.facade;

import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.exception.FacException;

import java.util.List;

public interface InPrecioFa {

    public void insert(Precio p) throws FacException;
    public void delete(Precio p) throws FacException;
    public List<Precio> selectall() throws FacException;
}
