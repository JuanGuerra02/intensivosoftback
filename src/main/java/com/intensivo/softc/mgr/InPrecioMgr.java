package com.intensivo.softc.mgr;

import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.exception.MgrException;

public interface InPrecioMgr {
    public void  insert(Precio p) throws MgrException;
}
