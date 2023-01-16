package com.intensivo.softc.facade;

import com.intensivo.softc.dto.DetalleFactura;
import com.intensivo.softc.exception.FacException;

import java.util.List;

public interface InDetalleFacturaFac {

    public void insert(DetalleFactura d) throws FacException;
    public void delete(DetalleFactura d) throws FacException;
    public List<DetalleFactura> selectall() throws FacException;
}
