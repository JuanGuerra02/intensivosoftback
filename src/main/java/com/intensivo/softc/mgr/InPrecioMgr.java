package com.intensivo.softc.mgr;

import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.exception.FacException;
import com.intensivo.softc.exception.MgrException;

import java.util.List;

public interface InPrecioMgr {
    public void  insert(Precio p) throws MgrException;

    public void delete(Precio p) throws MgrException;

    public List<Precio> selectall() throws MgrException;
}
