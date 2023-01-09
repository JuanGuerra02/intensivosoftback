package com.intensivo.softc.mgr;

import com.intensivo.softc.dto.Vendedor;
import com.intensivo.softc.exception.MgrException;


import java.util.List;

public interface InVendedorMgr {

    public void save(Vendedor v) throws MgrException;

    public void delete( Vendedor v)throws MgrException;

    public void update(Vendedor v) throws MgrException;

    public List<Vendedor> selectall( )throws MgrException;
}
