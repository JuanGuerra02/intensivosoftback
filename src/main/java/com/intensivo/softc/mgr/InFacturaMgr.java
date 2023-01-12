package com.intensivo.softc.mgr;

import com.intensivo.softc.dto.Factura;
import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.exception.MgrException;

import java.util.List;

public interface InFacturaMgr {

    public void  insert(Factura f) throws MgrException;

    public void delete(Factura f) throws MgrException;

    public List<Factura> selectall() throws MgrException;

}
