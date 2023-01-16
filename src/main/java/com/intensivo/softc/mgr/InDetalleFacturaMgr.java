package com.intensivo.softc.mgr;

import com.intensivo.softc.dto.DetalleFactura;
import com.intensivo.softc.exception.MgrException;

import java.util.List;

public interface InDetalleFacturaMgr {

    public void insert(DetalleFactura d ) throws MgrException;

    public void delete(DetalleFactura d) throws MgrException;

    public List<DetalleFactura> selectall() throws MgrException;

}
