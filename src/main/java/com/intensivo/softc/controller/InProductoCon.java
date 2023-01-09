package com.intensivo.softc.controller;



import com.intensivo.softc.exception.ConException;
import com.intensivo.softc.dto.Producto;

import java.util.List;

public interface InProductoCon {

    public void update(Producto p) throws ConException;

    public void delete(Producto p)throws ConException;

    public List<Producto> selectall( )throws ConException;


}
