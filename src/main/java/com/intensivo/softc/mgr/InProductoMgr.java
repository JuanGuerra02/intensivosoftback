package com.intensivo.softc.mgr;

import com.intensivo.softc.exception.MgrException;
import com.intensivo.softc.dto.Producto;


import java.util.List;

public interface InProductoMgr {

    public void save(Producto p) throws MgrException;

    public void delete( Producto p)throws MgrException;

    public void update(Producto p) throws MgrException;

    public List<Producto>selectall( )throws MgrException;
}
