package com.intensivo.softc.facade;

import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.exception.FacException;

public interface InPrecioFa {

    public void insert(Precio p) throws FacException;
}
