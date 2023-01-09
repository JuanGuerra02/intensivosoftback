package com.intensivo.softc.dao;

import com.intensivo.softc.dto.Precio;
import com.intensivo.softc.dto.Producto;
import com.intensivo.softc.exception.DaoException;

public interface InPrecioDao {

    public void insert(Precio pdto) throws DaoException;

    public Precio selectbyid(Precio pdto) throws DaoException;
}
