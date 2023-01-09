package com.intensivo.softc.facade;



import com.intensivo.softc.exception.FacException;
import com.intensivo.softc.dto.Producto;

import java.util.List;

public interface InProductoFac {
    public void save (Producto p)throws FacException;

    public void delete(Producto p)throws FacException;

    public void update(Producto p)throws FacException;

    public List<Producto> selectall( )throws FacException;

}
